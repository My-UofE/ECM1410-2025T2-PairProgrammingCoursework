package gamesleague;

import java.util.ArrayList;
import java.util.List;

public class League {
    private String name;
    private List<Integer> ownersId = new ArrayList<>();
    private List<Integer> membersId = new ArrayList<>();
    private GameType gameType;
    private int leagueId;


    public void createLeague(int owner, String name, GameType gameType ) {
        this.name = name;
        this.ownerIDs.add(owner);
        this.gameType = gameType;
        this.leagueId = 0; // Placeholder value, to be updated with a unique ID
    }

    public String getLeagueName() {
        return name;
    }

    public List<Integer> getLeagueOwners() {
        return ownerIDs;
    }

    public GameType getLeagueGameType() {
        return gameType;
    }

    public void eraseGamesLeagueData() {
        // Erase all data from database
    }

    public void saveGamesLeagueData(String filename) {
        // Save data to file
    }

    public void loadGamesLeagueData(String filename) {
        // Load data from file
    }
}