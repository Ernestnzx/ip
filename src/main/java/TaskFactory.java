import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskFactory {
    public static Task getTask(CommandEnum commandEnum, String commandParams) throws AmaraException {
        switch (commandEnum) {
            case TODO:
                return TaskFactory.getToDo(commandEnum, commandParams);
            case DEADLINE:
                return TaskFactory.getDeadlines(commandEnum, commandParams);
            case EVENT:
                return TaskFactory.getEvent(commandEnum, commandParams);
            default:
                throw AmaraException.invalidCommand();
        }
    }

    private static Task getToDo(CommandEnum commandEnum, String commandParams) throws AmaraException {
        if (commandParams.isBlank()) {
            throw AmaraException.invalidParameters(commandEnum);
        }
        return new ToDo(commandParams);
    }

    private static Task getDeadlines(CommandEnum commandEnum, String commandParams) throws AmaraException {
        String[] params = commandParams.split("/by");
        if (params.length != 2 || params[0].isBlank() || params[1].isBlank()) {
            throw AmaraException.invalidParameters(commandEnum);
        }
        try {
            LocalDateTime dateTime = parseDateTime(params[1].strip());
            return new Deadline(params[0].strip(), dateTime);
        } catch (Exception e){
            throw AmaraException.dateTimeFormatException(); 
        }
    }

    private static Task getEvent(CommandEnum commandEnum, String commandParams) throws AmaraException {
        String[] params = commandParams.split("/from");
        if (params.length != 2 || params[0].isBlank() || params[1].isBlank()) {
            throw AmaraException.invalidParameters(commandEnum);
        }
        String[] duration = params[1].split("/to");
        if (duration.length != 2 || duration[0].isBlank() || duration[1].isBlank()) {
            throw AmaraException.invalidParameters(commandEnum);
        }
        try {
            LocalDateTime fromDateTime = parseDateTime(duration[0].strip());
            LocalDateTime toDateTime = parseDateTime(duration[1].strip());
            return new Event(params[0].strip(), fromDateTime, toDateTime);
        } catch (Exception e) {
            throw AmaraException.dateTimeFormatException();
        }
    }

    private static LocalDateTime parseDateTime(String dateTime) throws AmaraException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
            return LocalDateTime.parse(dateTime, formatter);
        } catch (Exception e) {
            throw AmaraException.dateTimeFormatException();
        }
    }
}
