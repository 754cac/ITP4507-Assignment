package Factorys;

import java.util.HashMap;

import Commands.Command;
import Commands.DisplayTeamCommand;
import Given.Team;

public class DisplayTeamCommandFactory implements CommandFactory {
    private HashMap<Class<?>, HashMap<int[], String[]>> classPosNamHM;
    private Team[] currTeam;
    private HashMap<Class<?>, int[]> addPlayerPosChoice;

    public DisplayTeamCommandFactory(Team[] currTeam, HashMap<Class<?>, HashMap<int[], String[]>> classPosNamHM,
            HashMap<Class<?>, int[]> addPlayerPosChoice) {
        this.currTeam = currTeam;
        this.classPosNamHM = classPosNamHM;
        this.addPlayerPosChoice = addPlayerPosChoice;
    }

    public Command createCommand() {
        Command com = new DisplayTeamCommand(currTeam, classPosNamHM, addPlayerPosChoice);
        return com;
    }
}