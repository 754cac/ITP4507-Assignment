package Commands;

import java.util.*;

import Given.*;

public class DeleteCommand implements Command {
    private Scanner sc;
    private Team[] currTeam;
    private Enumeration<Player> playeresEnumeration;
    private int index;
    private Player playerHolder;
    private String playerID;
    private HashMap<Integer, Player> playerHashMap;
    private Player player;
    private String toString;

    public DeleteCommand(Scanner sc, Team[] currTeam) {
        this.sc = sc;
        this.currTeam = currTeam;
    }

    public void execute() {
        System.out.print("Please input player ID:-");
        playerID = sc.nextLine();

        playeresEnumeration = currTeam[0].getAllPlayers();
        playerHashMap = new HashMap<Integer, Player>();

        index = 0; // Initialize index variable
        while (playeresEnumeration.hasMoreElements()) {
            player = playeresEnumeration.nextElement();
            playerHashMap.put(index++, player); // Use index as the key in the map
        }

        for (Iterator<Map.Entry<Integer, Player>> iterator = playerHashMap.entrySet().iterator(); iterator
                .hasNext();) {
            Map.Entry<Integer, Player> entry = iterator.next();
            playerHolder = entry.getValue();
            if (playerID.equals(playerHolder.getPlayerID())) {
                currTeam[0].remove(playerHolder);
                iterator.remove(); // Remove the player from the map
                System.out.println("Player is deleted.");
                toString = "Delete player, " + playerID;
                break; // Exit the loop after removing the player
            }
        }
    }

    public void undo() {
        if (playerHolder != null) {
            currTeam[0].addPlayer(playerHolder);
        }
    }

    public void redo() {
        if (playerHolder != null) {
            currTeam[0].remove(playerHolder);
        }
    }

    public String toString() {
        return toString;
    }
}
