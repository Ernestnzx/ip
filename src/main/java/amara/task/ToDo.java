package amara.task;
public class ToDo extends Task {
    private static final String stringFormat = "%s,%d,%s";

    public ToDo(String taskDescription) {
        super(taskDescription, false);
    }

    public ToDo(boolean status, String taskDescription) {
        super(taskDescription, status);
    }

    @Override
    public String getSavedFormat() {
        return String.format(ToDo.stringFormat, "T", this.status ? 1 : 0,
                this.taskDescription);
    }

    @Override
    public String toString() {
        return String.format("[T][%s] %s", this.status ? "X" : " ", this.taskDescription);
    }
}
