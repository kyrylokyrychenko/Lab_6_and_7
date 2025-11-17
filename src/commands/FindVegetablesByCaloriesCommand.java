package commands;

import salad.Salad;
import vegetables.Vegetable;
import java.util.List;
import java.util.Scanner;

public class FindVegetablesByCaloriesCommand implements Command {

    private Salad salad;
    private Scanner sc = new Scanner(System.in);

    public FindVegetablesByCaloriesCommand(Salad salad) {
        this.salad = salad;
    }

    @Override
    public void execute() {
        System.out.print("Мінімум калорій: ");
        double min = Double.parseDouble(sc.nextLine());

        System.out.print("Максимум калорій: ");
        double max = Double.parseDouble(sc.nextLine());

        List<Vegetable> res = salad.findByCalories(min, max);

        System.out.println("\nОвочі в цьому діапазоні:");
        if (res.isEmpty()) {
            System.out.println("Нічого не знайдено.");
            return;
        }

        for (Vegetable v : res) {
            System.out.println(v);
        }
    }

    @Override
    public String getDesc() {
        return "Знайти овочі за діапазоном калорій";
    }
}
