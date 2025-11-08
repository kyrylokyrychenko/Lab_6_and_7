import java.util.*;
import function.*;

class Menu {
    private Map<String, Command> commands = new LinkedHashMap<>();

    public Menu() {
        commands.put("додати", new AddVegetableCommand());
        commands.put("показати", new ShowSaladCommand());
        commands.put("підрахувати", new CalculateCaloriesCommand());
        commands.put("сортувати", new SortVegetablesCommand());
        commands.put("знайти", new FindVegetablesByCaloriesCommand());
        commands.put("видалити", new RemoveVegetableCommand());
        commands.put("оновити", new UpdateVegetableCommand());
        commands.put("вихід", new ExitCommand());
    }

    public void show() {
        System.out.println("\n===== МЕНЮ САЛАТУ =====");
        System.out.println("додати - Додати овоч до салату");
        System.out.println("показати - Показати список овочів");
        System.out.println("підрахувати - Підрахувати калорійність салату");
        System.out.println("сортувати - Сортувати овочі за параметром");
        System.out.println("знайти - Знайти овочі за діапазоном калорійності");
        System.out.println("видалити - Видалити овоч із салату");
        System.out.println("оновити - Оновити дані про овоч");
        System.out.println("вихід - Вихід");
    }

    public void execute(String choice) {
        Command command = commands.get(choice);
        if (command != null)
            command.execute();
        else
            System.out.println("Невірний вибір!");
    }
}
