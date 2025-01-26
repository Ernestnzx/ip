package amara.task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {
    private ToDo toDo = new ToDo("Read lecture notes for CM4215");

    @Test
    public void addToDo() {
        assertEquals("[T][ ] Read lecture notes for CM4215", toDo.toString());
    }

    @Test
    public void markToDo() {
        this.toDo.markTask();
        assertEquals("[T][X] Read lecture notes for CM4215", toDo.toString());
    }

    @Test
    public void unmarkToDo() {
        this.toDo.unmarkTask();
        assertEquals("[T][ ] Read lecture notes for CM4215", toDo.toString());
    }

    @Test
    public void getSavedFormat() {
        this.toDo.getSavedFormat();
        assertEquals("T,0,Read lecture notes for CM4215", toDo.getSavedFormat());
    }
}
