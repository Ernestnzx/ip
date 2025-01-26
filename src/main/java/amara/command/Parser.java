package amara.command;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import amara.exceptions.AmaraException;
import amara.task.Deadline;
import amara.task.Event;
import amara.task.ToDo;

/**
 * Parses the given input command string and returns the corresponding 
 * {@link Command} object to be executed.
 */
public class Parser {
    /**
     * The method extracts the first word of the input string to determine the command type 
     * and parses the remaining string for command-specific parameters. The recognized 
     * commands are defined in {@link CommandEnum}.
     * @param fullCommand The full input string representing the user's command.
     * @return A {@link Command} object that corresponds to the parsed command.
     * @throws AmaraException If the command is invalid or if an error occurs while parsing.
     */
    public static Command parseCommand(String fullCommand) throws AmaraException {
        String commandString = Parser.getFirstWord(fullCommand);
        String commandParams = Parser.removeFirstWord(fullCommand);
        CommandEnum commandEnum = CommandEnum.fromString(commandString);
        switch (commandEnum) {
            case BYE:
                return new ByeCommand();
            case LIST:
                return new ListCommand();
            case MARK:
                return new MarkCommand(Parser.getIndex(commandParams));
            case UNMARK:
                return new UnmarkCommand(Parser.getIndex(commandParams));
            case DELETE:
                return new DeleteCommand(Parser.getIndex(commandParams));
            case TODO:
                return new AddToDoCommand(Parser.getToDo(commandParams));
            case DEADLINE:
                return new AddDeadlineCommand(Parser.getDeadline(commandParams));
            case EVENT:
                return new AddEventCommand(Parser.getEvent(commandParams));
            default:
                throw AmaraException.invalidCommand();
        }
    }

    private static String getFirstWord(String fullCommand) {
        return fullCommand.trim().split("\\s+")[0];
    }

    private static String removeFirstWord(String fullCommand) {
        return fullCommand.replace(getFirstWord(fullCommand), "").trim();
    }

    private static int getIndex(String commandParams) throws AmaraException {
        try {
            return Integer.parseInt(commandParams);
        } catch (NumberFormatException e){
            throw AmaraException.numberFormatting();
        }
    }

    private static ToDo getToDo(String commandParams) throws AmaraException {
        if (commandParams.isBlank()) {
            throw AmaraException.invalidToDoParameter();
        }
        return new ToDo(commandParams);
    }

    private static Deadline getDeadline(String commandParams) throws AmaraException {
        String[] tokens = commandParams.split("/by");
        try {
            if (tokens.length != 2 || tokens[0].isBlank()) {
                throw AmaraException.invalidDeadlineParameter();
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
            LocalDateTime dateTime = LocalDateTime.parse(tokens[1].strip(), formatter);
            return new Deadline(tokens[0].strip(), dateTime);
        } catch (DateTimeParseException e) {
            throw AmaraException.dateTimeFormatException();
        } catch (AmaraException e) {
            throw e;
        }
    }

    private static Event getEvent(String commandParams) throws AmaraException {
        String[] tokens = commandParams.split("/from");
        try {
            if (tokens.length != 2 || tokens[0].isBlank()) {
                throw AmaraException.invalidEventParameter();
            }
            String[] duration = tokens[1].split("/to");
            if (duration.length != 2) {
                throw AmaraException.invalidEventParameter();
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
            LocalDateTime fromDateTime = LocalDateTime.parse(duration[0].strip(), formatter);
            LocalDateTime toDateTime = LocalDateTime.parse(duration[1].strip(), formatter);
            return new Event(tokens[0].strip(), fromDateTime, toDateTime);
        } catch (DateTimeParseException e) {
            throw AmaraException.dateTimeFormatException();
        } catch (AmaraException e) {
            throw e;
        }
    }
}
