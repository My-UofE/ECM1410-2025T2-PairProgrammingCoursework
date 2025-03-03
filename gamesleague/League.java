package gamesleague;

import java.util.ArrayList;
import java.util.List;

public class League {
    private String name;
    private List<Integer> ownerIDs = new ArrayList<>();
    private List<Integer> memberIDs = new ArrayList<>();
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

    public String updateLeagueName(int leagueId, String newName)
    {
        if (this.leagueId == leagueId) {
            this.name = newName;
            return "League name updated successfully";
        }
        return "League not found";
    }

    public void removeLeague(int leagueId) {
        // Remove league from database
    }

    public void invitePlayerToLeague(int leagueId, String email) {
        // Send email to player
    }

    public void acceptInviteToLeague(int leagueID) {
        // Add player to league
    }

    public void removeInviteFromLeague(int leagueId, String email) {
        // Remove invite from database
    }

    public String[] getLeagueEmailInvites(int leagueId) {
        // Get email invites from database
    }

    public int[] getLeaguePlayerInvites(int leagueId) {
        // Get player invites from database
    }

    public int[] getLeaguePlayers(int leagueId) {
        // Get players from database
    }

    public int[] getLeagueOwners(int leagueId) {
        // Get owners from database
    }

    public Status getLeagueStatus(int leagueId ) {
        // Get status from database
    }

    public void setLeagueStartDate(int leagueId, int  day) {
        // Set start date in database
    }

    public void setLeagueEndDate(int leagueId) {
        // Set end date in database
    }

    public int getLeagueStartDate(int leagueId) {
        // Get start date from database
    }

    public int getLeagueCloseDate(int leagueId) {
        // Get close date from database
    }

    public void resetLeague(int leagueId) {
        // Reset league in database
    }

    public int cloneLeague(int leagueId, String newName) {
        // Clone league in database
    }

    public boolean isLeaguePlayerActive(int leagueId, int playerId) {
        // Check if player is active in league
    }

    public void setLeaguePlayerInactive(int leagueId, int playerId) {
        // Set player inactive in league
    }

    public oid setLeaguePlayerActive(int leagueId, int playerId) {
        // Set player active in league
    }

    public void addOwner(int leagueId, int playerId) {
        // Add owner to league
        ownerIDs.add(playerId);
    }

    public void removeOwner(int leagueId, int playerId) {
        // Remove owner from league
    }

    public void registerGameReport(int day, int leagueId,  int playerId, String gameReport ) {
        // Register game report in database
    }

    public String getGameReport(int day, int leagueId,  int playerId) {
        // Get game report from database
    }

    public void registerDayScores(int day, int leagueId, int[] scores) {
        // Register day scores in database
    }

    public void voidDayPoints(int day, int leagueId) {
        // Void day points in database
    }

    public Status getDayStatus(int leagueId, int day ) {
        // Get day status from database
    }

    public int[] getDayScores(int leagueId, int day ) {
        // Get day scores from database
    }

    public int[] getDayPoints(int leagueId, int day ) {
        // Get day points from database
    }

    public int[] getDayRanking(int leagueId, int day ) {
        // Get day ranking from database
    }

    public Status getWeekStatus(int leagueId, int day ) {
        // Get week status from database
    }

    public int[] getWeekPoints(int leagueId, int day ) {
        // Get week points from database
    }

    public int[] getWeekRanking(int leagueId, int day ) {
        // Get week ranking from database
    }

    public Status getMonthStatus(int leagueId, int day ) {
        // Get month status from database
    }

    public int[] getMonthPoints(int leagueId, int day ) {
        // Get month points from database
    }

    public int[] getMonthRanking(int leagueId, int day ) {
        // Get month ranking from database
    }

    public Status getYearStatus(int leagueId, int day ) {
        // Get year status from database
    }

    public int[] getYearPoints(int leagueId, int day ) {
        // Get year points from database
    }

    public int[] getYearRanking(int leagueId, int day ) {
        // Get year ranking from database
    }

    public void eraseGamesLeagueData(); {
        // Erase all data from database
    }

    public void saveGamesLeagueData(String filename) {
        // Save data to file
    }

    public void loadGamesLeagueData(String filename) {
        // Load data from file
    }
}