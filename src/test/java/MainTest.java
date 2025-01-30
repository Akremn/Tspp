import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MainTest {

    // Приклад: клас, який ми будемо мокати
    static class Dependency {
        public String getMessage() {
            return "Real Message";
        }
    }

    private Dependency mockDependency;

    @BeforeEach
    public void setUp() {
        // Створюємо мок об'єкта Dependency
        mockDependency = Mockito.mock(Dependency.class);
        // Налаштовуємо мок, щоб він повертав певне значення при виклику методу
        when(mockDependency.getMessage()).thenReturn("Mocked Message");
    }

    @Test
    public void testWithMock() {
        // Тестуємо метод, який використовує мок
        System.out.println(mockDependency.getMessage()); // Виведе "Mocked Message"
    }
}
