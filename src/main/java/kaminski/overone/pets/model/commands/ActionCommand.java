package kaminski.overone.pets.model.commands;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {
    String execute (HttpServletRequest request);
}
