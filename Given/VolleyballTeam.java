package Given;

public class VolleyballTeam extends Team {
    private final int ATTACKER_POSITION = 1;
    private final int DEFENDER_POSITION = 2;

    public VolleyballTeam(String teamID) {
        super(teamID);
    }

    public void updatePlayerPosition() {
        System.out.print("Position (" + ATTACKER_POSITION + " = attacker | " + DEFENDER_POSITION + " = defender ):-");
    }

    public void displayTeam() {
        System.out.println("Volleyball Team " + getName() + " (" + getTeamID() + ")");
    }
}
