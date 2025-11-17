package commands;

import salad.Salad;
import vegetables.Vegetable;
import java.util.Scanner;

public class UpdateVegetableCommand implements Command {

    private Salad salad;
    private Scanner sc = new Scanner(System.in);

    public UpdateVegetableCommand(Salad salad) {
        this.salad = salad;
    }

    @Override
    public void execute() {
        System.out.print("Введіть номер овоча для оновлення: ");
        int index = Integer.parseInt(sc.nextLine());

        if (index < 1 || index > salad.getVegetables().size()) {
            System.out.println("Некоректний номер!");
            return;
        }

        Vegetable v = salad.getVegetables().get(index-1);

        System.out.print("Нова вага (г): ");
        double newWeight = Double.parseDouble(sc.nextLine());

        v.setWeight(newWeight);

        System.out.println("Овоч оновлено.");
    }

    @Override
    public String getDesc() {
        return "Оновити вагу овоча за номером у салаті";
    }
}
