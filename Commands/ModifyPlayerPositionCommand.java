package Commands;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Given.Player;
import Given.Team;
import Memento.*;

public class ModifyPlayerPositionCommand implements Command {
    private Team[] currTeam;
    private Enumeration<Player> playeresEnumeration;
    private String playerID;
    private Scanner sc;
    private HashMap<Integer, Player> playerHashMap;
    private int index;
    private Player player;
    private Player playerHolder;
    private int position;
    private Caretaker ct;
    private String toString;
    private HashMap<Class<?>, int[]> addPlayerPosChoice;
    private HashMap<Class<?>, HashMap<int[], String[]>> classPosNamHM;
    private HashMap<int[], String[]> positionMap;
    private int[] positionNumMap;
    private String[] positionNameMap;

    public ModifyPlayerPositionCommand(Team[] currTeam, Scanner sc, Caretaker ct,
            HashMap<Class<?>, int[]> addPlayerPosChoice,
            HashMap<Class<?>, HashMap<int[], String[]>> classPosNamHM) {
        this.currTeam = currTeam;
        this.sc = sc;
        this.ct = ct;
        this.addPlayerPosChoice = addPlayerPosChoice;
        this.classPosNamHM = classPosNamHM;
    }

    public void execute() {

        System.out.print("Please input player ID:-");
        playerID = sc.nextLine();
        playeresEnumeration = currTeam[0].getAllPlayers();
        playerHashMap = new HashMap<Integer, Player>();

        index = 0;
        while (playeresEnumeration.hasMoreElements()) {
            player = playeresEnumeration.nextElement();
            playerHashMap.put(index++, player);
        }
        currTeam[0].updatePlayerPosition();
        position = Integer.parseInt(sc.nextLine());
        positionMap = classPosNamHM.get(currTeam[0].getClass());
        positionNumMap = addPlayerPosChoice.get(currTeam[0].getClass());
        positionNameMap = positionMap.get(positionNumMap);
        for (Map.Entry<Integer, Player> entry : playerHashMap.entrySet()) {
            playerHolder = entry.getValue();
            if (position >= 1 && position <= 2 &&
                    playerID.equals(playerHolder.getPlayerID())) {
                player = playerHolder;
                ct.savePlayer(player);
                player.setPosition(position);
                currTeam[0].remove(playerHolder);
                currTeam[0].addPlayer(player);
                toString = "Modify player’s position, " + playerID + ", " + positionNameMap[position - 1];
            }
        }
    }

    public void undo() {
        ct.undo();
    }

    public void redo() {
        if (player != null) {
            currTeam[0].remove(playerHolder);
            currTeam[0].addPlayer(player);
        }
    }

    public String toString() {
        return toString;
    }
}