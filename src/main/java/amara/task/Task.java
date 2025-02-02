package amara.task;

/**
 * An abstract class representing a contract for various {@link Task} implementations
 * that {@link Amara} keeps track of in her {@code ArrayList<Task>}.
 * <p>
 * A {@code Task} object encapsulates a task's description and its completion status.
 * Concrete subclasses implement specific types of tasks and provide their own behavior
 * for storage formatting.
 * </p>
 */
public abstract class Task {
    protected String taskDescription;
    protected boolean status;

    /**
     * Constructs a {@code Task} with the given description and completion status.
     *
     * @param taskDescription The description of the task.
     * @param status          The completion status of the task.
     */
    public Task(String taskDescription, boolean status) {
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

    public abstract String getSavedFormat();
}
