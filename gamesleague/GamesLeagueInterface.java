package gamesleague;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * GamesLeagueInterface interface. Your submission should include
 * a class GamesLeague that implements this class.
 * It should include a no-argument constructor that initialises an empty GamesLeague
 * with no initial users or leagues within it.
 * 
 *
 * @author Philip Lewis
 * @version 0.3.1
 */



public interface GamesLeagueInterface extends Serializable {

    // Players

    /**
     * Get the players currently created in the platform.
     *
     * @return An array of player IDs in the system or an empty array if none exists.
     */
    int[] getPlayerIds();


    /**
     * Creates a player entry.
     *
     * @param email The email of the player (unique).
     * @param displayName The name of the player.
     * @param name The name of the player.
     * @param phone The contact phone number of the player or empty string.
     * @return The ID of the rider in the system.
     * @throws InvalidNameException If the displayName/name is null or starts/ends with whitespace, 
     *                              or if the name is less than 5 char / more than 50 char.
     *                              or if displayName is less than 1 char/more than 20 char.
     * @throws InvalidEmailException If the email is null, empty, or does not contain an '@' character,
     * @throws IllegalEmailException if it duplicates an existing email of a player
     */
    int createPlayer(String email, String displayName, String name, String phone) 
        throws  InvalidEmailException,   
                IllegalEmailException,
                InvalidNameException;


    /**
     * Permenantly deactivates player account.
     * <p>
     * Note to preserve the integrity of the league tables the removal process should follow:
     * i) all personal player anonymised with playerId placeholders
     * ii) all player gameplay reports are set to empty strings
     * iii) player is set to in in all league memberships
     *
     * @param playerId The ID of the player to be deactivated.
     * @throws IDInvalidException If the ID does not match to any player in the system.
     * @throws IllegalOperationException If the player is the sole owner of a league.
     */
    void deactivatePlayer(int playerId) throws IDInvalidException, IllegalOperationException;


    /**
     * Check if a player has been deactivated.
     * 
     * @param playerId The ID of the player.
     * @throws IDInvalidException If the ID does not match to any player in the system.
     * 
     * @return true if player has been deactivated or false otherwise 
     */
    boolean isDeactivatedPlayer(int playerId) throws IDInvalidException;


    /**
     * Updates the player's display name.
     * 
     * @param playerId The ID of the player to be updated.
     * @param displayName The new display name of the player.
     * @throws IDInvalidException If the ID does not match to any player in the system.
     * @throws InvalidNameException If the name is null, starts/ends with whitespace, 
     *                              is less than 1 characters or more than 20 characters.
     */
    void updatePlayerDisplayName(int playerId, String displayName) 
    throws  IDInvalidException, InvalidNameException;

    /**
     * Get the player id from the email.
     *
     * @param email The email of the player.
     * @return The ID of the player in the system or null if the player does not exist.
     */
    int getPlayerId(String email);


    /**
     * Get the player's display name.
     * 
     * @param playerId The ID of the player being queried.
     * @return The display name of the player.
     * @throws IDInvalidException If the ID does not match to any player in the system.
     * 
     */
    String getPlayerDisplayName(int playerId) throws IDInvalidException;


    /**
     * Get the player's email.
     * 
     * @param playerId The ID of the player being queried.
     * @return The email of the player.
     * @throws IDInvalidException If the ID does not match to any player in the system.
     * 
     */
    String getPlayerEmail(int playerId) throws IDInvalidException;


    /**
     * Get the in progress leagues a player is currently a member.
     * 
     * @param playerId The ID of the player being queried.
     * @return An array of league IDs the player is in or an empty array if none exists.
     * @throws IDInvalidException If the ID does not match to any player in the system.
     */
    int[] getPlayerLeagues(int playerId) throws IDInvalidException;


    /** 
     * Get the leagues a player owns.
     * 
     * @param playerId The ID of the player being queried.
     * @return An array of league IDs the player owns or an empty array if none exists.
     * @throws IDInvalidException If the ID does not match to any player in the system.
     */
    int[] getPlayerOwnedLeagues(int playerId) throws IDInvalidException;

    /**
     * Get the user's invites
     * 
     * @param playerId The ID of the player being queried.
     * @return An array of league IDs the player has invites to or an empty array if none exists.
     * @throws IDInvalidException If the ID does not match to any player in the system.
     */
    int[] getPlayerInvites(int playerId) throws IDInvalidException;


