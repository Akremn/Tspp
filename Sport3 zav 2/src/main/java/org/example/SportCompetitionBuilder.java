package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SportCompetitionBuilder {
    private static final Logger logger = LogManager.getLogger(SportCompetitionBuilder.class);
    private String competitionName;
    private int participants;

    public SportCompetitionBuilder setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
        logger.debug("Competition name set to {}", competitionName);
        return this;
    }

    public SportCompetitionBuilder setParticipants(int participants) {
        if (participants < 0) {
            logger.error("Number of participants cannot be negative.");
            throw new IllegalArgumentException("Number of participants cannot be negative.");
        }
        this.participants = participants;
        logger.debug("Number of participants set to {}", participants);
        return this;
    }

    public SportCompetition build() {
        logger.info("Building competition: {} with {} participants", competitionName, participants);
        return new SportCompetition(competitionName, participants);
    }
}
