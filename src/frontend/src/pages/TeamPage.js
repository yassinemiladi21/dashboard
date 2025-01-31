import {React, useEffect, useState} from 'react';
import { useParams } from 'react-router-dom';
import {MatchDetailCard} from '../components/MatchDetailCard';
import {MatchSmallCard} from '../components/MatchSmallCard';

export const TeamPage = () => {

    const [team, setTeam] = useState({matches: []});
    const { teamName } = useParams();

    useEffect(
        () => {
            const fetchMatches = async() => {
                const response = await fetch(`http://localhost:8080/team/${teamName}`);
                const data = await response.json();
                setTeam(data);
            };
            fetchMatches();
        }, [teamName]
    );

    if (!team || !team.teamName) {
        return <h1 style={{color: "red"}}>Team not found!</h1>
    }

    const logoPath = `/images/clubs/${team.teamName}.png`;
    
    return (
    <div className="TeamPage">
        <div style={{display: "flex", alignitems:"right"}}>
            <div style={{width:"100px"}}><img style={{width:"100%"}} src={logoPath} alt="Logo"/></div>
            <h1>{team.teamName}</h1>
        </div>
        <MatchDetailCard teamName={team.teamName} match={team.matches[0]}/>
        <h2>Latest Matches</h2>
        <div style={{display:'flex',gap:'20px'}}>
        {team.matches.slice(1).map(match => <MatchSmallCard teamName={team.teamName} match={match}/>)}

        </div>
    </div>
    );
}