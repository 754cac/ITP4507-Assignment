package Commands;

import java.util.HashMap;
import java.util.Scanner;
import Given.*;
import Factorys.*;

public class AddPlayerCommand implements Command {
    private Scanner sc;
    private String idName;
    private String[] idNameParts;
    private Player player;
    private int position;
    private Team[] currTeam;
    private Team oldTeam;
    private String toString;
    private HashMap<Class<?>, String> addPlayerPromptString;
    private HashMap<Class<?>, int[]> addPlayerPosChoice;
    private HashMap<Class<?>, HashMap<int[], String[]>> classPosNamHM;

    public AddPlayerCommand(Scanner sc, Team[] currTeam, HashMap<Class<?>, String> addPlayerPromptString,
            HashMap<Class<?>, int[]> addPlayerPosChoice,
            HashMap<Class<?>, HashMap<int[], String[]>> classPosNamHM) {
        this.sc = sc;
        this.oldTeam = currTeam[0];
        this.currTeam = currTeam;
        this.addPlayerPromptString = addPlayerPromptString;
        this.addPlayerPosChoice = addPlayerPosChoice;
        this.classPosNamHM = classPosNamHM;
        player = null;
    }

    public void execute() {
        System.out.print("Please input player information (id, name):-");
        idName = sc.nextLine();
        idNameParts = idName.split(",");
        player = new PlayerFactory(idNameParts[0].trim(), idNameParts[1].trim()).createPlayer();
        if (currTeam != null) {
            System.out.print(addPlayerPromptString.get(currTeam[0].getClass()));
            position = Integer.parseInt(sc.nextLine());
            player.setPosition(position);
            currTeam[0].addPlayer(player);
            System.out.println("Player is added");
            toString = "Add player, " + idNameParts[0] + ", " + idNameParts[1] + ", "
                    + classPosNamHM.get(currTeam[0].getClass())
                            .get(addPlayerPosChoice.get(currTeam[0].getClass()))[position - 1];
        }
    }

    public void undo() {
        if (player != null) {
            // currTeam[0].remove(player);
            oldTeam.remove(player);
            if (!currTeam[0].getTeamID().equals(oldTeam.getTeamID())) {
                System.out.println("The current team is changed to " + oldTeam.getTeamID() + " " + oldTeam.getName());
            }
            currTeam[0] = oldTeam;
        }
    }

    public void redo() {
        if (player != null) {
            oldTeam.addPlayer(player);
            if (!currTeam[0].getTeamID().equals(oldTeam.getTeamID())) {
                System.out.println("The current team is changed to " + oldTeam.getTeamID() + " " + oldTeam.getName());
            }
            currTeam[0] = oldTeam;
        }
    }

    public String toString() {
        return toString;
    }

}
