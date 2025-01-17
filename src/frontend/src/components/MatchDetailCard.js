import {React} from 'react';

export const MatchDetailCard = ({match}) => {
    if(!match) return <p>wait</p>;

    return (
    <div className="MatchDetailCard">
        <h3>{match.team1} VS {match.team2}</h3>
    </div>
    );
}