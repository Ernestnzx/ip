package amara.storage;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import amara.task.Task;

public class StorageTest {
    private Storage noFileStorage = new Storage("./src/test/java/amara/storage/nofile.txt");

    @Test
    public void noFileStorageTest() {
        ArrayList<Task> tasks = new ArrayList<Task>();
        assertDoesNotThrow(() -> this.noFileStorage.saveList(tasks));
    }
}
