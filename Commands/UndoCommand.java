package Commands;

import java.util.*;

public class UndoCommand implements Command {
    private Stack<Command> undos;
    private Stack<Command> redos;
    private Command com;

    public UndoCommand(Stack<Command> undos, Stack<Command> redos) {
        this.undos = undos;
        this.redos = redos;
    }

    public void execute() {
        if (undos.size() != 0) {
            com = (Command) undos.pop();
            System.out.println("Command (" + com.toString() + ") is undone.");
            com.undo();
            redos.push(com);
        } else {
            System.out.println("Nothing to undo!");
        }
    }

    public void undo() {
    }

    public void redo() {
    }

}
