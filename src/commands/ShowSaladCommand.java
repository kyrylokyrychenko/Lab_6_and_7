package commands;

import salad.Salad;
import vegetables.Vegetable;

public class ShowSaladCommand implements Command {

    private Salad salad;

    public ShowSaladCommand(Salad salad) {
        this.salad = salad;
    }

    @Override
    public void execute() {
        System.out.println("\n=== Склад салату ===");

        int i = 1;
        for (Vegetable v : salad.getVegetables()) {
            System.out.println(i + ": " + v);
            i++;
        }

        if (salad.getVegetables().isEmpty())
            System.out.println("Салат порожній!");
    }

    @Override
    public String getDesc() {
        return "Показати всі овочі в салаті";
    }
}
