package Factorys;

import java.util.*;
import Commands.*;
import Given.*;

public class CreateTeamCommandFactory implements CommandFactory {
    private Scanner sc;
    private Vector<Team> Teams;
    private Team[] currTeam;
    private Stack<Command> undos;
    private HashMap<String, TeamFactory> createTeamF;
    private HashMap<Class<?>, String> createTeamString;

    public CreateTeamCommandFactory(Scanner sc, Vector<Team> Teams, Team[] currHolder, Stack<Command> undos,
            HashMap<String, TeamFactory> createTeamF,
            HashMap<Class<?>, String> createTeamString) {
        this.sc = sc;
        this.Teams = Teams;
        this.currTeam = currHolder;
        this.undos = undos;
        this.createTeamF = createTeamF;
        this.createTeamString = createTeamString;
    }

    public Command createCommand() {
        Command com = new CreateTeamCommand(sc, Teams, currTeam,createTeamF,createTeamString);
        undos.push(com);
        return com;
    }
}