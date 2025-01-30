package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SportCompetitionTest {

    @Test
    void testCompetitionCreation() {
        SportCompetition competition = new SportCompetition("Test Competition", 5);
        assertEquals("Test Competition", competition.getCompetitionName());
        assertEquals(5, competition.getParticipants());
    }

    @Test
    void testNegativeParticipants() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new SportCompetition("Invalid Competition", -1);
        });
        assertEquals("Number of participants cannot be negative.", exception.getMessage());
    }

    @Test
    void testSettersAndGetters() {
        SportCompetition competition = new SportCompetition("Initial Name", 10);
        competition.setCompetitionName("Updated Name");
        competition.setParticipants(15);

        assertEquals("Updated Name", competition.getCompetitionName());
        assertEquals(15, competition.getParticipants());
    }

    @Test
    void testStartCompetitionWithMock() {
        // Мок класу SportCompetition
        SportCompetition mockCompetition = mock(SportCompetition.class);

        // Налаштування мока
        when(mockCompetition.getCompetitionName()).thenReturn("Mocked Competition");
        when(mockCompetition.getParticipants()).thenReturn(20);
        when(mockCompetition.startCompetition())
                .thenReturn("The competition 'Mocked Competition' has started with 20 participants.");

        // Перевірка роботи мока
        assertEquals("Mocked Competition", mockCompetition.getCompetitionName());
        assertEquals(20, mockCompetition.getParticipants());
        assertEquals(
                "The competition 'Mocked Competition' has started with 20 participants.",
                mockCompetition.startCompetition()
        );

        // Верифікація викликів методів
        verify(mockCompetition).getCompetitionName();
        verify(mockCompetition).getParticipants();
        verify(mockCompetition).startCompetition();
    }
}
