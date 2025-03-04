package gamesleague;

public class GameReport {
    private int day;
    private int leagueId;
    private int playerId;
    private String gameReport;

    public GameReport(int day, int leagueId, int playerId, String gameReport) {
        this.day = day;
        this.leagueId = leagueId;
        this.playerId = playerId;
        this.gameReport = gameReport;
    }
}
