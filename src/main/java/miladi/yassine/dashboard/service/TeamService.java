package miladi.yassine.dashboard.service;

import miladi.yassine.dashboard.model.Team;
import miladi.yassine.dashboard.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    public Team findByName(String teamName) {
        return teamRepository.findByTeamName(teamName);
    }
}
