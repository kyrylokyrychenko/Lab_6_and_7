package commands;

import java.util.Scanner;
import vegetables.*;
import salad.Salad;


public class AddVegetableCommand implements Command {

    private Salad salad;          // Salad з кореневого пакету
    private Scanner sc = new Scanner(System.in);

    public AddVegetableCommand(Salad salad) {
        this.salad = salad;
    }

    @Override
    public void execute() {
        System.out.println("\nОберіть овоч:");
        System.out.println("1 — Морква");
        System.out.println("2 — Помідор");
        System.out.println("3 — Огірок");
        System.out.println("4 — Лук");
        System.out.println("5 — Капуста");
        System.out.println("6 — Перець");
        System.out.print("Ваш вибір: ");

        String choice = sc.nextLine();

        System.out.print("Введіть вагу (в грамах): ");
        double weight = Double.parseDouble(sc.nextLine());

        switch (choice) {
            case "1" -> salad.add(new Carrot(weight));
            case "2" -> salad.add(new Tomato(weight));
            case "3" -> salad.add(new Cucumber(weight));
            case "4" -> salad.add(new Onion(weight));
            case "5" -> salad.add(new Cabbage(weight));
            case "6" -> salad.add(new Pepper(weight));
            default -> System.out.println("Невірний вибір.");
        }
    }

    @Override
    public String getDesc() {
        return "Додати овоч до салату";
    }
}
