package amara.task;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a deadline task, a task with a single dateline to complete.
 * <p>
 * A {@code Deadline} task stores a description, a ompletion status and a due date. 
 * It can be serialized into a saveable format and displayed in a user-friendly 
 * string format.
 * </p>
 */
public class Deadline extends Task {
    private LocalDateTime dueDate;
    private static final String stringFormat = "%s,%d,%s,%s";
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMM d yyyy, h:mm a");

    public Deadline(String taskDescription, LocalDateTime dueDate) {
        super(taskDescription, false);
        this.dueDate = dueDate;
    }

    public Deadline(boolean status,String taskDescription, LocalDateTime dueDate) {
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
                super.taskDescription,
                this.dueDate.format(dateFormatter));
    }
}
