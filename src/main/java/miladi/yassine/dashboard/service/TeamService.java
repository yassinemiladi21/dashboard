package miladi.yassine.dashboard.service;

import miladi.yassine.dashboard.model.Team;
import miladi.yassine.dashboard.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team findByName(String teamName) {
        return teamRepository.findByTeamName(teamName);
    }
}