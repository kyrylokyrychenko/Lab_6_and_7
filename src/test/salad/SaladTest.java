package salad;

import org.junit.jupiter.api.Test;
import testdoubles.TestVegetable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SaladTest {

    @Test
    void testAddVegetable() {
        Salad salad = new Salad();
        salad.add(new TestVegetable(100, 41));

        assertEquals(1, salad.getVegetables().size());
    }

    @Test
    void testAddNullThrows() {
        Salad salad = new Salad();
        assertThrows(IllegalArgumentException.class, () -> salad.add(null));
    }

    @Test
    void testGetVegetablesIsUnmodifiable() {
        Salad salad = new Salad();
        salad.add(new TestVegetable(100, 41));

        List list = salad.getVegetables();
        assertThrows(UnsupportedOperationException.class, () -> list.add(null));
    }

    @Test
    void testRemoveValidIndex() {
        Salad salad = new Salad();
        salad.add(new TestVegetable(50, 20));

        salad.remove(0);

        assertTrue(salad.getVegetables().isEmpty());
    }

    @Test
    void testRemoveInvalidIndex() {
        Salad salad = new Salad();
        assertThrows(IndexOutOfBoundsException.class, () -> salad.remove(1));
    }

    @Test
    void testGetTotalCalories() {
        Salad salad = new Salad();
        salad.add(new TestVegetable(100, 30));  // 30 cal
        salad.add(new TestVegetable(200, 50));  // 100 cal

        assertEquals(130, salad.getTotalCalories());
    }

    @Test
    void testSortByCalories() {
        Salad salad = new Salad();

        TestVegetable v1 = new TestVegetable(200, 10); // 20
        TestVegetable v2 = new TestVegetable(100, 50); // 50

        salad.add(v2);
        salad.add(v1);

        salad.sortByCalories();

        assertEquals(v1, salad.getVegetables().get(0));
    }

    @Test
    void testFindByCalories() {
        Salad salad = new Salad();

        TestVegetable v1 = new TestVegetable(100, 30); // 30
        TestVegetable v2 = new TestVegetable(200, 40); // 80

        salad.add(v1);
        salad.add(v2);

        List result = salad.findByCalories(20, 60);

        assertEquals(1, result.size());
        assertEquals(v1, result.get(0));
    }
}
