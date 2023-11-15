package Factorys;

import java.util.*;
import Commands.*;
import Given.Team;

public class AddPlayerCommandFactory implements CommandFactory {
    private Scanner sc;
    private Team[] currTeam;
    private Stack<Command> undos;
    private HashMap<Class<?>, String> addPlayerPromptString;
    private HashMap<Class<?>, int[]> addPlayerPosChoice;
    private HashMap<Class<?>, HashMap<int[], String[]>> classPosNamHM;

    public AddPlayerCommandFactory(Scanner sc, Team[] currTeam, Stack<Command> undos,
            HashMap<Class<?>, String> addPlayerPromptString, HashMap<Class<?>, int[]> addPlayerPosChoice,
            HashMap<Class<?>, HashMap<int[], String[]>> classPosNamHM) {
        this.sc = sc;
        this.currTeam = currTeam;
        this.undos = undos;
        this.addPlayerPromptString = addPlayerPromptString;
        this.addPlayerPosChoice = addPlayerPosChoice;
        this.classPosNamHM = classPosNamHM;
    }

    public Command createCommand() {
        Command com = new AddPlayerCommand(sc, currTeam, addPlayerPromptString, addPlayerPosChoice, classPosNamHM);
        undos.push(com);
        return com;
    }
}
