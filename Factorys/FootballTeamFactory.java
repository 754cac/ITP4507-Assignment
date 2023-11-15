package Factorys;

import Given.*;

public class FootballTeamFactory implements TeamFactory {
    public Team createTeam(String teamID) {
        Team team = new FootballTeam(teamID);
        return team;
    }

}
