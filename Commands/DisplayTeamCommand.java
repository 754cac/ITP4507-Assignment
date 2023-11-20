package Commands;

import java.util.*;
import Given.*;

public class DisplayTeamCommand implements Command {
    private Team[] currTeam;
    private Enumeration<Player> playeresEnumeration;
    private Map<Integer, List<Player>> positionMap;
    private List<Player> playerList;
    private Player player;
    private int position;
    private HashMap<Class<?>, HashMap<int[], String[]>> classPosNamHM;
    private HashMap<Class<?>, int[]> addPlayerPosChoice;
    private HashMap<int[], String[]> positionHM;
    private int[] positionNumMap;
    private String[] positionNameMap;
    private String positionName;

    public DisplayTeamCommand(Team[] currTeam, HashMap<Class<?>, HashMap<int[], String[]>> classPosNamHM,
            HashMap<Class<?>, int[]> addPlayerPosChoice) {
        this.currTeam = currTeam;
        this.classPosNamHM = classPosNamHM;
        this.addPlayerPosChoice = addPlayerPosChoice;
    }

    public void execute() {
        if (currTeam[0] != null) {
            positionHM = classPosNamHM.get(currTeam[0].getClass());
            positionNumMap = addPlayerPosChoice.get(currTeam[0].getClass());
            positionNameMap = positionHM.get(positionNumMap);

            currTeam[0].displayTeam();
            playeresEnumeration = currTeam[0].getAllPlayers();
            positionMap = new HashMap<>();
            for (int p : addPlayerPosChoice.get(currTeam[0].getClass()))
                positionMap.put(p, new ArrayList<>());
            while (playeresEnumeration.hasMoreElements()) {
                player = playeresEnumeration.nextElement();
                position = player.getPosition();
                positionMap.get(position).add(player);
            }

            for (Map.Entry<Integer, List<Player>> entry : positionMap.entrySet()) {
                position = entry.getKey();
                playerList = entry.getValue();

                positionName = positionNameMap[position - 1];
                System.out.println(positionName.substring(0, 1).toUpperCase() + positionName.substring(1) + ":");

                if (playerList.isEmpty()) {
                    System.out.println("NIL");
                } else {
                    // Sort players in each position based on player ID
                    Collections.sort(playerList, Comparator.comparing(Player::getPlayerID));

                    for (Player player : playerList) {
                        System.out.println(player.getPlayerID() + ", " + player.getName());
                    }
                }
            }
        }

    }

    public void undo() {
    }

    public void redo() {
    }

    public String toString() {
        return null;
    }
}