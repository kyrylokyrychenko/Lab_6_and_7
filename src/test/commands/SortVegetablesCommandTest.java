package commands;

import org.junit.jupiter.api.Test;
import testdoubles.TestSalad;

class SortVegetablesCommandTest {

    @Test
    void testSorting() {
        TestSalad salad = new TestSalad();

        SortVegetablesCommand cmd = new SortVegetablesCommand(salad);
        cmd.execute();

        assert salad.sortCalled;
    }

    @Test
    void testDescription() {
        TestSalad salad = new TestSalad();
        SortVegetablesCommand cmd = new SortVegetablesCommand(salad);
        assert cmd.getDesc().contains("Сортувати");
    }
}
