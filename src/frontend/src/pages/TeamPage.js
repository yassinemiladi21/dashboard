import {React, useEffect, useState} from 'react';
import { useParams } from 'react-router-dom';
import {MatchDetailCard} from '../components/MatchDetailCard';
import {MatchSmallCard} from '../components/MatchSmallCard';
import {TeamCard} from '../components/TeamCard';
import './TeamPage.css'

export const TeamPage = () => {

    const apiUrl = process.env.REACT_APP_API_URL;

    const [team, setTeam] = useState({matches: []});
    const { teamName } = useParams();
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
            fetch(`${apiUrl}/team/${teamName}`)
              .then(response => response.json())
              .then(data => {
                setTeam(data);
                setLoading(false);
              })
              .catch(error => {
                setError(error);
                setLoading(false);
              });
          }, [teamName, apiUrl]);
        
          if (loading) return <p>Loading...</p>;
          if (error) return <p>Error: {error.message}</p>;

    const logoPath = `/images/clubs/${team.teamName}.png`;
    
    return (
    <div className="TeamPage">
        <TeamCard teamName={teamName} logoPath={logoPath}/>
        <div style={{display:'flex',gap:'20px'}}>
        <MatchDetailCard teamName={team.teamName} match={team.matches[0]}/></div>
        <h2>Latest Matches</h2>
        <div style={{display:'flex',gap:'20px',justifyContent: "center"}}>
        {team.matches.slice(1).map(match => <MatchSmallCard teamName={team.teamName} match={match}/>)}

        </div>
    </div>
    );
}