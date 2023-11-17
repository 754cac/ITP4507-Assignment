package Commands;

import Given.Team;
import java.util.*;

public class SetCurrentTeamCommand implements Command {
    private Scanner sc;
    private String teamID;
    private Vector<Team> Teams;
    private Team[] currTeam;
    private Team oldTeam;
    private Team newTeam;

    public SetCurrentTeamCommand(Scanner sc, Vector<Team> Teams, Team[] currHolder) {
        this.sc = sc;
        this.Teams = Teams;
        this.oldTeam = currHolder[0];
        this.currTeam = currHolder;
    }

    public void execute() {
        System.out.print("Please input team ID:-");
        teamID = sc.nextLine();
        for (Team t : Teams) {
            if (t.getTeamID().equals(teamID)) {
                newTeam = t;
                currTeam[0] = t;
                System.out.println("Changed current team to " + currTeam[0].getTeamID());
            }
        }
        if (!currTeam[0].getTeamID().equals(teamID)) {
            System.out.println("Team " + teamID + " is not found!!");
        }
    }

    public void undo() {
        if (oldTeam != null) {
            currTeam[0] = oldTeam;
            System.out.println("Changed current team to " + this.currTeam[0].getTeamID());
        }
    }

    public void redo() {
        if (newTeam != null) {
            currTeam[0] = newTeam;
        }
    }
}
