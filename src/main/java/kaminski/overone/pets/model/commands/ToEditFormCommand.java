package kaminski.overone.pets.model.commands;

import kaminski.overone.pets.service.ConfigurationManager;
import javax.servlet.http.HttpServletRequest;

public class ToEditFormCommand implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        ConfigurationManager manager = new ConfigurationManager();

        page= manager.getProperty("path.page.edit_form");
        return page;
    }
}
