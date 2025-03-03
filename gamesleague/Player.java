package gamesleague;

import java.time.LocalDate;
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
    private List<Integer> ownedLeagues = new ArrayList<>();
    private List<Integer> invitedLeagues = new ArrayList<>();
    private int roundsPlayed = 0;
    private double roundsPercentage = 0.0;
    private LocalDate joinDate = LocalDate.now(); // To later be changed

    public int createPlayer(String email, String displayName, String name, String phone) {
        this.id = ++lastId; // Increment the lastId and assign it to the player's ID
        this.email = email;
        this.displayName = displayName;
        this.name = name;
        this.phone = phone;
        this.isActive = true;
        return this.id; // Return the unique ID
    }

    public void deactivate() {
        this.isActive = false;
    }

    public boolean isDeactivated() {
        return !this.isActive;
    }

    public void updateDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    public int[] getLeagues() {
        int[] leaguesIds = new int[leagues.size()];
        for (int i = 0; i < leagues.size(); i++) {
            leaguesIds[i] = leagues.get(i);
        }
        return leaguesIds;
    }

    public int[] getOwnedLeagues() {
        int[] leaguesIds = new int[ownedLeagues.size()];
        for (int i = 0; i < ownedLeagues.size(); i++) {
            leaguesIds[i] = ownedLeagues.get(i);
        }
        return leaguesIds;
    }

    public int[] getInvites() {
        int[] leaguesIds = new int[invitedLeagues.size()];
        for (int i = 0; i < invitedLeagues.size(); i++) {
            leaguesIds[i] = invitedLeagues.get(i);
        }
        return leaguesIds;
    }

    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    public double getRoundsPercentage() {
        return roundsPercentage;
    }

    public LocalDate getJoinDate() {
        return joinDate;
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
