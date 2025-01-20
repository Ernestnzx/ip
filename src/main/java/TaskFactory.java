public class TaskFactory {
    public static Task getTask(String commandString, String commandParams) throws AmaraException {
        Command command = Command.fromString(commandString);
        switch (command) {
            case TODO:
                return TaskFactory.getToDo(commandString, commandParams);
            case DEADLINE:
                return TaskFactory.getDeadlines(commandString, commandParams);
            case EVENT:
                return TaskFactory.getEvent(commandString, commandParams);
            default:
                throw AmaraException.invalidCommand();
        }
    }

    private static Task getToDo(String commandString, String commandParams) throws AmaraException {
        if (commandParams.isBlank()) {
            throw AmaraException.invalidParameters(commandString);
        }
        return new ToDo(commandParams);
    }

    private static Task getDeadlines(String commandString, String commandParams) throws AmaraException {
        String[] params = commandParams.split("/by");
        if (params.length != 2 || params[0].isBlank() || params[1].isBlank()) {
            throw AmaraException.invalidParameters(commandString);
        }
        return new Deadline(params[0].strip(), params[1].strip());
    }

    private static Task getEvent(String commandString, String commandParams) throws AmaraException {
        String[] params = commandParams.split("/from");
        if (params.length != 2 || params[0].isBlank() || params[1].isBlank()) {
            throw AmaraException.invalidParameters(commandString);
        }
        String[] duration = params[1].split("/to");
        if (duration.length != 2 || duration[0].isBlank() || duration[1].isBlank()) {
            throw AmaraException.invalidParameters(commandString);
        }
        return new Event(params[0].strip(), duration[0].strip(), duration[1].strip());
    }
}
