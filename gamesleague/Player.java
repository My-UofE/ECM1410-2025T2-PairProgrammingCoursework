package gamesleague;

public class Player {
    private static int lastId = 0; // Static variable to keep track of the last assigned ID
    private int id;
    private String name;
    private String displayName;
    private String email;
    private String phone;
    private boolean isActive;

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

    public int getId() {
        return id;
    }

    public String getPlayerDisplayName() {
        return displayName;
    }

    public String getPlayerEmail() {
        return email;
    }

    public String getPlayerLeagues() {
        // Assuming leagues is a field or can be derived, implement accordingly
        // For now, returning a placeholder string
        return "Leagues information";
    }

    public void updatePlayerDisplayName(String displayName) {
        this.displayName = displayName;
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