    /**
     * Get the user's rounds played game stat across all leagues
     * (includes closed/removed leagues)
     * 
     * @param playerId The ID of the player being queried.
     * @return number of rounds played by the player.
     * @throws IDInvalidException If the ID does not match to any player in the system.
     */
    int getPlayerRoundsPlayed(int playerId) throws IDInvalidException;


    /**
     * Get the user's round participation percentage stat
     *  i.e. if they play all games in all their leagues every day this will be 100
     *  (includes closed/removed leagues)
     * 
     * @param playerId The ID of the player being queried.
     * @return percentage of rounds (0-100) played by the player across all leagues.
     * @throws IDInvalidException If the ID does not match to any player in the system.
     */
    double getPlayerRoundsPercentage(int playerId) throws IDInvalidException;

    /**
     * Get the date that the user joined the site
     * 
     * @param playerId The ID of the player being queried.
     * @return LocalDate that stores the date the player created their account.
     * @throws IDInvalidException If the ID does not match to any player in the system.
     */
    LocalDate getPlayerJoinDate(int playerId) throws IDInvalidException;

    // Leagues

    /**
     * Get the leagues currently created in the platform.
     *
     * @return An array of leagues IDs in the system or an empty array if none exists.
     */
    int[] getLeagueIds();

    /**
     * Creates a league.
     * <p>
     * The state of this WordLeaguePortal must be unchanged if any
     * exceptions are thrown.
     *
     * @param owner PlayerId of the league owner.
     * @param name The name of the league.
     * @param gameType The game for which the league is set up.
     * @return The ID of the league in the system.
     * @throws IDInvalidException If the ID does not match to any player in the system.
     * @throws InvalidNameException If the name is null, starts/ends with whitespace, 
     *                              is less than 1 characters or more than 20 characters.
     * @throws IllegalNameException if it duplicates an existing league name
     */
    int createLeague(int owner, String name, GameType gameType ) throws IDInvalidException;

    /**
     * Removes a league and all associated game data from the system.
     * <p>
     * The state of this WordLeaguePortal must be unchanged if any
     * exceptions are thrown.
     *
     * @param leagueId The ID of the league to be removed.
     * @throws IDInvalidException If the ID does not match to any league in the system.
     */
    void removeLeague(int leagueId) throws IDInvalidException;

    /**
     * Get name of league
     * 
     * @param leagueId The ID of the league being queried.
     * @return The name of the league.
     * 
     * @throws IDInvalidException If the ID does not match to any league in the system.
     */
    String getLeagueName(int leagueId) throws IDInvalidException;

    /**
     * Update the name of a league
     * 
     * @param leagueId The ID of the league to be updated.
     * @param newName The new name of the league.
     * @throws IDInvalidException If the ID does not match to any league in the system.
     * @throws InvalidNameException If the name is null, starts/ends with whitespace, 
     *                              is less than 1 characters or more than 20 characters.
     * @throws IllegalNameException if it duplicates an existing league name.
     * 
     */
    void updateLeagueName(int leagueId, String newName) 
        throws IDInvalidException, 
                InvalidNameException, 
                IllegalNameException;


    /**
     * Invites a potential player (may not yet be site member) to a league.
     * <p>
     * 
     * @param leagueId The ID of the league to invite the player to.
     * @param email The email of the player to be invited.
     * @throws IDInvalidException If the ID does not match to any league or player in the system.
     * @throws InvalidEmailException If the email is null, empty, or does not contain an '@' character.
     */
    void invitePlayerToLeague(int leagueId, String email) 
        throws IDInvalidException, InvalidEmailException;

    /**
     * Accepts an invite to a league.
     *
     * @param leagueId The ID of the league to accept the invite to.
     * @param playerId The ID of the player.
     * 
     * @throws IDInvalidException If the ID does not match to any league or player in the system.
     * @throws IllegalOperationException If the player email does not have an active invitation.
     */
    void acceptInviteToLeague(int leagueId, int playerId) 
        throws IDInvalidException, IllegalOperationException;

    /**
     * Removes invite from league
     * 
     * @param leagueId The ID of the league to remove the invite from.
     * @param email The email of the player to remove the invite from.
     * @throws IDInvalidException If the ID does not match to any league or player in the system.
     * @throws IllegalEmailException If the email does not have an active invitation.
     */
    void removeInviteFromLeague(int leagueId, String email) 
        throws IDInvalidException, IllegalEmailException;


