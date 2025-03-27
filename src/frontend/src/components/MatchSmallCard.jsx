import {React} from 'react';
import { Link } from 'react-router-dom';
import './MatchSmallCard.css'

export const MatchSmallCard = ({teamName, match}) => {
    if(!match) return null;
    const otherTeam = match.homeTeam === teamName ? match.awayTeam : match.homeTeam;
    const otherTeamPath = "/teams/" + otherTeam;
    const logoPath = `/images/clubs/${otherTeam}.png`;
    let result = "LOSS";
    if (match.winner == null) result = "DRAW";
    else if (match.winner == teamName) result = "WIN";




    return (
    <div className="MatchSmallCard">
        <img src={logoPath} alt={otherTeam} onError={(e) => e.target.src = "/images/clubs/noImage.png"}/>
          <div class="match-date">{match.date} • Premier League</div>
          <div class="match-score">{match.homeGoals}-{match.awayGoals}</div>
          <div class="match-venue">Anfield</div>
          <div class="match-status">{result}</div>
    </div>
    );
}