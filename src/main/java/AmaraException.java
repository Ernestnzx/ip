public class AmaraException extends Exception {
    private static final String ITS_THE_END = "OWARI DAAAAA!!!!!!";
    private static final String ERROR_MESSAGE = "OOPS!!! I'm sorry, but I don't know what that means. :(";
    private static final String OUT_OF_BOUNDS = "OOPS!!! The index you want to mark/unmark is out of bounds. :(";
    private static final String NUMBER_FORMAT = "OOPS!!! The word that you entered is not a number or empty. :(";
    private static final String FORMAT_STRING = "OOPS!!! The format for "
            + "%s parameter(s) is/are empty!\n  Usage: %s <description> %s %s";

    AmaraException(String message) {
        super(message);
    }

    public static AmaraException invalidCommand() {
        return new AmaraException(ERROR_MESSAGE);
    }

    public static AmaraException invalidParameters(String commandString) {
        if (commandString.equalsIgnoreCase("todo")) {
            return new AmaraException(String.format(FORMAT_STRING, "todo",
                    "todo", "", ""));
        }
        if (commandString.equalsIgnoreCase("deadline")) {
            return new AmaraException(String.format(FORMAT_STRING, "deadline",
                    "deadline", "/by <time>", ""));
        }
        if (commandString.equalsIgnoreCase("event")) {
            return new AmaraException(String.format(FORMAT_STRING, "event",
                    "event", "/from <start time>", "/to <end time>"));
        }
        return new AmaraException(ITS_THE_END); // Should never reach this point
    }

    public static AmaraException indexOutOfBounds() {
        return new AmaraException(OUT_OF_BOUNDS);
    }

    public static AmaraException numberFormatting() {
        return new AmaraException(NUMBER_FORMAT);
    }
}
