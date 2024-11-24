package miladi.yassine.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import miladi.yassine.dashboard.model.Match;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MatchRepository extends CrudRepository<Match, Long> {

    List<Match> getByTeam1OrTeam2(String teamName1, String teamName2);
}
