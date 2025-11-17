package commands;

import org.junit.jupiter.api.Test;
import testdoubles.TestSalad;
import testdoubles.TestVegetable;

import java.io.ByteArrayInputStream;

class UpdateVegetableCommandTest {

    @Test
    void testValidUpdate() {
        String input = "1\n200\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        TestVegetable veg = new TestVegetable(100, 20);

        TestSalad salad = new TestSalad();
        salad.add(veg);

        UpdateVegetableCommand cmd = new UpdateVegetableCommand(salad);
        cmd.execute();

        assert veg.setWeightCalled;
    }

    @Test
    void testInvalidIndex() {
        String input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        TestSalad salad = new TestSalad();
        salad.add(new TestVegetable(100, 20));

        UpdateVegetableCommand cmd = new UpdateVegetableCommand(salad);
        cmd.execute();

        assert !salad.getVegetables().get(0).toString().contains("200");
    }

    @Test
    void testDescription() {
        TestSalad salad = new TestSalad();
        UpdateVegetableCommand cmd = new UpdateVegetableCommand(salad);

        assert cmd.getDesc().contains("Оновити");
    }
}
