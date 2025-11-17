package commands;

import org.junit.jupiter.api.Test;
import testdoubles.TestSalad;
import testdoubles.TestVegetable;

import java.io.ByteArrayInputStream;

class FindVegetablesByCaloriesCommandTest {

    @Test
    void testExecute() {
        String input = "10\n50\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        TestSalad salad = new TestSalad();
        salad.add(new TestVegetable(100, 30));

        FindVegetablesByCaloriesCommand cmd =
                new FindVegetablesByCaloriesCommand(salad);

        cmd.execute();

        assert salad.findCalled;
        assert salad.min == 10;
        assert salad.max == 50;
    }

    @Test
    void testDescription() {
        TestSalad salad = new TestSalad();
        FindVegetablesByCaloriesCommand cmd =
                new FindVegetablesByCaloriesCommand(salad);
        assert cmd.getDesc().contains("діапазоном");
    }
}
