package Factorys;

import Given.Player;

public class PlayerFactory {
    private String id, name;

    public PlayerFactory(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Player createPlayer() {
        Player p = new Player(id, name);
        return p;
    }
}
