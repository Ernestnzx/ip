package amara.command;

import amara.exceptions.AmaraException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParserTest {
    @Test
    public void testInvalidCommand() {
        AmaraException exception = assertThrows(AmaraException.class, 
                () -> Parser.parseCommand("Chemistry is best major! :3"));
        assertEquals(AmaraException.invalidCommand().getMessage(), exception.getMessage());
    }
}
