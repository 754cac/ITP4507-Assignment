package Commands;

import java.util.Scanner;
import Given.*;
import Memento.Caretaker;

public class RenameTeamCommand implements Command {
    private Scanner sc;
    private String teamName;
    private Team[] currTeam;
    private Caretaker ct;
    private String toString;

    public RenameTeamCommand(Scanner sc, Team[] currTeam, Caretaker ct) {
        this.sc = sc;
        this.currTeam = currTeam;
        this.ct = ct;
    }

    public void execute() {
        System.out.print("Please input new name of the current team:-");
        teamName = sc.nextLine();
        ct.saveMyTeam(currTeam[0]);
        currTeam[0].setName(teamName);
        System.out.println("Team’s name is updated.");
        toString = "Change team’s name, " + currTeam[0].getTeamID() + ", " + currTeam[0].getName();
    }

    public void undo() {
        ct.undo();
    }

    public void redo() {
        if (teamName != null) {
            ct.saveMyTeam(currTeam[0]);
            currTeam[0].setName(teamName);
        }
    }

    public String toString() {
        return toString;
    }
}