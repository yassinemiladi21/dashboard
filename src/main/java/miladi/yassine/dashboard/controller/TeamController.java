package miladi.yassine.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import miladi.yassine.dashboard.model.Team;
import miladi.yassine.dashboard.repository.TeamRepository;


@RestController
public class TeamController {

    @Autowired
    TeamRepository teamRepository;

    @GetMapping("/team/{teamName}")
    public Team getTeam (@PathVariable String teamName) {
        return teamRepository.findByTeamName(teamName);
    }
}
