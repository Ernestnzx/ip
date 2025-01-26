import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Memory {
    private static final String FILE_PATH = "./tasklist.txt";

    public void saveList(ArrayList<Task> tasks) throws AmaraException {
        StringBuilder stringBuilder = new StringBuilder();
        for (Task task : tasks) {
            stringBuilder.append(task.getSavedFormat() + "\n");
        }
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(stringBuilder.toString());
        } catch (Exception e) {
            throw AmaraException.fileWriteException();
        }
    }

    public ArrayList<Task> readList() throws IOException, AmaraException {
        BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
        String line = "";
        ArrayList<Task> tasks = new ArrayList<Task>();
        while ((line = br.readLine()) != null) {
            String[] tokens = line.strip().split(",");
            boolean status = tokens[1].equals("1") ? true : false;
            switch (tokens[0]) {
                case "T":
                    tasks.add(new ToDo(status, tokens[2]));
                    break;
                case "D":
                    tasks.add(new Deadline(status, tokens[2],
                            LocalDateTime.parse(tokens[3])));
                    break;
                case "E":
                    tasks.add(new Event(status, tokens[2],
                            LocalDateTime.parse(tokens[3]),
                            LocalDateTime.parse(tokens[4])));
                    break;
                default:
                    throw new AmaraException("Format used for the file is wrong :(\n");
            }
        }
        br.close();
        return tasks;
    }
}
