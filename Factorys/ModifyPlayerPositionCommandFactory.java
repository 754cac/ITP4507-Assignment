package Factorys;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

import Commands.Command;
import Commands.ModifyPlayerPositionCommand;
import Given.Team;
import Memento.*;

public class ModifyPlayerPositionCommandFactory implements CommandFactory {
    private Team[] currTeam;
    private Stack<Command> undos;
    private Scanner sc;
    private Caretaker tc;
    private HashMap<Class<?>, int[]> addPlayerPosChoice;
    private HashMap<Class<?>, HashMap<int[], String[]>> classPosNamHM;

    public ModifyPlayerPositionCommandFactory(Team[] currTeam, Scanner sc, Caretaker tc, Stack<Command> undos,
            HashMap<Class<?>, int[]> addPlayerPosChoice,
            HashMap<Class<?>, HashMap<int[], String[]>> classPosNamHM) {
        this.currTeam = currTeam;
        this.sc = sc;
        this.tc = tc;
        this.undos = undos;
        this.addPlayerPosChoice=addPlayerPosChoice;
        this.classPosNamHM=classPosNamHM;
    }

    public Command createCommand() {
        Command com = new ModifyPlayerPositionCommand(currTeam, sc, tc,addPlayerPosChoice,classPosNamHM);
        undos.push(com);
        return com;
    }
}