package commands;

import org.junit.jupiter.api.Test;
import testdoubles.TestSalad;

class CalculateCaloriesCommandTest {

    @Test
    void testExecutePrintsCalories() {
        TestSalad salad = new TestSalad();
        salad.caloriesToReturn = 123.4;

        CalculateCaloriesCommand cmd = new CalculateCaloriesCommand(salad);
        cmd.execute();

        assert salad.getTotalCalories() == 123.4;
    }

    @Test
    void testDescription() {
        TestSalad salad = new TestSalad();
        CalculateCaloriesCommand cmd = new CalculateCaloriesCommand(salad);
        assert cmd.getDesc().contains("калорійність");
    }
}
