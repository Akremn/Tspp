package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SportCompetition {
    private static final Logger logger = LogManager.getLogger(SportCompetition.class);

    // Make these fields final since they are initialized in the constructor and are not modified later
    private final String competitionName;
    private final int participants;

    // Constructor to initialize the competition with name and number of participants
    public SportCompetition(String competitionName, int participants) {
        if (participants < 0) {
            logger.error("Number of participants cannot be negative.");
            throw new IllegalArgumentException("Number of participants cannot be negative.");
        }
        this.competitionName = competitionName;
        this.participants = participants;
        logger.info("Created competition: {} with {} participants", competitionName, participants);
    }

    // Method to start the competition and return a message
    public String startCompetition() {
        logger.info("Starting competition: {}", competitionName);
        return "The competition '" + competitionName + "' has started with " + participants + " participants.";
    }

    // Main method for testing the class (if required)
    public static void main(String[] args) {
        SportCompetition competition = new SportCompetition("Football Tournament", 10);
        System.out.println(competition.startCompetition());
    }
}
