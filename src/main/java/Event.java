public class Event extends Task {
    private String startDate;
    private String endDate;
    
    Event(String taskDescription, String startDate, String endDate) {
        super(taskDescription, false);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return String.format("[E][%s] %s (from: %s to: %s)", super.status ? "X" : " ", 
                super.taskDescription, this.startDate, this.endDate);
    }
}