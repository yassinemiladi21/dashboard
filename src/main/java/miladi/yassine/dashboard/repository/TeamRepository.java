package miladi.yassine.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import miladi.yassine.dashboard.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findByTeamName (String teamName);
}