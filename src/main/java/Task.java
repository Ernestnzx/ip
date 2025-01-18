public interface Task {
    void markTask();

    void unmarkTask();

    boolean getStatus();

    String getTaskDescription();
}
