package amara.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private static final String stringFormat = "%s,%d,%s,%s,%s";
    private static final DateTimeFormatter dateFormatter = 
            DateTimeFormatter.ofPattern("MMM d yyyy, h:mm a");
    
    public Event(String taskDescription, LocalDateTime startDate, LocalDateTime endDate) {
        super(taskDescription, false);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Event(boolean status, String taskDescription,
            LocalDateTime startDate, LocalDateTime endDate) {
        super(taskDescription, status);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String getSavedFormat() {
        return String.format(Event.stringFormat, "E", this.status ? 1 : 0,
                this.taskDescription, this.startDate, this.endDate);
    }

    @Override
    public String toString() {
        return String.format("[E][%s] %s (from: %s to: %s)", super.status ? "X" : " ", 
                super.taskDescription,
                this.startDate.format(dateFormatter),
                this.endDate.format(dateFormatter));
    }
}