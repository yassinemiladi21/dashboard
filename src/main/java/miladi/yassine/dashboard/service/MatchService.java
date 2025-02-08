package miladi.yassine.dashboard.service;

import miladi.yassine.dashboard.model.Match;
import miladi.yassine.dashboard.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public List<Match> getLastMatches(String teamName, int size ) {
        Pageable pageable = PageRequest.of(0,size);
        return matchRepository.getByHomeTeamOrAwayTeamOrderByDateDesc(teamName,teamName,pageable);
    }



    public List<Match> getAllMatches() {
        List<Match> matches = new ArrayList<>();
        matchRepository.findAll().forEach(matches::add);
        return matches;
    }

    public List<Match> getMatchesByTeamAndSeason(String teamName, int year) {
        int nextYear = year + 1;
        String season = Integer.toString(year) + "-" + Integer.toString(nextYear).substring(2);
        return matchRepository.findByTeamAndSeason(teamName, teamName, season);
    }
}