    /**
     * Get league invitations for non-existing players (email addresses)
     * 
     * @param leagueId The ID of the league being queried.
     * @return An array of email addresses of players with pending invites or an empty array if none exists.
     * @throws IDInvalidException If the ID does not match to any league in the system.
     */
    String[] getLeagueEmailInvites(int leagueId) throws IDInvalidException;


    /**
     * Get league invitations made to existing players (player IDs)
     * 
     * @param leagueId The ID of the league being queried.
     * @return An array of player IDs who have pending invites or an empty array if none exists.
     * @throws IDInvalidException If the ID does not match to any league in the system.
     */
    int[] getLeaguePlayerInvites(int leagueId) throws IDInvalidException;


    /**
     * Get the players in a league. 
     * The order of players should be the user that created the league,
     * (i.e. original owner), followed by other players in the order they accepted 
     * the league invitations.
     * 
     * @param leagueId The ID of the league being queried.
     * @return An array of player IDs in the league or an empty array if none exists.
     * @throws IDInvalidException If the ID does not match to any league in the system.
     */
    int[] getLeaguePlayers(int leagueId) throws IDInvalidException;


    /**
     * Get the owners of a league.
     * 
     * @param leagueId The ID of the league being queried.
     * @return An array of player IDs that are owners of the league or empty array if none exists.
     * @throws IDInvalidException If the ID does not match to any league in the system.
     */
    int[] getLeagueOwners(int leagueId) throws IDInvalidException;

    /**
     * Get the status of a league 
     * 
     * @param leagueId The ID of the league being queried.
     * @param day The epoch day being queried.
     * 
     * @return The status of the league as enum
     *          PENDING       not yet played
     *          IN_PROGRESS   active 
     *          CLOSED        ended  
     *  
     * @throws IDInvalidException If the ID does not match to any league in the system.
     */
    Status getLeagueStatus(int leagueId ) throws IDInvalidException;


    /**
     * Start league
     *
     * @param leagueId The ID of the league to start.
     * @param day Should be set to the epoch day when league will be made active.
     * @throws IDInvalidException If the ID does not match to any league in the system.
     * @throws IllegalOperationException If the league is already started.
     */
    void setLeagueStartDate(int leagueId, int  day) 
        throws IDInvalidException, IllegalOperationException;


    /** 
     * Close league, day specified may be any date after the league start day
     * 
     * @param leagueId The ID of the league to close.
     * @param day Should be set to the epoch day when league will be closed.
     * @throws IDInvalidException If the ID does not match to any league in the system.
     * @throws IllegalOperationException If the league is already closed or invalid day.
     */
    void setLeagueEndDate(int leagueId, int day) throws IDInvalidException;


    /**
     * Get the league start date (as epoch day).
     * 
     * @param leagueId The ID of the league being queried.
     * @return The start date of the league as epoch day.
     * @throws IDInvalidException If the ID does not match to any league in the system.
     */
    int getLeagueStartDate(int leagueId) throws IDInvalidException;


    /**
     * Get the date a closed league closed date (as epoch day).
     * 
     * @param leagueId The ID of the league being queried.
     * @return The closure date of the league as epoch day or -1 if not closed.
     * @throws IDInvalidException If the ID does not match to any league in the system.
     */
    int getLeagueCloseDate(int leagueId) throws IDInvalidException;


    /**
     * Reset league by removing all gameplay history i.e. no scores, and gives it pending status. 
     * status of active/inactive players is unchanged.
     * 
     * @param leagueId The ID of the league to reset.
     * 
     * @throws IDInvalidException If the ID does not match to any league in the system.
     */
    void resetLeague(int leagueId) throws IDInvalidException;


    /**
     * Clone a league to make a new league. 
     * Owners of the original league are also owners of the new league.
     * Invitations are created for all players in the original league.
     * League status is set to pending.
     * 
     * @param leagueId The ID of the league to clone.
     * @param newName The name of the new league.
     * @return The ID of the new league.
     * @throws IDInvalidException If the ID does not match to any league in the system.
     * @throws IllegalNameException If the new name already exists in the platform.
     */
    int cloneLeague(int leagueId, String newName) throws IDInvalidException;


