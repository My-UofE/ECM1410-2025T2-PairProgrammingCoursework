package gamesleague;

import java.util.ArrayList;
import java.util.List;

public class LeagueManager {
    private List<League> league = new ArrayList<>();

    public League createLeague(String name, String owner, String gameType) {
        League league = new League();
        league.createLeague(name, owner, gameType);
        this.league.add(league);
        return league;
    }
}
