public class AmaraException extends Exception {
    private static final String ERROR_MESSAGE = "OOPS!!! I'm sorry, but I don't know what that means. :(";
    private static final String NUMBER_FORMAT = "OOPS!!! The word that you entered is not a number or empty. :(";
    private static final String WRITE_FILE = "OOPS!!! I cannot write to a file at the moment, try again later. :(";
    private static final String FORMAT_STRING = "OOPS!!! The format for "
            + "%s parameter(s) is/are empty!\n  Usage: %s <description> %s %s";
    private static final String OUT_OF_BOUNDS = "OOPS!!! The index you want to "
            + "mark/unmark/delete is out of bounds. :(";
    private static final String DATE_TIME_FORMAT = "OOPS!!! I don't understand the time/date format " 
            + "that you have given me :(\n  (Format: YYYY-MM-DD HHMM)";

    AmaraException(String message) {
        super(message);
    }

    public static AmaraException invalidCommand() {
        return new AmaraException(ERROR_MESSAGE);
    }

    public static AmaraException invalidParameters(CommandEnum command) throws AmaraException {
        switch (command) {
            case TODO:
                return new AmaraException(String.format(FORMAT_STRING, "todo",
                        "todo", "", ""));
            case DEADLINE:
                return new AmaraException(String.format(FORMAT_STRING, "deadline",
                        "deadline", "/by <time>", ""));
            case EVENT:
                return new AmaraException(String.format(FORMAT_STRING, "event",
                        "event", "/from <start time>", "/to <end time>"));
            default:
                return new AmaraException("OWARI DAAA!!!"); // Should never reach this point
        }
    }

    public static AmaraException indexOutOfBounds() {
        return new AmaraException(OUT_OF_BOUNDS);
    }

    public static AmaraException numberFormatting() {
        return new AmaraException(NUMBER_FORMAT);
    }

    public static AmaraException fileWriteException() {
        return new AmaraException(WRITE_FILE);
    }

    public static AmaraException dateTimeFormatException() {
        return new AmaraException(DATE_TIME_FORMAT);
    }
}
