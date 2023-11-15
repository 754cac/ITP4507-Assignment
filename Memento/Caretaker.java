package Memento;

import java.util.Stack;
import Given.*;

public class Caretaker {
    private Stack<Memento> undoList;
    private Memento m;

    public Caretaker() {
        undoList = new Stack<Memento>();
    }

    public void saveMyTeam(Team mc) {
        m = new TeamMemento(mc);
        undoList.push(m);
    }

    public void savePlayer(Player player) {
        m = new PlayerMemento(player);
        undoList.push(m);
    }

    public void undo() {
        Memento m = (Memento) undoList.pop();
        m.restore();
    }
}
