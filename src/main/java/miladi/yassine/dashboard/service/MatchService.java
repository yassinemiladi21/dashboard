package miladi.yassine.dashboard.service;

import miladi.yassine.dashboard.model.Match;
import miladi.yassine.dashboard.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public List<Match> getLastMatches(String teamName) {
        return matchRepository.getByTeam1OrTeam2(teamName,teamName);
    }
}
