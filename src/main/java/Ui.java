public class Ui {
    private String commandText;
    private static final String BOARDER = "=".repeat(70);

    Ui() {
        this.commandText = "";
    }

    private String wrapText(String text) {
        return String.format("%s\n%s\n%s", Ui.BOARDER, text, Ui.BOARDER);
    }

    public void greet() {
        System.out.println(this.wrapText("Hello I'm Amara\nWhat can I do for you?"));
    }

    public void exit() {
        System.out.println(this.wrapText("Bye. Hope to see you again soon! <3"));
    }

    public void updateCommandText(String commandText) {
        this.commandText = commandText;
    }

    public void printCommandText() {
        System.out.println(this.commandText);
    }
}
