import {React, useEffect, useState} from 'react';
import { useParams } from 'react-router-dom';
import {MatchDetailCard} from '../components/MatchDetailCard';
import {MatchSmallCard} from '../components/MatchSmallCard';

export const TeamPage = () => {

    const apiUrl = process.env.REACT_APP_API_URL;

    const [team, setTeam] = useState({matches: []});
    const { teamName } = useParams();

    useEffect(
        () => {
            const fetchMatches = async() => {
                const response = await fetch(`${apiUrl}/team/${teamName}`);
                const data = await response.json();
                setTeam(data);
            };
            fetchMatches();
        }, [teamName, apiUrl]
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
        <div style={{display:'flex',gap:'20px'}}>
        <MatchDetailCard teamName={team.teamName} match={team.matches[0]}/></div>
        <h2>Latest Matches</h2>
        <div style={{display:'flex',gap:'20px',justifyContent: "center"}}>
        {team.matches.slice(1).map(match => <MatchSmallCard teamName={team.teamName} match={match}/>)}

        </div>
    </div>
    );
}