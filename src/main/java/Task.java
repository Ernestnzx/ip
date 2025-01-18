public abstract class Task {
    protected String taskDescription;
    protected boolean status;

    Task(String taskDescription, boolean status) {
        this.taskDescription = taskDescription;
        this.status = status;
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }

    public void markTask() {
        this.status = true;
    }

    public void unmarkTask() {
        this.status = false;
    }

    public boolean getStatus() {
        return this.status;
    }
}
