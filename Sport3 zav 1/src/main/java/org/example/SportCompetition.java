package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Клас для спортивного змагання
public class SportCompetition {
    private static final Logger logger = LogManager.getLogger(SportCompetition.class);

    private String competitionName;
    private int participants;

    public SportCompetition(String competitionName, int participants) {
        if (participants < 0) {
            logger.error("Number of participants cannot be negative.");
            throw new IllegalArgumentException("Number of participants cannot be negative.");
        }
        this.competitionName = competitionName;
        this.participants = participants;
        logger.info("Created competition: {} with {} participants", competitionName, participants);
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        logger.debug("Setting competition name to {}", competitionName);
        this.competitionName = competitionName;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        if (participants < 0) {
            logger.error("Number of participants cannot be negative.");
            throw new IllegalArgumentException("Number of participants cannot be negative.");
        }
        this.participants = participants;
    }

    public String startCompetition() {
        logger.info("Starting competition: {}", competitionName);
        return "The competition '" + competitionName + "' has started with " + participants + " participants.";
    }

    // Інтерфейс Команди
    interface Command {
        void execute();
    }

    // Команда для створення нового змагання
    static class CreateCompetitionCommand implements Command {
        private final Map<String, SportCompetition> competitions;

        public CreateCompetitionCommand(Map<String, SportCompetition> competitions) {
            this.competitions = competitions;
        }

        @Override
        public void execute() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter competition name: ");
            String name = scanner.nextLine();
            System.out.print("Enter number of participants: ");
            int participants = scanner.nextInt();
            try {
                SportCompetition competition = new SportCompetition(name, participants);
                competitions.put(name, competition);
                System.out.println("Competition created successfully.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // Команда для запуску змагання
    static class StartCompetitionCommand implements Command {
        private final Map<String, SportCompetition> competitions;

        public StartCompetitionCommand(Map<String, SportCompetition> competitions) {
            this.competitions = competitions;
        }

        @Override
        public void execute() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter competition name to start: ");
            String name = scanner.nextLine();
            SportCompetition competition = competitions.get(name);
            if (competition != null) {
                System.out.println(competition.startCompetition());
            } else {
                System.out.println("Competition not found.");
            }
        }
    }

    // Команда для виведення списку змагань
    static class ListCompetitionsCommand implements Command {
        private final Map<String, SportCompetition> competitions;

        public ListCompetitionsCommand(Map<String, SportCompetition> competitions) {
            this.competitions = competitions;
        }

        @Override
        public void execute() {
            if (competitions.isEmpty()) {
                System.out.println("No competitions available.");
            } else {
                System.out.println("Competitions:");
                competitions.forEach((name, competition) -> {
                    System.out.println("- " + name + " with " + competition.getParticipants() + " participants");
                });
            }
        }
    }

    // Головний метод
    public static void main(String[] args) {
        Map<String, SportCompetition> competitions = new HashMap<>();
        Map<String, Command> commands = new HashMap<>();

        commands.put("create", new CreateCompetitionCommand(competitions));
        commands.put("start", new StartCompetitionCommand(competitions));
        commands.put("list", new ListCompetitionsCommand(competitions));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Sport Competition Manager!");
        while (true) {
            System.out.println("\nAvailable commands: create, start, list, exit");
            System.out.print("Enter command: ");
            String command = scanner.nextLine().trim().toLowerCase();

            if (command.equals("exit")) {
                System.out.println("Exiting Sport Competition Manager. Goodbye!");
                break;
            }

            Command cmd = commands.get(command);
            if (cmd != null) {
                cmd.execute();
            } else {
                System.out.println("Unknown command. Please try again.");
            }
        }
    }
}