package miladi.yassine.dashboard.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import miladi.yassine.dashboard.model.Match;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> getByHomeTeamOrAwayTeamOrderByDateDesc(String homeTeam, String awayTeam, Pageable pageable);

    @Query("select m from Match m where (m.homeTeam = :homeTeam or m.awayTeam = :awayTeam) and m.season = :season order by m.date desc")
    List<Match> findByTeamAndSeason(@Param("homeTeam") String homeTeam, @Param("awayTeam") String awayTeam, @Param("season") String season);
}
