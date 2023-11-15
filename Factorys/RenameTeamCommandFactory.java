package Factorys;

import java.util.Scanner;
import java.util.Stack;

import Commands.Command;
import Commands.RenameTeamCommand;
import Given.Team;
import Memento.Caretaker;

public class RenameTeamCommandFactory implements CommandFactory {
    private Scanner sc;
    private Team[] currTeam;
    private Stack<Command> undos;
    private Caretaker ct;

    public RenameTeamCommandFactory(Scanner sc, Team[] currTeam, Stack<Command> undos, Caretaker ct) {
        this.sc = sc;
        this.currTeam = currTeam;
        this.undos = undos;
        this.ct = ct;
    }

    public Command createCommand() {
        Command com = new RenameTeamCommand(sc, currTeam, ct);
        undos.push(com);
        return com;
    }
}