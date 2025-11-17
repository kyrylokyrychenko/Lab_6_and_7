import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    // Спрощена тестова версія Menu, щоб замінити Scanner та команди
    static class TestMenu extends Menu {
        @Override
        protected void init() {
            getCommands().clear();
            getCommands().put("test", new testdoubles.CommandTest("desc"));
        }
    }

    @Test
    void testInitCreatesCommands() {
        TestMenu menu = new TestMenu();
        assertTrue(menu.getCommands().containsKey("test"));
    }

    @Test
    void testExecuteValidCommand() {
        TestMenu menu = new TestMenu();
        testdoubles.CommandTest cmd =
                (testdoubles.CommandTest) menu.getCommands().get("test");

        menu.execute("test");

        assertTrue(cmd.executed);
    }

    @Test
    void testExecuteInvalidCommand() {
        TestMenu menu = new TestMenu();

        // Невалідний ключ НЕ повинен кидати помилку
        assertDoesNotThrow(() -> menu.execute("wrong"));
    }

    @Test
    void testStartStopsOnExit() {
        String input = "вихід\n";  // одразу завершуємо цикл
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        TestMenu menu = new TestMenu();

        assertDoesNotThrow(menu::start);
    }

    @Test
    void testStartExecutesCommand() {
        String input = "test\nвихід\n"; // виконуємо команду, потім вихід
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        TestMenu menu = new TestMenu();
        testdoubles.CommandTest cmd =
                (testdoubles.CommandTest) menu.getCommands().get("test");

        menu.start();

        assertTrue(cmd.executed);
    }
}
