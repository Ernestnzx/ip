public class Event implements Task {
    private String taskDescription;
    private String dueDate;
    private boolean status; 
    
    Event(String taskDescription, String dueDate) {
        this.taskDescription = taskDescription;
        this.dueDate = dueDate;
        this.status = false;
    }

    @Override
    public String getTaskDescription() {
        return this.taskDescription;
    }

    @Override
    public void markTask() {
        this.status = true;
    }

    @Override
    public void unmarkTask() {
        this.status = false;
    }

    @Override
    public boolean getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return String.format("[E][%s] %s (by: %s)", this.status ? "X" : " ", this.taskDescription, this.dueDate);
    }
}
