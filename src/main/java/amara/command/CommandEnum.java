package amara.command;
import amara.exceptions.AmaraException;

public enum CommandEnum {
    BYE,
    LIST,
    MARK,
    UNMARK,
    TODO,
    DEADLINE,
    EVENT,
    DELETE;

    public static CommandEnum fromString(String commandString) throws AmaraException {
        try {
            return CommandEnum.valueOf(commandString.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw AmaraException.invalidCommand();
        }
    }
}