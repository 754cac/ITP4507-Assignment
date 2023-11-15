package Factorys;

import java.util.*;
import Commands.*;

public class UndoCommandFactory implements CommandFactory {
    private Stack<Command> undos;
    private Stack<Command> redos;

    public UndoCommandFactory(Stack<Command> undos, Stack<Command> redos) {
        this.undos = undos;
        this.redos = redos;
    }

    public Command createCommand() {
        Command com = new UndoCommand(undos, redos);
        return com;
    }
}