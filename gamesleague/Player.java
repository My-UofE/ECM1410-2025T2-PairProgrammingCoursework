package gamesleague;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static int lastId = 0; // Static variable to keep track of the last assigned ID
    private int id;
    private String name;
    private String displayName;
    private String email;
    private String phone;
    private boolean isActive;
    private List<Integer> leagues = new ArrayList<>();

    public int createPlayer(String email, String displayName, String name, String phone) {
        this.id = ++lastId; // Increment the lastId and assign it to the player's ID
        this.email = email;
        this.displayName = displayName;
        this.name = name;
        this.phone = phone;
        this.isActive = true;
        return this.id; // Return the unique ID
    }

    public void deactivatePlayer() {
        this.isActive = false;
    }

    public boolean isDeactivatedPlayer() {
        return !this.isActive;
    }

    public void updatePlayerDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getId() {
        return id;
    }

    public String getPlayerDisplayName() {
        return displayName;
    }

    public String getPlayerEmail() {
        return email;
    }

    public int[] getPlayerLeagues() {
        int[] leaguesIds = new int[leagues.size()];
        for (int i = 0; i < leagues.size(); i++) {
            leaguesIds[i] = leagues.get(i);
        }
        return leaguesIds;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
