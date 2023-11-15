package Memento;

import Given.*;

public class TeamMemento extends Memento {

    private Team team;
    private String tName;

    public TeamMemento(Team team) {
        this.team = team;
        tName = team.getName();
    }

    public void restore() {
        team.setName(tName);
    }

    public Team getTeam() {
        return team;
    }
}
