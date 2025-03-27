import {React, useEffect, useState} from 'react';
import { useParams } from 'react-router-dom';
import {MatchSmallCard} from '../components/MatchSmallCard';
import './TeamPage.css'
import { TeamHeader } from '../components/TeamHeader';
import { StatCard } from '../components/StatCard';

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
      <TeamHeader teamName={team.teamName} logoPath={logoPath}/>
      <div class="latest-matches">
        <h2 class="section-title">Recent Matches</h2>
        <div class="matches-container">
          <div className="matches-grid">
          {team.matches.map(match => <MatchSmallCard teamName={team.teamName} match={match}/>)}
          </div>
        </div>
      </div>
    
    <div className="stats-section">
    <h2 class="section-title">Season Statistics</h2>
    <div class="stats-grid">
        <StatCard kpi="League Position" value="4th" tone="positive" />
        <StatCard kpi="Points" value="16" tone="positive" />
        <StatCard kpi="Goals Scored" value="18" tone="positive" />
        <StatCard kpi="Goals Conceded" value="9" tone="negative" />
    </div>
    </div>
    </div>
    );
}