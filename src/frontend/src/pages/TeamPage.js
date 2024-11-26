import {React} from 'react';
import {MatchDetailCard} from '../components/MatchDetailCard';
import {MatchSmallCard} from '../components/MatchSmallCard';
export const TeamPage = () => {
    return (
    <div className="TeamPage">
        <h1>Team Name</h1>
        <h2>Latest Matches</h2>
        <MatchDetailCard/>
        <div style={{display:'flex',gap:'20px'}}>
            <MatchSmallCard/>
            <MatchSmallCard/>
            <MatchSmallCard/>
        </div>
    </div>
    );
}