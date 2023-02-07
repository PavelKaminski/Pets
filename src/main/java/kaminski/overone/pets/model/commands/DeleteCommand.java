package kaminski.overone.pets.model.commands;

import kaminski.overone.pets.model.DAO.PetDAO;
import kaminski.overone.pets.service.ConfigurationManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class DeleteCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        String page;
        ConfigurationManager manager = new ConfigurationManager();
        int petID = 0;

        try {
            petID = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            System.err.println(e);
        }
        PetDAO petDAO = new PetDAO();
        boolean result = petDAO.deletePet(petID);

        if (result) {
            request.setAttribute("message", manager.getProperty("message.result.delete"));
            HttpSession session = request.getSession();
            session.invalidate();
        } else {
            request.setAttribute("message", manager.getProperty("message.result.error"));
        }
        page = manager.getProperty("path.page.result");
        return page;
    }
}
