package kaminski.overone.pets.model.DAO;

import kaminski.overone.pets.model.Pet;
import kaminski.overone.pets.service.ConfigurationManager;
import kaminski.overone.pets.service.DataBaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {
    private DataBaseConnector connector;
    private ConfigurationManager manager;

    public PetDAO() {
        this.connector = new DataBaseConnector();
        this.manager = new ConfigurationManager();
    }

    public List<Pet> showAll() {

        Statement statement = null;
        List<Pet> petList = new ArrayList<>();
        String dbCommand = manager.getProperty("db.command.show_all");

        try {
            statement = connector.getStatement();
            ResultSet rs = statement.executeQuery(dbCommand);
            while (rs.next()) {
                Pet pet = new Pet();
                pet.setId(rs.getInt(1));
                pet.setSpecies(rs.getString(2));
                pet.setName(rs.getString(3));
                pet.setAge(rs.getInt(4));
                pet.setColor(rs.getString(5));
                pet.setOwner(rs.getString(6));
                petList.add(pet);
            }
        } catch (SQLException e) {
        } finally {
            connector.closeStatement(statement);
            connector.closeConnection();
        }
        return petList;
    }

    public boolean create(Pet pet) {

        boolean flag = false;
        PreparedStatement preparedStatement = null;
        String dbCommand = manager.getProperty("db.command.create");

        try {
            preparedStatement = connector.getPreparedStatement(dbCommand);
            preparedStatement.setString(1, pet.getSpecies());
            preparedStatement.setString(2, pet.getName());
            preparedStatement.setInt(3, pet.getAge());
            preparedStatement.setString(4, pet.getColor());
            preparedStatement.setString(5, pet.getOwner());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {

        } finally {
            connector.closePreparedStatement(preparedStatement);
            connector.closeConnection();
        }
        return flag;
    }

    public Pet showByID(int id) {
        Pet pet = null;
        PreparedStatement prepStatement = null;
        String dbCommand = manager.getProperty("db.command.show_by_id");

        try {
            prepStatement = connector.getPreparedStatement(dbCommand);
            prepStatement.setInt(1, id);
            ResultSet rs = prepStatement.executeQuery();
            if (rs.next()) {
                pet = new Pet(id, rs.getString(2), rs.getString(3), rs.getInt(4),
                        rs.getString(5), rs.getString(6));
            }
        } catch (SQLException e) {
            System.err.println("request failed!" + e);
        } finally {
            connector.closePreparedStatement(prepStatement);
            connector.closeConnection();
        }
        return pet;
    }

    public boolean editPet(Pet pet) {

        boolean flag = false;
        PreparedStatement preparedStatement = null;
        String dbCommand = manager.getProperty("db.command.edit");
        try {
            preparedStatement = connector.getPreparedStatement(dbCommand);
            preparedStatement.setString(1, pet.getSpecies());
            preparedStatement.setString(2, pet.getName());
            preparedStatement.setInt(3, pet.getAge());
            preparedStatement.setString(4, pet.getColor());
            preparedStatement.setString(5, pet.getOwner());
            preparedStatement.setInt(6, pet.getId());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            connector.closePreparedStatement(preparedStatement);
            connector.closeConnection();
        }
        return flag;
    }

    public boolean deletePet(int id) {

        boolean flag = false;
        PreparedStatement preparedStatement = null;
        String dbCommand = manager.getProperty("db.command.delete");

        try {
            preparedStatement = connector.getPreparedStatement(dbCommand);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            connector.closePreparedStatement(preparedStatement);
            connector.closeConnection();
        }
        return flag;
    }


}
