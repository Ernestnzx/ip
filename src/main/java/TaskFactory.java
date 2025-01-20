public class TaskFactory {
    public static Task getTask(Command commandEnum, String commandParams) throws AmaraException {
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

    private static Task getToDo(Command commandEnum, String commandParams) throws AmaraException {
        if (commandParams.isBlank()) {
            throw AmaraException.invalidParameters(commandEnum);
        }
        return new ToDo(commandParams);
    }

    private static Task getDeadlines(Command commandEnum, String commandParams) throws AmaraException {
        String[] params = commandParams.split("/by");
        if (params.length != 2 || params[0].isBlank() || params[1].isBlank()) {
            throw AmaraException.invalidParameters(commandEnum);
        }
        return new Deadline(params[0].strip(), params[1].strip());
    }

    private static Task getEvent(Command commandEnum, String commandParams) throws AmaraException {
        String[] params = commandParams.split("/from");
        if (params.length != 2 || params[0].isBlank() || params[1].isBlank()) {
            throw AmaraException.invalidParameters(commandEnum);
        }
        String[] duration = params[1].split("/to");
        if (duration.length != 2 || duration[0].isBlank() || duration[1].isBlank()) {
            throw AmaraException.invalidParameters(commandEnum);
        }
        return new Event(params[0].strip(), duration[0].strip(), duration[1].strip());
    }
}
