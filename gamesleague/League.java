package gamesleague;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class League {
    private String name;
    private List<Integer> ownerIds = new ArrayList<>();
    private Map<Integer, Boolean> memberIds = new HashMap<>();
    private Map<Integer, Status> dayActivity = new HashMap<>(); // day and then activity
    private Map<Integer, Status> playerActivity = new HashMap<>(); // player ID and then status
    private List<String> emailInvites = new ArrayList<>();
    private Map<Integer, Map<Integer, Integer>> dayScorePlayer = new HashMap<>(); //day, (score, player ID)
    private Map<Integer, Map<Integer, Integer>> dayPointsPlayer = new HashMap<>(); //day, (score, player ID) THIS IS FOR LEAGUE POINTS
    private GameType gameType;
    private int leagueId = 0; // Default to 0, maybe change later?
    private int leagueStartDate = 0; // Default to 0, maybe change later? nooooooooo
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

    public Map<Integer, Map<Integer, Integer>> getDayScorePlayer() {
        return dayScorePlayer;
    }

    public Map<Integer, Map<Integer, Integer>> getDayPointsPlayer() {
        return dayPointsPlayer;
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

    public void setDayScore(int day, int score, int playerId) {
        if (dayScorePlayer.containsKey(day)) {
            dayScorePlayer.get(day).put(score, playerId);
        } else {
            Map<Integer, Integer> scorePlayer = new HashMap<>();
            scorePlayer.put(score, playerId);
            dayScorePlayer.put(day, scorePlayer);
        }
    }

    public void setDayPoints(int day, int points, int playerId) {
        if (dayPointsPlayer.containsKey(day)) {
            dayPointsPlayer.get(day).put(points, playerId);
        } else {
            Map<Integer, Integer> pointsPlayer = new HashMap<>();
            pointsPlayer.put(points, playerId);
            dayPointsPlayer.put(day, pointsPlayer);
        }
    }

    public void addDayActivity(int day, Status status) {
        dayActivity.put(day, status);
    }

    public void setPlayerActivity(int playerId, Status status) {
        playerActivity.put(playerId, status);
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

    public boolean isLeaguePlayerActive(int leagueId, int playerId) {
        if (!memberIds.containsKey(playerId)) {
            throw new IDInvalidException("Player ID does not match any player in the system.");
        }
        return memberIds.get(playerId);
    }

    public void updateLeagueMemberStatus(int memberId, boolean isActive) {
        this.memberIds.put(memberId, isActive);
    }

    @Override
    public String toString() {
        return "League{" +
                "name='" + name + '\'' +
                ", ownerIds=" + ownerIds +
                ", memberIds=" + memberIds +
                ", dayActivity=" + dayActivity +
                ", playerActivity=" + playerActivity +
                ", emailInvites=" + emailInvites +
                ", dayScorePlayer=" + dayScorePlayer +
                ", dayPointsPlayer=" + dayPointsPlayer +
                ", gameType=" + gameType +
                ", leagueId=" + leagueId +
                ", leagueStartDate=" + leagueStartDate +
                ", leagueEndDate=" + leagueEndDate +
                '}';
    }
}