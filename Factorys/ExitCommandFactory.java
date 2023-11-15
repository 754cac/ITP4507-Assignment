package Factorys;

import Commands.Command;
import Commands.ExitCommand;

public class ExitCommandFactory implements CommandFactory {
    public Command createCommand() {
        return new ExitCommand();
    }
}