    /**
     * Checks if player is active in the league.
     * 
     * @param leagueId The ID of the league.
     * @param playerId The ID of the player.
     * 
     * @throws IDInvalidException If the ID does not match to any league or player in the system.
     * @throws IllegalOperationException If the ID does not match to any player in the league.
     */
    boolean isLeaguePlayerActive(int leagueId, int playerId) 
        throws IDInvalidException, IllegalArgumentException;

    /** 
     * Sets a player to be registered as inactive in the league.
     * 
     * @param leagueId The ID of the league.
     * @param playerId The ID of the player.
     * 
     * @throws IDInvalidException If the ID does not match to any league or player in the system.
     * @throws IllegalOperationException If the ID does not match to any player in the league.
     */
    void setLeaguePlayerInactive(int leagueId, int playerId) 
        throws IDInvalidException, IllegalArgumentException;

    /** 
     * Sets a player to be registered as active in the league.
     * 
     * @param leagueId The ID of the league.
     * @param playerId The ID of the player.
     * 
     * @throws IDInvalidException If the ID does not match to any league or player in the system.
     * @throws IllegalOperationException If the ID does not match to any player in the league.
     */
    void setLeaguePlayerActive(int leagueId, int playerId) 
        throws IDInvalidException, IllegalArgumentException;


    /** 
     * Add owner   
     * 
     * @param leagueId The ID of the league to add the owner to.
     * @param playerId The ID of the player to add as an owner.
     * 
     * @throws IDInvalidException If the ID does not match to any league or player in the system.
     * @throws IllegalOperationException If the player is not a member of the league.
     * 
     */
    void addOwner(int leagueId, int playerId) 
        throws IDInvalidException, IllegalOperationException;

    /** 
     * Remove owner
     * 
     * @param leagueId The ID of the league to remove the owner from.
     * @param playerId The ID of the player to remove as an owner.
     * 
     * @throws IDInvalidException If the ID does not match to any league or player in the system.
     * @throws IllegalOperationException If the process would leave the league without an owner.
     * 
     */
    void removeOwner(int leagueId, int playerId) 
        throws IDInvalidException, IllegalOperationException;


    // Results

    /**
     * Register gameplay by a player in a league. 
     * The status of the player should be set to IN_PROGRESS.
     * 
     * @param leagueId The ID of the league being queried.
     * @param playerId The ID of the player being queried.
     * @param day The epoch day the game was played.
     * @param gameReport A report detailing the gameplay, may be empty if no report made,
     *                   this may be updated e.g. after other players take actions that affect result
     *
     * @throws IDInvalidException If ID do not match to any league & player in the system.
     * @throws IllegalOperationException If the day is not a valid day for the league.
     */
    void registerGameReport(int day, int leagueId,  int playerId, String gameReport ) 
        throws IDInvalidException, IllegalOperationException;


    /** 
     * Get the game report for a player in a league.
     * 
     * @param leagueId The ID of the league being queried.
     * @param playerId The ID of the player being queried.
     * @param day The epoch day the game was played.
     * 
     * @return The game report for the player in the league on the day, or empty string if no report entry.
     * 
     * @throws IDInvalidException If the ID does not match to any league in the system.
     * @throws InvalidDateException If the day is not a valid day for the league.
     */
    String getGameReport(int day, int leagueId,  int playerId) 
        throws IDInvalidException, InvalidDateException;


    /**
     * Register day game scores. Will be called when all play in a round is complete.
     * with scored ordered to match player array returned by getLeaguePlayers().
     * Once scores are registered the game status for each player should be set to CLOSED.
     * 
     * @param day The epoch day the game was played.
     * @param leagueId The ID of the league being queried.
     * @param scores The game scores with order to match the array returned by getLeaguePlayers().
     * @throws IDInvalidException If the ID does not match to any league in the system.
     * @throws IllegalArgumentException If the day specified has already been closed,
     *                                  or if current date is 2 days or more after the day being voided.
     */
    void registerDayScores(int day, int leagueId, int[] scores) 
        throws IDInvalidException, IllegalArgumentException;


    /**
     * Register a void day for a league - all points set to zero
     *
     * @param leagueId The ID of the league being queried.
     * @param playerId The ID of the league being queried.
     * @param day The epoch day being queried.
     * @throws IDInvalidException If the ID does not match to any league in the system.
     * @throws IllegalArgumentException If the day is not a valid day for the league,
     *                 or the current day is 2 days or more after the day being voided.
     */
    void voidDayPoints(int day, int leagueId) 
        throws IDInvalidException, IllegalArgumentException;  


