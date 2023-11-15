package Factorys;

import Given.*;

public class VolleyballTeamFactory implements TeamFactory {
    public Team createTeam(String teamID) {
        Team team = new VolleyballTeam(teamID);
        return team;
    }
}
