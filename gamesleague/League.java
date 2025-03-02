package gamesleague;

public class League {
    private String name;
    private String owner;
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

    public String getLeagueOwner() {
        return owner;
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

    public void removeLeague() {
        this.name = null;
        this.owner = null;
        this.gameType = null;
        this.leagueId = 0;
    }
}
