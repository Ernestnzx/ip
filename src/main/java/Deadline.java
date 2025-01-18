public class Deadline extends Task {
    private String dueDate;

    Deadline(String taskDescription, String dueDate) {
        super(taskDescription, false);
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return String.format("[D][%s] %s (by: %s)", super.status ? "X" : " ",
                super.taskDescription, this.dueDate);
    }
}
