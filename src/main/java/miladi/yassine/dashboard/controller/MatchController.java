package miladi.yassine.dashboard.controller;

import miladi.yassine.dashboard.model.Match;
import miladi.yassine.dashboard.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping("/matches")
    public List<Match> getMatches () {
        return matchService.getAllMatches();
    }

    @GetMapping("/matches/{teamName}")
    public List<Match> getMatchesByTeamAndSeason(@PathVariable String teamName, @RequestParam int year) {
        return matchService.getMatchesByTeamAndSeason(teamName,year);
    }
}
