import {React} from 'react';
import { Link } from 'react-router-dom';

export const MatchDetailCard = ({teamName, match}) => {
    if(!match) return <p>wait</p>;
    const otherTeam = match.team1 === teamName ? match.team2 : match.team1;
    const otherTeamPath = "/teams/" + otherTeam;
    return (
    <div className="MatchDetailCard">
        <h3>VS <Link to={otherTeamPath}>{otherTeam}</Link></h3>
    </div>
    );
}