import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Amara amara = new Amara();
        boolean isExit = false;
        System.out.println(amara.greet());
        while (!isExit) {
            String reply = "";
            String command = scanner.nextLine().strip();
            String commandString = getFirstWord(command);
            String commandParams = removeFirstWord(command);
            if (commandString.equals("bye")) {
                reply = amara.exit();
                isExit = true;
            } else if (commandString.equals("list")) {
                reply = amara.getList();
            } else if (commandString.equals("mark")) {
                reply = amara.markTask(Integer.parseInt(commandParams));
            } else if (commandString.equals("unmark")) {
                reply = amara.unmarkTask(Integer.parseInt(commandParams));
            } else {
                if (commandString.equals("todo")) {
                    reply = amara.addToList(new ToDo(commandParams));
                }
            }
            System.out.println(reply);
        }
        scanner.close();
    }

    static String getFirstWord(String userInput) {
        return userInput.trim().split("\\s+")[0];
    }

    static String removeFirstWord(String userInput) {
        return userInput.replace(getFirstWord(userInput), "").trim();
    }
}
