package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
}
