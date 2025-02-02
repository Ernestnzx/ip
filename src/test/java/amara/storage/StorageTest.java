package amara.storage;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import amara.exceptions.AmaraException;
import amara.task.Task;

public class StorageTest {
    private Storage noFileStorage = new Storage("./src/test/java/amara/storage/nofile.txt");
    private Storage invalidStorage = new Storage("./src/test/java/amara/storage/invalidfile.txt");

    @Test
    public void noFileStorageTest() {
        ArrayList<Task> tasks = new ArrayList<Task>();
        assertDoesNotThrow(() -> this.noFileStorage.saveList(tasks));
    }

    @Test
    public void invalidFileFormatTest() {
        assertThrows(AmaraException.class, () -> this.invalidStorage.readList());
    }
}
