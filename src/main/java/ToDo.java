public class ToDo implements Task {
    private String taskDescription;
    private boolean status; 
    
    ToDo(String taskDescription) {
        this.taskDescription = taskDescription;
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
        return String.format("[D][%s] %s", this.status ? "X" : " ", this.taskDescription);
    }
}
