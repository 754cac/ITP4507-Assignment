package Given;

public class FootballTeam extends Team {
    private final int GOALKEEPER_POSITION = 1;
    private final int DEFENDER_POSITION = 2;
    private final int MIDFIELDER_POSITION = 3;
    private final int FORWARD_POSITION = 4;

    public FootballTeam(String teamID) {
        super(teamID);
    }

    public void updatePlayerPosition() {
        System.out.print("Position (" + GOALKEEPER_POSITION + " = goal keeper | " + DEFENDER_POSITION + " = defender | "
                + MIDFIELDER_POSITION + " = midfielder | " + FORWARD_POSITION + " = forward):-");
    }

    public void displayTeam() {
    }
}