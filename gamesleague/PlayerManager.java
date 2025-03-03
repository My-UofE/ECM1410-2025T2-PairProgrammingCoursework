package gamesleague;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
    private List<Player> players = new ArrayList<>();

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

}