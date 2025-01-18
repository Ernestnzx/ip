public class TaskFactory {
    public static Task getTask(String commandString, String commandParams) {
        if (commandString.equalsIgnoreCase("todo")) {
            return new ToDo(commandParams);
        }
        if (commandString.equalsIgnoreCase("deadline")) {
            String[] params = commandParams.split("/by");
            return new Deadline(params[0].strip(), params[1].strip());
        }
        if (commandString.equalsIgnoreCase("event")) {
            String[] params = commandParams.split("/from");
            String[] duration = params[1].split("/to");
            return new Event(params[0].strip(), duration[0].strip(), duration[1].strip());
        }
        return null;
    }
}
