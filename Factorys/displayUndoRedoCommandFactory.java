package Factorys;

import java.util.Stack;

import Commands.Command;
import Commands.displayUndoRedoCommand;

public class displayUndoRedoCommandFactory implements CommandFactory {
    private Stack<Command> undos, redos;

    public displayUndoRedoCommandFactory(Stack<Command> undos, Stack<Command> redos) {
        this.undos = undos;
        this.redos = redos;
    }

    public Command createCommand() {
        Command com = new displayUndoRedoCommand(undos, redos);
        return com;
    }

}
