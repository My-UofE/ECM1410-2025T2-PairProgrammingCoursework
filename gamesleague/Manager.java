package gamesleague;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Manager {
    private List<Player> players = new ArrayList<>();
    private List<League> leagues = new ArrayList<>();
    private int newId = 0;

    public int[] getPlayerIds() {
        int[] playerIds = new int[players.size()];
        for (int i = 0; i < players.size(); i++) {
            playerIds[i] = players.get(i).getId();
        }
        return playerIds;
    }

    public Player createPlayer(String email, String displayName, String name, String phone) {
        Player player = new Player();
        player.createPlayer(email, displayName, name, phone);
        players.add(player);
        return player;
    }

    public void deactivatePlayer(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                player.deactivate();
                break;
            }
        }
    }

    public boolean isDeactivatedPlayer(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player.isDeactivated();
            }
        }
        return false; // Return false if player with given id is not found
    }

    public void updatePlayerDisplayName(int id, String displayName) {
        for (Player player : players) {
            if (player.getId() == id) {
                player.updateDisplayName(displayName);
                break;
            }
        }
    }

    public int getPlayerId(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player.getId();
            }
        }
        return -1; // Return -1 if player with given id is not found
    }

    public String getPlayerDisplayName(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player.getDisplayName();
            }
        }
        return null; // Return null if player with given id is not found
    }

    public String getPlayerEmail(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player.getEmail();
            }
        }
        return null; // Return null if player with given id is not found
    }

    public int[] getPlayerLeagues(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player.getLeagues();
            }
        }
        return new int[0]; // Return empty array if player with given id is not found
    }

    public int[] getPlayerOwnedLeagues(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player.getOwnedLeagues();
            }
        }
        return new int[0];
    }

    public int[] getPlayerInvites(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player.getInvites();
            }
        }
        return new int[0];
    }

    public int getPlayerRoundsPlayed(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player.getRoundsPlayed();
            }
        }
        return -1; // Return -1 if player with given id is not found
    }

    public double getPlayerRoundsPercentage(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player.getRoundsPercentage();
            }
        }
        return -1.0; // Return -1.0 if player with given id is not found
    }

    public LocalDate getPlayerJoinDate(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player.getJoinDate();
            }
        }
        return null; // Return null if player with given id is not found
    }

    public void createLeague(int owner, String name, GameType gameType) {
        League league = new League();
        league.setLeagueName(name);
        league.setLeagueGameType(gameType);
        league.setLeagueId(newId++);
        league.addLeagueOwners(owner);
        leagues.add(league);
    }

    public void updateLeagueName(int leagueId, String newName) {
        // Update league name in database
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                leagues.get(i).setLeagueName(newName);
            }
        }
    }

    public void removeLeague(int leagueId) {
        // Remove league from database
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                leagues.remove(i);
            }
        }
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

    public void setLeagueStartDate(int leagueId, int  day) {
        // Set start date in database
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                leagues.get(i).setLeagueStartDate(day);
            }
        }
    }

    public void setLeagueEndDate(int leagueId, int day) {
        // Set end date in database
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                leagues.get(i).setLeagueEndDate(day);
            }
        }
    }

    public int getLeagueStartDate(int leagueId) {
        // Get start date from database
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                return leagues.get(i).getLeagueStartDate();
            }
        }
        return -1; // Return -1 if league with given id is not found
    }

    public int getLeagueCloseDate(int leagueId) {
        // Get close date from database
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                return leagues.get(i).getLeagueEndDate();
            }
        }
        return -1; // Return -1 if league with given id is not found
    }

    public void resetLeague(int leagueId) {
        // Reset league in database
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                leagues.get(i).eraseGamesLeagueData();
            }
        }
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

    public void setLeaguePlayerActive(int leagueId, int playerId) {
        // Set player active in league
    }

    public void addOwner(int leagueId, int playerId) {
        // Add owner to league
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                leagues.get(i).addLeagueOwners(playerId);
            }
        }
    }

    public void removeOwner(int leagueId, int playerId) {
        // Remove owner from league
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                leagues.get(i).removeLeagueOwners(playerId);
            }
        }
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

    public Status getDayStatus(int leagueId, int day) {
        // Get day status from database
    }

    public int[] getDayScores(int leagueId, int day) {
        // Get day scores from database
    }

    public int[] getDayPoints(int leagueId, int day) {
        // Get day points from database
    }

    public int[] getDayRanking(int leagueId, int day) {
        // Get day ranking from database
    }

    public Status getWeekStatus(int leagueId, int day) {
        // Get week status from database
    }

    public int[] getWeekPoints(int leagueId, int day) {
        // Get week points from database
    }

    public int[] getWeekRanking(int leagueId, int day) {
        // Get week ranking from database
    }

    public Status getMonthStatus(int leagueId, int day) {
        // Get month status from database
    }

    public int[] getMonthPoints(int leagueId, int day) {
        // Get month points from database
    }

    public int[] getMonthRanking(int leagueId, int day) {
        // Get month ranking from database
    }

    public Status getYearStatus(int leagueId, int day) {
        // Get year status from database
    }

    public int[] getYearPoints(int leagueId, int day) {
        // Get year points from database
    }

    public int[] getYearRanking(int leagueId, int day) {
        // Get year ranking from database
    }
}