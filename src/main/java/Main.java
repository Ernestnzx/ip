import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Amara amara = new Amara();
        boolean isExit = false;
        System.out.println(amara.greet());
        while (!isExit) {
            String command = scanner.nextLine().strip();
            String[] tokens = command.split(" ");
            String reply = "";
            if (tokens[0].equals("bye")) {
                reply = amara.exit();
                isExit = true;
            } else if (tokens[0].equals("list")) {
                reply = amara.getList();
            } else if (tokens[0].equals("mark")) {
                reply = amara.markTask(Integer.parseInt(tokens[1]));
            } else if (tokens[0].equals("unmark")) {
                reply = amara.unmarkTask(Integer.parseInt(tokens[1]));
            } else {
                reply = amara.addToList(command);
            }
            System.out.println(reply);
        }
        scanner.close();
    }
}
