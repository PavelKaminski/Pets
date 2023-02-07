package kaminski.overone.pets.service;

import java.sql.*;


public class DataBaseConnector {
    private Connection cn = null;
    public DataBaseConnector() {

        ConfigurationManager manager = new ConfigurationManager();
        String dbDriver = manager.getProperty("db.connection.driver");
        String dbURL = manager.getProperty("db.connection.url");
        String dbUser = manager.getProperty("db.connection.user");
        String dbPassword = manager.getProperty("db.connection.password");
        try {
            Class.forName(dbDriver);
            cn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
        } catch (SQLException e) {
            System.err.println("DB connection failed!" + e);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver class not found" + e);
        }
    }

    public Statement getStatement() throws SQLException {
        if (cn != null) {
            Statement statement = cn.createStatement();
            if (statement != null)
                return statement;
        }
        throw new SQLException("connection or statement is null");
    }

    public PreparedStatement getPreparedStatement(String action) throws SQLException {
        if (cn != null) {
            PreparedStatement prepStatement = cn.prepareStatement(action);
            if (prepStatement != null)
                return prepStatement;
        }
        throw new SQLException("connection or statement is null");
    }

    public void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.err.println("statement is null! " + e);
            }
        }
    }

    public void closePreparedStatement(PreparedStatement prepStatement) {
        if (prepStatement != null) {
            try {
                prepStatement.close();
            } catch (SQLException e) {
                System.err.println("prepared statement is null!" + e);
            }
        }
    }

    public void closeConnection() {
        if (cn != null) {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error while closing connection!" + e);
            }
        }
    }
}
