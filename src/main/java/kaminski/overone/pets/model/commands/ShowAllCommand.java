package kaminski.overone.pets.model.commands;

import kaminski.overone.pets.model.DAO.PetDAO;
import kaminski.overone.pets.model.Pet;
import kaminski.overone.pets.service.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowAllCommand implements ActionCommand{
    @Override
    public String execute(HttpServletRequest request) {

        String page;
        List<Pet> petList;
        PetDAO pets = new PetDAO();
        petList = pets.showAll();

        if (petList!= null){
            request.setAttribute("petList", petList);
            page = new ConfigurationManager().getProperty("path.page.showall_result");
        } else {
            page = new ConfigurationManager().getProperty("path.page.main");
        }
        return page;
    }
}
