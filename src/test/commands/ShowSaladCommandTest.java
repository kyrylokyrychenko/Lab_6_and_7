package commands;

import org.junit.jupiter.api.Test;
import testdoubles.TestSalad;
import testdoubles.TestVegetable;

class ShowSaladCommandTest {

    @Test
    void testEmptySalad() {
        TestSalad salad = new TestSalad();
        ShowSaladCommand cmd = new ShowSaladCommand(salad);
        cmd.execute();

        assert salad.getVegetables().isEmpty();
    }

    @Test
    void testNonEmptySalad() {
        TestSalad salad = new TestSalad();
        salad.add(new TestVegetable(100, 20));

        ShowSaladCommand cmd = new ShowSaladCommand(salad);
        cmd.execute();

        assert salad.getVegetables().size() == 1;
    }

    @Test
    void testDescription() {
        TestSalad salad = new TestSalad();
        ShowSaladCommand cmd = new ShowSaladCommand(salad);
        assert cmd.getDesc().contains("Показати");
    }
}
