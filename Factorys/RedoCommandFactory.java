package Factorys;

import Commands.*;

import java.util.*;

public class RedoCommandFactory implements CommandFactory {
    private Stack<Command> undos;
    private Stack<Command> redos;

    public RedoCommandFactory(Stack<Command> undos, Stack<Command> redos) {
        this.undos = undos;
        this.redos = redos;
    }

    public Command createCommand() {
        Command com = new RedoCommand(undos, redos);
        return com;
    }
}
