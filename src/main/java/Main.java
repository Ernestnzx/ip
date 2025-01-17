import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Amara amara = new Amara();
        System.out.println(amara.greet());
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("bye")) {
                System.out.println(amara.exit());
                break;
            }
            System.out.println(amara.echo(command));
        }
        scanner.close();
    }
}
