package miladi.yassine.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import miladi.yassine.dashboard.model.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
