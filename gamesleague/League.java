package gamesleague;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class League {
    private String name;
    private List<Integer> ownersId = new ArrayList<>();
    private Map<Integer, Boolean> members = new HashMap<>();
    private GameType gameType;
    private int leagueId;
    private int leagueStartDate;
    private int leagueEndDate;

    public String getLeagueName() {
        return name;
    }

    public List<Integer> getLeagueOwners() {
        return ownersId;
    }

    public GameType getLeagueGameType() {
        return gameType;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public int getLeagueStartDate() {
        return leagueStartDate;
    }

    public int getLeagueEndDate() {
        return leagueEndDate;
    }

    public void setLeagueName(String name) {
        this.name = name;
    }

    public void setLeagueGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public void setLeagueId(int id) {
        this.leagueId = id;
    }

    public void setLeagueStartDate(int startDate) {
        this.leagueStartDate = startDate;
    }

    public void setLeagueEndDate(int endDate) {
        this.leagueEndDate = endDate;
    }

    public void addLeagueOwner(int owner) {
        this.ownersId.add(owner);
    }

    public void removeLeagueOwners(int owner) {
        this.ownersId.remove(owner);
    }

    public void addLeagueMember(int memberId, boolean isActive) {
        this.members.put(memberId, isActive);
    }

    public void removeLeagueMember(int memberId) {
        this.members.remove(memberId);
    }

    public boolean isLeaguePlayerActive(int leagueId, int playerId) 
            throws IDInvalidException, IllegalArgumentException {
        if (!members.containsKey(playerId)) {
            throw new IDInvalidException("Player ID does not match any player in the system.");
        }
        return members.get(playerId);
    }

    public void updateLeagueMemberStatus(int memberId, boolean isActive) {
        this.members.put(memberId, isActive);
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