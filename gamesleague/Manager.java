package gamesleague;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manager {
    private List<Player> players = new ArrayList<>();
    private List<League> leagues = new ArrayList<>();
    private List<GameReport> gameReports = new ArrayList<>();
    private int currentDate = LocalDate.now().getDayOfYear();
    private int newId = 0;

    public int[] getPlayerIds() {
        int[] playerIds = new int[players.size()];
        for (int i = 0; i < players.size(); i++) {
            playerIds[i] = players.get(i).getId();
        }
        return playerIds;
    }

    public Player createPlayer(String email, String displayName, String name, String phone) {
        if (displayName.endsWith(" ") || displayName.startsWith(" ") || displayName == null) {
            throw new IllegalNameException("Display name cannot start or end with a space or be null");
        }
        if (name.length() < 5 || name.length() > 50) {
            throw new IllegalNameException("Name must be between 5 and 50 characters");
        }
        if (displayName.length() < 1 || displayName.length() > 20) {
            throw new IllegalNameException("Display name must be between 1 and 20 characters");
        }
        if (email.isEmpty() || email == null || !email.contains("@")) {
            throw new InvalidEmailException("Email cannot be empty or null and must contain an @");
        }
        for (Player player : players) {
            if (player.getEmail().equals(email)) {
                throw new IllegalEmailException("Email already exists");
            }
        }
        Player player = new Player();
        player.createPlayer(email, displayName, name, phone);
        players.add(player);
        return player;
    }

    public void deactivatePlayer(int id) {
        boolean foundId = false;
        for (Player player : players) {
            if (player.getId() == id) {
                if (player.getOwnedLeagues().length > 0) {
                    throw new IllegalOperationException("Player is an owner of one or more leagues");
                }
                player.deactivate();
                foundId = true;
                break;
            }
        }
        if (!foundId) {
            throw new IDInvalidException("Player with ID " + id + " not found");
        }
    }

    public boolean isDeactivatedPlayer(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player.isDeactivated();
            }
        }
        throw new IDInvalidException("Player with ID " + id + " not found");
    }

    public void updatePlayerDisplayName(int id, String displayName) {
        if (displayName.endsWith(" ") || displayName.startsWith(" ") || displayName == null) {
            throw new IllegalNameException("Display name cannot start or end with a space or be null");
        }
        if (displayName.length() < 1 || displayName.length() > 20) {
            throw new IllegalNameException("Display name must be between 1 and 20 characters");
        }
        for (Player player : players) {
            if (player.getId() == id) {
                player.updateDisplayName(displayName);
                break;
            }
        }
        throw new IDInvalidException("Player with ID " + id + " not found");
    }

    public int getPlayerId(String email) {
        for (Player player : players) {
            if (player.getEmail() == email) {
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
        throw new IDInvalidException("Player with ID " + id + " not found");
    }

    public String getPlayerEmail(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player.getEmail();
            }
        }
        throw new IDInvalidException("Player with ID " + id + " not found");
    }

    public int[] getPlayerLeagues(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player.getLeagues();
            }
        }
        throw new IDInvalidException("Player with ID " + id + " not found");
    }

    public int[] getPlayerOwnedLeagues(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player.getOwnedLeagues();
            }
        }
        throw new IDInvalidException("Player with ID " + id + " not found");
    }

    public int[] getPlayerInvites(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player.getInvites();
            }
        }
        throw new IDInvalidException("Player with ID " + id + " not found");
    }

    public int getPlayerRoundsPlayed(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player.getRoundsPlayed();
            }
        }
        throw new IDInvalidException("Player with ID " + id + " not found");
    }

    public double getPlayerRoundsPercentage(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player.getRoundsPercentage();
            }
        }
        throw new IDInvalidException("Player with ID " + id + " not found");
    }

    public LocalDate getPlayerJoinDate(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player.getJoinDate();
            }
        }
        throw new IDInvalidException("Player with ID " + id + " not found");
    }

    public int[] getLeagueIds() {
        int[] leagueIds = new int[leagues.size()];
        for (int i = 0; i < leagues.size(); i++) {
            leagueIds[i] = leagues.get(i).getLeagueId();
        }
        return leagueIds;
    }

    public void createLeague(int owner, String name, GameType gameType) {
        boolean foundId = false;
        for (Player player : players) {
            if (player.getId() == owner) {
                foundId = true;
                break;
            }
        }
        if (!foundId) {
            throw new IllegalArgumentException("Player with ID " + owner + " not found");
        }
        if (name.endsWith(" ") || name.startsWith(" ") || name == null) {
            throw new IDInvalidException("Name cannot start or end with a space or be null");
        }
        if (name.length() < 1 || name.length() > 20) {
            throw new IllegalNameException("Name must be between 1 and 20 characters");
        }
        for (League league : leagues) {
            if (league.getLeagueName().equals(name)) {
                throw new IllegalNameException("League name already exists");
            }
        }
        League league = new League();
        league.setLeagueName(name);
        league.setLeagueGameType(gameType);
        league.setLeagueId(newId++);
        league.addLeagueOwner(owner);
        leagues.add(league);
    }

    public void removeLeague(int leagueId) {
        // Remove league from database
        boolean found = false;
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                leagues.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IDInvalidException("League with ID " + leagueId + " not found");
        }
    }

    public String getLeagueName(int leagueId) {
        for (League league : leagues) {
            if (league.getLeagueId() == leagueId) {
                return league.getLeagueName();
            }
        }
        throw new IDInvalidException("League with ID " + leagueId + " not found");
    }

    public void updateLeagueName(int leagueId, String newName) {
        // Update league name in database
        if (newName.endsWith(" ") || newName.startsWith(" ") || newName == null) {
            throw new IDInvalidException("Name cannot start or end with a space or be null");
        }
        if (newName.length() < 1 || newName.length() > 20) {
            throw new IllegalNameException("Name must be between 1 and 20 characters");
        }
        boolean found = false;
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                leagues.get(i).setLeagueName(newName);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IDInvalidException("League with ID " + leagueId + " not found");
        }
    }

    public void invitePlayerToLeague(int leagueId, String email) {
        if (email.isEmpty() || email == null || !email.contains("@")) {
            throw new InvalidEmailException("Email cannot be empty or null and must contain an @");
        }
        boolean found = false;
        for (Player player : players) {
            if (player.getEmail() == email) {
                for (League league : leagues) {
                    if (league.getLeagueId() == leagueId) {
                        league.addEmailInvite(email);
                        player.addInvite(leagueId);
                        found = true;
                        break;
                    }
                }
            }
        }
        if (!found) {
            throw new IDInvalidException("Player with email " + email + " or League with id " + leagueId + " not found");
        }
    }

    public void acceptInviteToLeague(int leagueId, int playerId) {
        boolean found = false;
        for (Player player : players) {
            if (player.getId() == playerId) {
                if (!Arrays.asList(player.getInvites()).contains(leagueId)) {
                    throw new IllegalOperationException("Player has not been invited to league");
                }
                player.removeInvite(leagueId);
            }
            for (League league : leagues) {
                if (league.getLeagueId() == leagueId) {
                    league.removeEmailInvite(player.getEmail());
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            throw new IDInvalidException("Player with ID " + playerId + " or League with id " + leagueId + " not found");
        }
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                leagues.get(i).addLeagueMember(playerId, true);
            }
        }
    }

    public void removeInviteFromLeague(int leagueId, String email) {
        // Remove invite from database
        boolean found = false;
        for (Player player : players) {
            if (player.getEmail() == email) {
                if (!Arrays.asList(player.getInvites()).contains(leagueId)) {
                    throw new IllegalOperationException("Player has not been invited to league");
                }
                player.removeInvite(leagueId);
            }
            for (League league : leagues) {
                if (league.getLeagueId() == leagueId) {
                    league.removeEmailInvite(email);
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            throw new IDInvalidException("Player with email " + email + " or League with id " + leagueId + " not found");
        }
    }

    public String[] getLeagueEmailInvites(int leagueId) {
        List<String> invites = new ArrayList<>();
        boolean found = false;
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                invites = leagues.get(i).getLeagueEmailInvites();
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IDInvalidException("League with ID " + leagueId + " not found");
        }
        List<String> emails = new ArrayList<>();
        for (Player player : players) {
            emails.add(player.getEmail());
        }
        List<String> nonPlayers = new ArrayList<>();
        for (String invite : invites) {
            if (!emails.contains(invite)) {
                nonPlayers.add(invite);
            }
        }
        return nonPlayers.toArray(new String[0]);
    }

    public int[] getLeaguePlayerInvites(int leagueId) {
        List<String> invites = new ArrayList<>();
        boolean found = false;
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                invites = leagues.get(i).getLeagueEmailInvites();
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IDInvalidException("League with ID " + leagueId + " not found");
        }
        List<String> emails = new ArrayList<>();
        for (Player player : players) {
            emails.add(player.getEmail());
        }
        List<String> existingPlayersEmails = new ArrayList<>();
        for (String invite : invites) {
            if (emails.contains(invite)) {
                existingPlayersEmails.add(invite);
            }
        }
        List<Integer> existingPlayersIds = new ArrayList<>();
        for (Player player : players) {
            if (existingPlayersEmails.contains(player.getEmail())) {
                existingPlayersIds.add(player.getId());
            }
        }
        return existingPlayersIds.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] getLeaguePlayers(int leagueId) {
        for (League league : leagues) {
            if (league.getLeagueId() == leagueId) {
                return league.getLeaguePlayersGetter();
            }
        }
        throw new IDInvalidException("League with ID " + leagueId + " not found");
    }

    public int[] getLeagueOwners(int leagueId) {
        // Get league owners from database
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                List<Integer> owners = leagues.get(i).getLeagueOwnersGetter();
                int[] ownersArray = owners.stream().mapToInt(Integer::intValue).toArray();
                return ownersArray;
            }
        }
        throw new IDInvalidException("League with ID " + leagueId + " not found");
    }

    public void setLeagueStartDate(int leagueId, int  day) {
        // Set start date in database
        boolean found = false;
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                if (leagues.get(i).getLeagueStartDate() != 0) {
                    throw new IllegalOperationException("League start date cannot be set more than once");
                }
                leagues.get(i).setLeagueStartDate(day);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IDInvalidException("League with ID " + leagueId + " not found");
        }
    }

    public void setLeagueEndDate(int leagueId, int day) {
        // Set end date in database
        boolean found = false;
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                if (leagues.get(i).getLeagueEndDate() != 0) {
                    throw new IllegalOperationException("League start date cannot be set more than once");
                }

                leagues.get(i).setLeagueEndDate(day);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IDInvalidException("League with ID " + leagueId + " not found");
        }
    }

    public int getLeagueStartDate(int leagueId) {
        // Get start date from database
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                return leagues.get(i).getLeagueStartDate();
            }
        }
        throw new IDInvalidException("League with ID " + leagueId + " not found");
    }

    public int getLeagueCloseDate(int leagueId) {
        // Get close date from database
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                return leagues.get(i).getLeagueEndDate();
            }
        }
        throw new IDInvalidException("League with ID " + leagueId + " not found");
    }

    public void resetLeague(int leagueId) {
        // Reset league in database
        boolean found = false;
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                leagues.get(i).eraseGamesLeagueData();
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IDInvalidException("League with ID " + leagueId + " not found");
        }
    }

    public int cloneLeague(int leagueId, String newName) {
        // Clone league in database
        for (League checkLeague : leagues) {
            if (checkLeague.getLeagueName().equals(newName)) {
                throw new IllegalNameException("League name already exists");
            }
        }
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                League league = new League();
                league.setLeagueName(newName);
                league.setLeagueGameType(leagues.get(i).getLeagueGameType());
                league.setLeagueId(newId++);
                List<Integer> owners = leagues.get(i).getLeagueOwnersGetter();
                for (int owner : owners) {
                    league.addLeagueOwner(owner);
                }
                leagues.add(league);
                return league.getLeagueId(); // Return the new league ID
            }
        }
        throw new IDInvalidException("League with ID " + leagueId + " not found");
    }

    public boolean isLeaguePlayerActive(int leagueId, int playerId) {
        // Check if player is active in league
        boolean foundPlayer = false;
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                for (int id : leagues.get(i).getLeaguePlayersGetter()) {
                    if (id == playerId) {
                        foundPlayer = true;
                        break;
                    }
                }
                if (!foundPlayer) {
                    throw new IllegalOperationException("Player with ID " + playerId + " not found in league");
                }
                return leagues.get(i).isLeaguePlayerActive(leagueId, playerId);
            }
        }
        throw new IDInvalidException("No league with ID " + leagueId + " or " + playerId + " found");
    }

    public void setLeaguePlayerInactive(int leagueId, int playerId) {
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                for (int id : leagues.get(i).getLeaguePlayersGetter()) {
                    if (id == playerId) {
                        leagues.get(i).updateLeagueMemberStatus(playerId, false);
                        return;
                    }
                }
                throw new IllegalOperationException("Player with ID " + playerId + " not found in league");
            }
        }
        throw new IDInvalidException("No league with ID " + leagueId + " or " + playerId + " found");
    }

    public void setLeaguePlayerActive(int leagueId, int playerId) {
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                for (int id : leagues.get(i).getLeaguePlayersGetter()) {
                    if (id == playerId) {
                        leagues.get(i).updateLeagueMemberStatus(playerId, true);
                        return;
                    }
                }
                throw new IllegalOperationException("Player with ID " + playerId + " not found in league");
            }
        }
        throw new IDInvalidException("No league with ID " + leagueId + " or " + playerId + " found");
    }

    public void addOwner(int leagueId, int playerId) {
        // Add owner to league
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                for (int id: leagues.get(i).getLeaguePlayersGetter()) {
                    if (id == playerId) {
                        leagues.get(i).addLeagueOwner(playerId);
                        return;
                    }
                }
                throw new IllegalOperationException("Player with ID " + playerId + " not found in league");
            }
        }
        throw new IDInvalidException("No league with ID " + leagueId + " or " + playerId + " found");
    }

    public void removeOwner(int leagueId, int playerId) {
        // Remove owner from league
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                if (leagues.get(i).getLeagueOwnersGetter().size() == 1) {
                    throw new IllegalOperationException("League must have at least one owner");
                }
                else {
                    leagues.get(i).removeLeagueOwners(playerId);
                    return;
                }
            }
        }
        throw new IDInvalidException("No league with ID " + leagueId + " or " + playerId + " found");
    }

    public void registerGameReport(int day, int leagueId,  int playerId, String gameReport) {
        // Register game report in database
        if (day < 1 || day > 365) {
            throw new IllegalArgumentException("Day must be between 1 and 365");
        }

        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                for (int id: leagues.get(i).getLeaguePlayersGetter()) {
                    if (id == playerId) {
                        GameReport report = new GameReport(day, leagueId, playerId, gameReport);
                        gameReports.add(report);
                        return;
                    }
                }
            }
        }
        throw new IDInvalidException("No league with ID " + leagueId + " or " + playerId + " found");
    }

    public String getGameReport(int day, int leagueId,  int playerId) {
        // Get game report from database
        if (day < 1 || day > 365) {
            throw new InvalidDateException("Day must be between 1 and 365");
        }

        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                for (int id: leagues.get(i).getLeaguePlayersGetter()) {
                    if (id == playerId) {
                        for (GameReport report : gameReports) {
                            if (report.getDay() == day && report.getLeagueId() == leagueId && report.getPlayerId() == playerId) {
                                return report.getGameReport();
                            }
                        }
                    }
                }
            }
        }
        throw new IDInvalidException("No league with ID " + leagueId + " or " + playerId + " found");
    }

    public void registerDayScores(int day, int leagueId, int[] scores) {
        // Register day scores in database
        if (currentDate >= day + 2) {
            throw new IllegalOperationException("Day scores cannot be set after two days");
        }

        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                if (leagues.get(i).getDayActivity(day) == Status.CLOSED) {
                    throw new IllegalOperationException("Day scores cannot be set after day is closed");
                }
                leagues.get(i).addDayActivity(day, Status.CLOSED);
                for (int j = 0; j < leagues.get(i).getLeaguePlayersGetter().length; j++) {
                    leagues.get(i).setDayPoints(day, scores[j], leagues.get(i).getLeaguePlayersGetter()[j]);
                }
                return;
            }
        }
        throw new IDInvalidException("No league with ID " + leagueId + " found");
    }

    public void voidDayPoints(int day, int leagueId) {
        // Void day points in database
        if (currentDate >= day + 2) {
            throw new IllegalOperationException("Day points cannot be voided after two days");
        }
        else if (day < 1 || day > 365) {
            throw new IllegalArgumentException("Day must be between 1 and 365");
        }

        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                for (int j = 0; j < leagues.get(i).getLeaguePlayersGetter().length; j++) {
                        leagues.get(i).setDayPoints(day, 0, leagues.get(i).getLeaguePlayersGetter()[j]);
                }
                return;
            }
        }
        throw new IDInvalidException("No league with ID " + leagueId + " found");
    }

    public Status getDayStatus(int leagueId, int day) {
        // Get day status from database
        if (day < 1 || day > 365) {
            throw new InvalidDateException("Day must be between 1 and 365");
        }
        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                return leagues.get(i).getDayActivity(day);
            }
        }
        throw new IDInvalidException("No league with ID " + leagueId + " found");
    }

    public int[] getDayScore(int leagueId, int day) { // SCORE IS FOR GAMES
        // Get the scores for each player from a certain day
        if (day < 1 || day > 365) {
            throw new InvalidDateException("Day must be between 1 and 365");
        }

        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                return leagues.get(i).getDayScorePlayer().get(day).values().stream().mapToInt(Integer::intValue).toArray();
            }
        }
        throw new IDInvalidException("No league with ID " + leagueId + " found");
    }

    public int[] getDayPoints(int leagueId, int day) { // POINTS IS FOR LEAGUE
        // Get all the points for the day
        if (day < 1 || day > 365) {
            throw new InvalidDateException("Day must be between 1 and 365");
        }

        for (int i = 0; i < leagues.size(); i++) {
            if (leagues.get(i).getLeagueId() == leagueId) {
                return leagues.get(i).getDayPointsPlayer().get(day).values().stream().mapToInt(Integer::intValue).toArray();
            }
        }
        throw new IDInvalidException("No league with ID " + leagueId + " found");
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