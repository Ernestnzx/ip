package amara.storage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import amara.exceptions.AmaraException;
import amara.task.Deadline;
import amara.task.Event;
import amara.task.Task;
import amara.task.ToDo;

/**
 * Handles the saving and loading of tasks to and from a file.
 * <p>
 * The {@code Storage} class is responsible for writing the task list to a file
 * and reading it back when needed. It uses a specified file path to locate
 * the storage file.
 * </p>
 */
public class Storage {
    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Writes all of the task in the given task list into the file
     * that will be read in when AmaraBot starts up
     * @param tasks
     * @throws AmaraException More specifically a AmaraException.fileWriteException
     */
    public void saveList(ArrayList<Task> tasks) throws AmaraException {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            stringBuilder.append(tasks.get(i).getSavedFormat());
            if (i < tasks.size() - 1) {
                stringBuilder.append("\n");
            }
        }
        try (FileWriter writer = new FileWriter(this.filePath)) {
            writer.write(stringBuilder.toString());
        } catch (IOException e) {
            throw AmaraException.fileWriteException();
        }
    }

    /**
     * Reads all of lines in the given file and converts it into
     * a {@link Task} list and given back to Amara Bot.
     * @return {@code ArrayList<Task>} from the previous session.
     * @throws IOException Thrown if BufferedReader is unable to be declared.
     * @throws AmaraException Thrown if Task format is not consistent.
     */
    public ArrayList<Task> readList() throws IOException, AmaraException {
        BufferedReader br = new BufferedReader(new FileReader(this.filePath));
        String line = "";
        ArrayList<Task> tasks = new ArrayList<Task>();
        while ((line = br.readLine()) != null) {
            try {
                String[] tokens = line.strip().split(",");
                String taskType = tokens[0];
                boolean status = tokens[1].equals("1") ? true : false;
                String description = tokens[2];

                switch (taskType) {
                case "T":
                    tasks.add(new ToDo(status, description));
                    break;
                case "D":
                    LocalDateTime dueDate = LocalDateTime.parse(tokens[3]);
                    tasks.add(new Deadline(status, description, dueDate));
                    break;
                case "E":
                    LocalDateTime fromDateTime = LocalDateTime.parse(tokens[3]);
                    LocalDateTime toDateTime = LocalDateTime.parse(tokens[4]);
                    tasks.add(new Event(status, description, fromDateTime, toDateTime));
                    break;
                default:
                    throw AmaraException.fileFormatException();
                }
            } catch (Exception e) {
                br.close();
                throw AmaraException.fileFormatException();
            }
        }
        br.close();
        return tasks;
    }
}
