public class Deadline extends Task {
    private String dueDate;
    private static final String stringFormat = "%s,%d,%s,%s";

    Deadline(String taskDescription, String dueDate) {
        super(taskDescription, false);
        this.dueDate = dueDate;
    }

    Deadline(boolean status,String taskDescription, String dueDate) {
        super(taskDescription, status);
        this.dueDate = dueDate;
    }

    @Override
    public String getSavedFormat() {
        return String.format(Deadline.stringFormat, "D", this.status ? 1 : 0,
                this.taskDescription, this.dueDate); 
    }

    @Override
    public String toString() {
        return String.format("[D][%s] %s (by: %s)", super.status ? "X" : " ",
                super.taskDescription, this.dueDate);
    }
}
