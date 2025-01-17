import {React} from 'react';

export const MatchSmallCard = ({match}) => {
    if(!match) return null;
    
    return (
    <div className="MatchSmallCard">
        <h3>{match.team1} VS {match.team2}</h3>
    </div>
    );
}