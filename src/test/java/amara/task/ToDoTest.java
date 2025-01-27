package amara.task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {
    private ToDo toDo = new ToDo("Read lecture notes for CM4215");

    @Test
    public void testToDoFunctionality() {
        assertEquals("[T][ ] Read lecture notes for CM4215", toDo.toString());

        this.toDo.markTask();
        assertEquals("[T][X] Read lecture notes for CM4215", toDo.toString());

        this.toDo.unmarkTask();
        assertEquals("[T][ ] Read lecture notes for CM4215", toDo.toString());

        this.toDo.getSavedFormat();
        assertEquals("T,0,Read lecture notes for CM4215", toDo.getSavedFormat());
    }
}
