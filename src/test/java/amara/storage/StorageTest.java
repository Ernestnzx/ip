package amara.storage;

import java.util.ArrayList;

import amara.exceptions.AmaraException;
import amara.task.Task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StorageTest {
    Storage noFileStorage = new Storage("./src/test/java/amara/storage/nofile.txt");
    Storage invalidStorage = new Storage("./src/test/java/amara/storage/invalidfile.txt");

    // @Test
    // public void noFileStorageTest() {
    //     ArrayList<Task> tasks = new ArrayList<Task>();
    //     assertThrows(AmaraException.class, () -> this.noFileStorage.saveList(tasks));
    // }

    @Test
    public void invalidFileFormatTest() {
        assertThrows(AmaraException.class, () -> this.invalidStorage.readList());
    }
}
