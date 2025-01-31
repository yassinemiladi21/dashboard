package miladi.yassine.dashboard.data;


import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import miladi.yassine.dashboard.model.Match;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

  private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

  @Override
  public Match process(final MatchInput matchInput) throws Exception {

    Match match = new Match();

    match.setSeason(matchInput.getSeason());
    match.setDate(matchInput.getDateTime().substring(0,10));
    match.setTime(matchInput.getDateTime().substring(11,16));
    match.setHomeTeam(matchInput.getHomeTeam());
    match.setAwayTeam(matchInput.getAwayTeam());
    match.setHomeGoals(matchInput.getFTHG());
    match.setAwayGoals(matchInput.getFTAG());
    match.setResult(matchInput.getFTR());

    int homeGoals = Integer.parseInt(matchInput.getFTHG());
    int awayGoals = Integer.parseInt(matchInput.getFTAG());

    if (homeGoals > awayGoals) {
      match.setWinner(match.getHomeTeam());
    }
    else if (homeGoals < awayGoals) {
      match.setWinner(match.getAwayTeam());
    }

    match.setReferee(matchInput.getReferee());
    match.setHomeShots(matchInput.getHS());
    match.setAwayShots(matchInput.getAS());
    match.setHomeShotsOnTarget(matchInput.getHST());
    match.setAwayShotsOnTarget(matchInput.getAST());
    match.setHomeCorners(matchInput.getHC());
    match.setAwayCorners(matchInput.getAC());
    match.setHomeFouls(matchInput.getHF());
    match.setAwayFouls(matchInput.getAF());
    match.setHomeYellowCards(matchInput.getHY());
    match.setAwayYellowCards(matchInput.getAY());
    match.setHomeRedCards(matchInput.getHR());
    match.setAwayRedCards(matchInput.getAR());

    return match;
  }

}
