package Memento;

import Given.*;

public class PlayerMemento extends Memento {

    private Player player;
    private int position;

    public PlayerMemento(Player player) {
        this.player = player;
        this.position = player.getPosition();
    }

    public void restore() {
        player.setPosition(position);
    }

    public Player getPlayer() {
        return player;
    }

}
