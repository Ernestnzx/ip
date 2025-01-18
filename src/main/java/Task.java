public class Task {
    private String taskDescription;
    private boolean status; 
    
    Task(String taskDescription) {
        this.taskDescription = taskDescription;
        this.status = false;
    }

    String getDescription() {
        return this.taskDescription;
    }

    void markTask() {
        this.status = true;
    }

    void unmarkTask() {
        this.status = false;
    }

    boolean getStatus() {
        return this.status;
    }
}
