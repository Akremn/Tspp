package org.example;

public class SportCompetition {
    // Name of the competition
    private String competitionName;

    // Number of participants
    private int participants;

    // Constructor to initialize the competition with name and number of participants
    public SportCompetition(String competitionName, int participants) {
        if (participants < 0) {
            throw new IllegalArgumentException("Number of participants cannot be negative.");
        }
        this.competitionName = competitionName;
        this.participants = participants;
    }

    // Method to get the competition name
    public String getCompetitionName() {
        return competitionName;
    }

    // Method to set the competition name
    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    // Method to get the number of participants
    public int getParticipants() {
        return participants;
    }

    // Method to set the number of participants
    public void setParticipants(int participants) {
        if (participants < 0) {
            throw new IllegalArgumentException("Number of participants cannot be negative.");
        }
        this.participants = participants;
    }

    // Method to start the competition and return a message
    public String startCompetition() {
        return "The competition '" + competitionName + "' has started with " + participants + " participants.";
    }

    // Main method for testing the class
    public static void main(String[] args) {
        // Creating a competition object
        SportCompetition competition = new SportCompetition("Football Tournament", 10);

        // Calling the startCompetition method and printing the result
        System.out.println(competition.startCompetition());
    }
}
