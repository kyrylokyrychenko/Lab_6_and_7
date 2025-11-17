package commands;

import salad.Salad;
import java.util.Scanner;

public class RemoveVegetableCommand implements Command {

    private Salad salad;
    private Scanner sc = new Scanner(System.in);

    public RemoveVegetableCommand(Salad salad) {
        this.salad = salad;
    }

    @Override
    public void execute() {
        System.out.print("Введіть номер овоча для видалення: ");
        int index = Integer.parseInt(sc.nextLine());
        if (index < 1 || index > salad.getVegetables().size()) {
            System.out.println("Некоректний номер!");
            return;
        }
        salad.remove(index-1);
        System.out.println("Овоч видалено (якщо індекс був коректним).");
    }

    @Override
    public String getDesc() {
        return "Видалити овоч за номером у салаті";
    }
}
