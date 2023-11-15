package Factorys;

import java.util.Scanner;

import java.util.Vector;

import Commands.Command;
import Commands.*;
import Given.Team;

public class SetCurrentTeamCommandFactory implements CommandFactory {
    private Scanner sc;
    private Vector<Team> Teams;
    private Team[] currHolder;

    public SetCurrentTeamCommandFactory(Scanner sc, Vector<Team> Teams, Team[] currHolder) {
        this.sc = sc;
        this.Teams = Teams;
        this.currHolder = currHolder;
    }

    public Command createCommand() {
        Command com = new SetCurrentTeamCommand(sc, Teams, currHolder);
        return com;
    }
}