import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);

        while (true) {
            menu.show();
            System.out.print("Виберіть пункт меню: ");
            String choice = sc.nextLine();
            menu.execute(choice);
        }
    }
}
