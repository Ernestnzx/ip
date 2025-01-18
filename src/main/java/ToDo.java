public class ToDo extends Task {
    ToDo(String taskDescription) {
        super(taskDescription, false);
    }

    @Override
    public String toString() {
        return String.format("[D][%s] %s", this.status ? "X" : " ", this.taskDescription);
    }
}
