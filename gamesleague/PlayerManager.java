package gamesleague;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
    private List<Player> players = new ArrayList<>();

    public Player createPlayer(String email, String displayName, String name, String phone) {
        Player player = new Player();
        player.createPlayer(email, displayName, name, phone);
        players.add(player);
        return player;
    }

    public void deactivatePlayer(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                player.deactivatePlayer();
                break;
            }
        }
    }

    public boolean isDeactivatedPlayer(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player.isDeactivatedPlayer();
            }
        }
        return false; // Return false if player with given id is not found
    }

    public void updatePlayerDisplayName(int id, String displayName) {
        for (Player player : players) {
            if (player.getId() == id) {
                player.updatePlayerDisplayName(displayName);
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
                return player.getPlayerDisplayName();
            }
        }
        return null; // Return null if player with given id is not found
    }

    public String getPlayerEmail(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player.getPlayerEmail();
            }
        }
        return null; // Return null if player with given id is not found
    }

    public String getPlayerLeagues(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player.getPlayerLeagues();
            }
        }
        return null; // Return null if player with given id is not found
    }
}