package Commands;

import java.util.*;
import Given.*;
import Factorys.*;

public class CreateTeamCommand implements Command {
    private Scanner sc;
    private Team t;
    private Vector<Team> Teams;
    private Team[] currTeam;
    private Team oldTeam;
    private String sportType;
    private String teamID;
    private String teamName;
    private String toString;
    private HashMap<String, TeamFactory> createTeamF;
    private HashMap<Class<?>, String> createTeamString;

    public CreateTeamCommand(Scanner sc, Vector<Team> Teams, Team[] currTeam,
            HashMap<String, TeamFactory> createTeamF,
            HashMap<Class<?>, String> createTeamString) {
        this.sc = sc;
        this.Teams = Teams;
        this.oldTeam = currTeam[0];
        this.currTeam = currTeam;
        this.createTeamF = createTeamF;
        this.createTeamString = createTeamString;
    }

    public void execute() {
        System.out.print("Enter sport type (v = volleyball | f = football) :- ");
        sportType = sc.nextLine();
        System.out.print("Team ID:- ");
        teamID = sc.nextLine();
        System.out.print("Team Name:- ");
        teamName = sc.nextLine();
        t = createTeamF.get(sportType).createTeam(teamID);
        t.setName(teamName);
        System.out.println(createTeamString.get(t.getClass()) + " team is created.");
        Teams.add(t);
        currTeam[0] = t;
        // Create toString to be used by undo/redo command
        toString = "Create " + createTeamString.get(t.getClass()).toLowerCase() + " team, " + teamID + ", " + teamName;
        if (currTeam[0] != null)
            System.out.println("Current team is changed to " + currTeam[0].getTeamID());

    }

    public void undo() {
        if (t != null) {
            Teams.remove(t);
            if (!currTeam[0].getTeamID().equals(oldTeam.getTeamID())) {
                System.out.println("The current team is changed to " + oldTeam.getTeamID() + " " + oldTeam.getName());
            }
            currTeam[0] = oldTeam;
        }
    }

    public void redo() {
        if (t != null) {
            Teams.add(t);
            if (!currTeam[0].getTeamID().equals(t.getTeamID())) {
                System.out.println(
                        "The current team is changed to " + t.getTeamID());
            }
            currTeam[0] = t;
        }
    }

    public String toString() {
        return toString;
    }
}