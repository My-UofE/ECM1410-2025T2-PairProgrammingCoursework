package gamesleague;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class League {
    private String name;
    private List<Integer> ownerIds = new ArrayList<>();
    private Map<Integer, Boolean> memberIds = new HashMap<>();
    private Map<Integer, Status> dayActivity = new HashMap<>();
    private Map<Integer, Status> playerActivity = new HashMap<>(); // player ID and then status
    private List<String> emailInvites = new ArrayList<>();
    private Map<Integer, Integer> dayScores = new HashMap<>(); //score and then day
    private GameType gameType;
    private int leagueId;
    private int leagueStartDate = 0; // Default to 0, maybe change later?
    private int leagueEndDate = 0; // Default to 0, maybe change later?

    public String getLeagueName() {
        return name;
    }

    public int getLengthOwnerIds() {
        return ownerIds.size();
    }

    public Status getDayActivity(int day) {
        return dayActivity.get(day);
    }

    public int[] getLeaguePlayersGetter() {
        return memberIds.keySet().stream().mapToInt(i -> i).toArray();
    }

    public List<String> getLeagueEmailInvites() {
        return emailInvites;
    }

    public List<Integer> getLeagueOwnersGetter() {
        return ownerIds;
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

    public void setDayScores(int[] scores, int day) {
        for (int i = 0; i < scores.length; i++) {
            dayScores.put(day, scores[i]);

        }

        for (Integer playerId : memberIds.keySet()) {
            playerActivity.put(playerId, Status.CLOSED);
        }

        dayActivity.put(day, Status.CLOSED);
    }

    public void voidDayPoints (int day) {
        for (Integer key : dayScores.keySet()) {
            if (key == day) {
                dayScores.put(key, 0);
            }
        }
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
        this.ownerIds.add(owner);
    }

    public void addEmailInvite(String email) {
        this.emailInvites.add(email);
    }

    public void removeEmailInvite(String email) {
        this.emailInvites.remove(email);
    }

    public void removeLeagueOwners(int owner) {
        this.ownerIds.remove(owner);
    }

    public void addLeagueMember(int memberId, boolean isActive) {
        this.memberIds.put(memberId, isActive);
    }

    public void removeLeagueMember(int memberId) {
        this.memberIds.remove(memberId);
    }

    public boolean isLeaguePlayerActive(int leagueId, int playerId) 
            throws IDInvalidException, IllegalArgumentException {
        if (!memberIds.containsKey(playerId)) {
            throw new IDInvalidException("Player ID does not match any player in the system.");
        }
        return memberIds.get(playerId);
    }

    public void updateLeagueMemberStatus(int memberId, boolean isActive) {
        this.memberIds.put(memberId, isActive);
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