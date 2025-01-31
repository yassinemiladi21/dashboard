import {React} from 'react';

export const MatchSmallCard = ({teamName, match}) => {
    if(!match) return null;
    const otherTeam = match.homeTeam === teamName ? match.awayTeam : match.homeTeam;

    return (
    <div className="MatchSmallCard">
        <h3>VS {otherTeam}</h3>
    </div>
    );
}