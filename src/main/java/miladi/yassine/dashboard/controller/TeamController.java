package miladi.yassine.dashboard.controller;

import miladi.yassine.dashboard.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import miladi.yassine.dashboard.model.Team;


@RestController
public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping("/team/{teamName}")
    public Team getTeam (@PathVariable String teamName) {
        return teamService.findByName(teamName);
    }
}
