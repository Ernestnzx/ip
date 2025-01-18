import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Amara amara = new Amara();
        System.out.println(amara.greet());
        while (true) {
            String command = scanner.nextLine().strip();
            if (command.equals("bye")) {
                System.out.println(amara.exit());
                break;
            } else if (command.equals("list")) {
                System.out.println(amara.getList());
            } else {
                System.out.println(amara.addToList(command));
            }
        }
        scanner.close();
    }
}