    /**
     * Get the status of league games for a given day.
     * with results ordered to match player array returned by getLeaguePlayers().
     * @param leagueId The ID of the league being queried.
     * @param day The epoch day being queried.
     * 
     * @return The status of the day as enum
     *          PENDING       no gameplay yet
     *          IN_PROGRESS   active and still games to play
     *          CLOSED        ended all games played or month ended   
     *  
     * @throws IDInvalidException If the ID does not match to any league in the system.
     * @throws InvalidDateException If the day is not a valid day for the league.
     */
    Status getDayStatus(int leagueId, int day ) 
        throws IDInvalidException, InvalidDateException;


    /**
     * Get the scores of a round for a given day.
     * with results ordered to match player array returned by getLeaguePlayers().
     *
     * @param leagueId The ID of the league being queried.
     * @param day The epoch day being queried.
     * 
     * @return An array of registered score results for each player from the day 
     *         or empty array if no gameplay from any players yet.
     *         (where gameplay is in progress the returned scores will be 0)
     *          
     * @throws IDInvalidException If the ID does not match to any league in the system.
     * @throws InvalidDateException If the day is not a valid day for the league.
     */
    int[] getDayScores(int leagueId, int day ) 
        throws IDInvalidException, InvalidDateException;


    /**
     * Get the league points of a league for a given day.
     * with results ordered to match player array returned by getLeaguePlayers().
     *
     * @param leagueId The ID of the league being queried.
     * @param day The epoch day being queried.
     * 
     * @return An array of the league points for each player from the day 
     *         or empty array if league points have not been finalised yet. 
     *          
     * @throws IDInvalidException If the ID does not match to any league in the system.
     * @throws InvalidDateException If the day is not a valid day for the league.
     */
    int[] getDayPoints(int leagueId, int day ) 
        throws IDInvalidException, InvalidDateException;


    /**
     * Get the player rankings of a league for a given day, 
     * with results ordered to match player array returned by getLeaguePlayers().
     * 
     * @param leagueId The ID of the league being queried.
     * @param day The epoch day being queried.
     * 
     * @return an array containing the rankings of the players
     *         or empty array if rankings not yet available.
     * 
     * @throws IDInvalidException If the ID does not match to any league in the system.
     * @throws InvalidDateException If the day is not a valid day for the league.
     */
    int[] getDayRanking(int leagueId, int day ) 
        throws IDInvalidException, InvalidDateException;


    /**
     * Get the status of a league for a given week.
     * 
     * @param leagueId  The ID of the league being queried.
     * @param day       Epoch day that is within the week being queried.
     * 
     * @return The status of the day as enum
     *          PENDING       no gameplay yet
     *          IN_PROGRESS   active and still games to play
     *          CLOSED        ended all games played or week ended    
     *  
     * @throws IDInvalidException If the ID does not match to any league in the system.
     *         InvalidDateException If the day is not within a valid week for the league.
     */
    Status getWeekStatus(int leagueId, int day ) 
        throws IDInvalidException, InvalidDateException;


    /**
     * Get the league points of a league for a given week,
     * with results ordered to match player array returned by getLeaguePlayers().
     *  
     * @param leagueId  The ID of the league being queried.
     * @param day       Epoch day that is within the week being queried.
     * 
     * @return An array of the points of each players total for the week (or part week played) 
     *         or empty array if no points yet.
     * 
     * @throws IDInvalidException If the ID does not match to any league in the system.
     *         InvalidDateException If the day is not within a valid week for the league.
     */
    int[] getWeekPoints(int leagueId, int day ) 
        throws IDInvalidException, InvalidDateException;


    /**
     * Get the ranking of a league for a given week.
     * with results ordered to match player array returned by getLeaguePlayers().
     * 
     * @param leagueId  The ID of the league being queried.
     * @param day       Epoch day that is within the week being queried.
     * 
     * @return An array of the rankings of each players for the week (or part week played) 
     *         or empty array if no rankings yet.
     * 
     * @throws IDInvalidException If the ID does not match to any league in the system.
     *         InvalidDateException     If the day is not within a valid week for the league.
     */
    int[] getWeekRanking(int leagueId, int day ) 
        throws IDInvalidException, InvalidDateException;


