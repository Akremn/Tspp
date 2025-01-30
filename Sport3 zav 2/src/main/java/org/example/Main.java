package org.example;

public class Main {
    public static void main(String[] args) {
        // Створення об'єкта через Builder
        SportCompetition competition = new SportCompetitionBuilder()
                .setCompetitionName("Football Tournament")
                .setParticipants(10)
                .build();

        // Виклик методу та виведення результату
        System.out.println(competition.startCompetition());
    }
}
