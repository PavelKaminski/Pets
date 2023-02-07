package kaminski.overone.pets.model.commands;

public enum CommandEnum {

    SHOWALL{
        {
            this.command = new ShowAllCommand();
        }
    },
    CREATE {
        {
            this.command = new CreateCommand();
        }
    },
    SHOWBYID {
        {
            this.command = new ShowByIDCommand();
        }
    },
    EDITFORM {
        {
            this.command = new ToEditFormCommand();
        }
    },
    EDIT {
        {
            this.command = new EditCommand();
        }
    },
    DELETE {
        {
            this.command = new DeleteCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
