import java.util.ArrayList;

public class Amara {
    private static final String BOARDER = "_".repeat(60);

    Amara() {
    }

    private String wrapText(String text) {
        return String.format("%s\n%s\n%s", Amara.BOARDER, text, Amara.BOARDER);
    }

    String greet() {
        return this.wrapText("Hello I'm Amara\nWhat can I do for you?");
    }

    String exit() {
        return this.wrapText("Bye. Hope to see you again soon!");
    }

    String echo(String sentence) {
        return this.wrapText(sentence);
    }
}
