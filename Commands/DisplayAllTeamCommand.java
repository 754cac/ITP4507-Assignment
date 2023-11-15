package Commands;

import java.util.Vector;

import Given.Team;
import Given.VolleyballTeam;

public class DisplayAllTeamCommand implements Command {
    private Vector<Team> Teams;

    public DisplayAllTeamCommand(Vector<Team> Teams) {
        this.Teams = Teams;
    }

    public void execute() {
        for (Team ts : Teams) {
            if (ts.getClass().equals(VolleyballTeam.class)) {
                System.out.println("Volleyball Team " + ts.getName() + " (" + ts.getTeamID() + ")");
            } else {
                System.out.println("Football Team " + ts.getName() + " (" + ts.getTeamID() + ")");
            }
        }
    }

    public void undo() {
    }

    public void redo() {
    }

}
