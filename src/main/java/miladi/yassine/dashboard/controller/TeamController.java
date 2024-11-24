package miladi.yassine.dashboard.controller;

import miladi.yassine.dashboard.service.MatchService;
import miladi.yassine.dashboard.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import miladi.yassine.dashboard.model.Team;


@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;
    @Autowired
    private MatchService matchService;

    @GetMapping("/team/{teamName}")
    public Team getTeam (@PathVariable String teamName) {
        Team team = teamService.findByName(teamName);
        team.setMatches(matchService.getLastMatches(teamName));
        return team;
    }
}
