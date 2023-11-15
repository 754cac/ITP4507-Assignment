package Factorys;

import java.util.*;

import Commands.*;
import Given.*;

public class DisplayAllTeamCommandFactory implements CommandFactory {
    private Vector<Team> Teams;

    public DisplayAllTeamCommandFactory(Vector<Team> Teams) {
        this.Teams = Teams;
    }

    public Command createCommand() {
        Command com = new DisplayAllTeamCommand(Teams);
        // commands.push(com);
        return com;
    }
}