package miladi.yassine.dashboard.repository;

import org.springframework.data.repository.CrudRepository;

import miladi.yassine.dashboard.model.Team;

public interface TeamRepository extends CrudRepository <Team, Long> {
    
    Team findByTeamName (String teamName);
}
