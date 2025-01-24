public class Event extends Task {
    private String startDate;
    private String endDate;
    private static final String stringFormat = "%s,%d,%s,%s,%s";
    
    Event(String taskDescription, String startDate, String endDate) {
        super(taskDescription, false);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    Event(boolean status, String taskDescription, String startDate, String endDate) {
        super(taskDescription, status);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String getSavedFormat() {
        return String.format(Event.stringFormat, "E", this.status ? 1 : 0,
                this.taskDescription, this.startDate, this.endDate);
    }

    @Override
    public String toString() {
        return String.format("[E][%s] %s (from: %s to: %s)", super.status ? "X" : " ", 
                super.taskDescription, this.startDate, this.endDate);
    }
}