package gamesleague;

import java.util.ArrayList;
import java.util.List;

public class League {
    private String name;
    private List<Integer> ownersId = new ArrayList<>();
    private List<Integer> membersId = new ArrayList<>();
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

    public void addLeagueOwners(int owner) {
        this.ownersId.add(owner);
    }

    public void removeLeagueOwners(int owner) {
        this.ownersId.remove(owner);
    }

    public void addLeagueMembers(int member) {
        this.membersId.add(member);
    }

    public void removeLeagueMembers(int member) {
        this.membersId.remove(member);
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