    /**
     * Get the status of a league for a given month.
     * 
     * 
     * @param leagueId  The ID of the league being queried.
     * @param day       Epoch day that is within the month being queried.
     * 
     * @return The status of the month as enum
     *          PENDING       no gameplay yet
     *          IN_PROGRESS   active and still games to play
     *          CLOSED        ended all games played or month ended    
     *  
     * @throws IDInvalidException If the ID does not match to any league in the system.
     *         InvalidDateException If the day is not within a valid month for the league.
     */
    Status getMonthStatus(int leagueId, int day ) 
        throws IDInvalidException, InvalidDateException;


    /**
     * Get the league points of a league for a given month.
     * with results ordered to match player array returned by getLeaguePlayers().
     * 
     * @param leagueId  The ID of the league being queried.
     * @param day       Epoch day that is within the month being queried.
     * 
     * @return An array of the points of each players total for the month (or part month played) 
     *         or empty array if no points yet.
     * 
     * @throws IDInvalidException If the ID does not match to any league in the system.
     * @throws InvalidDateException If the day is not within a valid month for the league.
     */
    int[] getMonthPoints(int leagueId, int day ) 
        throws IDInvalidException, InvalidDateException;


    /**
     * Get the ranking of a league for a given month.
     * 
     * @param leagueId  The ID of the league being queried.
     * @param day       Epoch day that is within the month being queried.
     * 
     * @return An array of the rankings of each players for the month (or part month played) 
     *         or empty array if no rankings yet.
     * 
     * @throws IDInvalidException If the ID does not match to any league in the system.
     * @throws InvalidDateException     If the day is not within a valid month for the league.
     */
    int[] getMonthRanking(int leagueId, int day ) 
            throws IDInvalidException, InvalidDateException;


    /**
     * Get the status of a league for a given year.
     * 
     * 
     * @param leagueId  The ID of the league being queried.
     * @param day       Epoch day that is within the year being queried.
     * 
     * @return The status of the day as enum
     *          PENDING       no gameplay yet
     *          IN_PROGRESS   active and still games to play
     *          CLOSED        ended all games played or year has ended    
     *  
     * @throws IDInvalidException If the ID does not match to any league in the system.
     * @throws InvalidDateException If the day is not within a valid year for the league.
     */
    Status getYearStatus(int leagueId, int day ) 
            throws IDInvalidException, InvalidDateException;


    /**
     * Get the league points of a league for a given year.
     * 
     * @param leagueId  The ID of the league being queried.
     * @param day       Epoch day that is within the year being queried.
     * 
     * @return An array of the league points of each players total for the year (or part year played) 
     *         or empty array if no points yet.
     * 
     * @throws IDInvalidException If the ID does not match to any league in the system.
     * @throws InvalidDateException If the day is not within a valid month for the league.
     */
    int[] getYearPoints(int leagueId, int day ) 
        throws IDInvalidException, InvalidDateException;


    /**
     * Get the ranking of a league for a given year.
     * 
     * @param leagueId  The ID of the league being queried.
     * @param day       Epoch day that is within the year being queried.
     * 
     * @return An array of the rankings of each players for the year (or part year played) 
     *         or empty array if no rankings yet.
     * 
     * @throws IDInvalidException   If the ID does not match to any league in the system.
     * @throws InvalidDateException If the day is not within a valid year for the league.
     **/
    int[] getYearRanking(int leagueId, int day ) 
        throws IDInvalidException, InvalidDateException;


    /**
     * Method empties this GamesLeaguePortal of its contents and resets all
     * internal counters.
     */
    void eraseGamesLeagueData();


    /**
     * Method saves this GamesLeaguePortal contents into a serialised file,
     * with the filename given in the argument.
     * <p>
     * The state of this GamesLeaguePortal must be unchanged if any
     * exceptions are thrown.
     *
     * @param filename Location of the file to be saved.
     * @throws IOException If there is a problem experienced when trying to save the 
     *                     contents to the file.
     */
    void saveGamesLeagueData(String filename) throws IOException;


    /**
     * Method should load and replace this GamesLeaguePortal contents with the
     * serialised contents stored in the file given in the argument.
     *
     * @param filename Location of the file to be loaded.
     * @throws IOException If there is a problem experienced when trying
     *                     to load the store contents from the file.
     * @throws ClassNotFoundException If required class files cannot be found when loading.
     */
    void loadGamesLeagueData(String filename) throws IOException, ClassNotFoundException;

    }


