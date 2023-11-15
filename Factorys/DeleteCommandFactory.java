package Factorys;

import java.util.Scanner;
import java.util.Stack;
import Commands.Command;
import Commands.DeleteCommand;
import Given.Team;

public class DeleteCommandFactory implements CommandFactory {
    private Stack<Command> undos;
    private Scanner sc;
    private Team []currTeam;

    public DeleteCommandFactory(Scanner sc, Team []currTeam, Stack<Command> undos) {
        this.sc = sc;
        this.currTeam = currTeam;
        this.undos = undos;
    }

    public Command createCommand() {
        Command com = new DeleteCommand(sc, currTeam);
        undos.push(com);
        return com;
    }
}