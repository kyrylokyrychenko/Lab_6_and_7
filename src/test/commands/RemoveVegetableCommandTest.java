package commands;

import org.junit.jupiter.api.Test;
import testdoubles.TestSalad;
import testdoubles.TestVegetable;

import java.io.ByteArrayInputStream;

class RemoveVegetableCommandTest {

    @Test
    void testValidIndex() {
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        TestSalad salad = new TestSalad();
        salad.add(new TestVegetable(100, 20));

        RemoveVegetableCommand cmd = new RemoveVegetableCommand(salad);
        cmd.execute();

        assert salad.getVegetables().isEmpty();
    }

    @Test
    void testInvalidIndex() {
        String input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        TestSalad salad = new TestSalad();
        salad.add(new TestVegetable(100, 20));

        RemoveVegetableCommand cmd = new RemoveVegetableCommand(salad);
        cmd.execute();

        assert salad.getVegetables().size() == 1;
    }

    @Test
    void testDescription() {
        TestSalad salad = new TestSalad();
        RemoveVegetableCommand cmd = new RemoveVegetableCommand(salad);
        assert cmd.getDesc().contains("Видалити");
    }
}
