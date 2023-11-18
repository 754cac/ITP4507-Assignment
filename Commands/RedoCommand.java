package Commands;

import java.util.*;

public class RedoCommand implements Command {

    private Stack<Command> undos, redos;
    private Command com;

    public RedoCommand(Stack<Command> undos, Stack<Command> redos) {
        this.undos = undos;
        this.redos = redos;
    }

    public void execute() {
        if (redos.size() != 0) {
            com = (Command) redos.pop();
            System.out.println("Command (" + com.toString() + ") is redone.");
            com.redo();
            undos.push(com);
        } else {
            System.out.println("Nothing to redo!");
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
