package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SportCompetitionTest {

    // Тест на правильність запуску змагання
    @Test
    public void testStartCompetition() {
        // Створюємо об'єкт SportCompetition з назвою та кількістю учасників
        SportCompetition competition = new SportCompetition("Футбольний турнір", 10);

        // Очікуване повідомлення
        String expectedMessage = "Змагання 'Футбольний турнір' розпочато з 10 учасниками.";

        // Перевіряємо, що метод startCompetition повертає правильне повідомлення
        assertEquals(expectedMessage, competition.startCompetition());
    }

    // Тест на правильність геттера та сеттера для назви змагання
    @Test
    public void testCompetitionName() {
        SportCompetition competition = new SportCompetition("Футбольний турнір", 10);

        // Перевіряємо, що getter повертає правильну назву
        assertEquals("Футбольний турнір", competition.getCompetitionName(), "Назва змагання неправильна");

        // Змінюємо назву змагання за допомогою setter
        competition.setCompetitionName("Тенісний турнір");

        // Перевіряємо, що нова назва правильно зберігається
        assertEquals("Тенісний турнір", competition.getCompetitionName(), "Назва змагання не оновлена");
    }

    // Тест на правильність геттера та сеттера для кількості учасників
    @Test
    public void testParticipants() {
        SportCompetition competition = new SportCompetition("Футбольний турнір", 10);

        // Перевіряємо, що getter правильно повертає кількість учасників
        assertEquals(10, competition.getParticipants(), "Кількість учасників неправильна");

        // Змінюємо кількість учасників за допомогою setter
        competition.setParticipants(15);

        // Перевіряємо, що нова кількість учасників правильно зберігається
        assertEquals(15, competition.getParticipants(), "Кількість учасників не оновлена");
    }

    // Тест на валідацію негативної кількості учасників у конструкторі
    @Test
    public void testInvalidParticipantsInConstructor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new SportCompetition("Некоректне змагання", -5);
        });
        assertEquals("Кількість учасників не може бути негативною.", exception.getMessage());
    }

    // Тест на валідацію негативної кількості учасників у setter
    @Test
    public void testInvalidParticipantsSetter() {
        SportCompetition competition = new SportCompetition("Футбольний турнір", 10);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            competition.setParticipants(-10);
        });
        assertEquals("Кількість учасників не може бути негативною.", exception.getMessage());
    }

    // Тест на правильність ініціалізації конструктора
    @Test
    public void testConstructorInitialization() {
        SportCompetition competition = new SportCompetition("Баскетбольний турнір", 12);
        assertEquals("Баскетбольний турнір", competition.getCompetitionName(), "Назва змагання не ініціалізована правильно");
        assertEquals(12, competition.getParticipants(), "Кількість учасників не ініціалізована правильно");
    }
}
