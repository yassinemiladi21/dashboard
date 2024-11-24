package miladi.yassine.dashboard.service;

import miladi.yassine.dashboard.model.Match;
import miladi.yassine.dashboard.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public List<Match> getLastMatches(String teamName, int size ) {
        Pageable pageable = PageRequest.of(0,size);
        return matchRepository.getByTeam1OrTeam2OrderByDateDesc(teamName,teamName,pageable);
    }
}
