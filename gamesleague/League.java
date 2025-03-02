package gamesleague;

import java.util.ArrayList;
import java.util.List;

public class League {
    private String name;
    private List<Player> owners = new ArrayList<>();
    private List<Player> members = new ArrayList<>();
    private String gameType;
    private int leagueId;

    public void createLeague(String name, String owner, String gameType) {
        this.name = name;
        this.owner = owner;
        this.gameType = gameType;
        this.leagueId = 0; // Placeholder value, to be updated with a unique ID
    }

    public String getLeagueName() {
        return name;
    }

    public List<Player> getLeagueOwners() {
        return owners;
    }

    public String getLeagueGameType() {
        return gameType;
    }

    public String updateLeagueName(int leagueId, String newName)
    {
        if (this.leagueId == leagueId) {
            this.name = newName;
            return "League name updated successfully";
        }
        return "League not found";
    }

    public void addLeagueOwner(int leagueId, int playerID) {
        owners.add(owner);
    }

    public void removeLeague() {
        this.name = null;
        this.owners = null;
        this.gameType = null;
        this.leagueId = 0;
    }
}
