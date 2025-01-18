public class Event extends Task {
    private String dueDate;
    
    Event(String taskDescription, String dueDate) {
        super(taskDescription, false);
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return String.format("[E][%s] %s (by: %s)", super.status ? "X" : " ", super.taskDescription, this.dueDate);
    }
}
