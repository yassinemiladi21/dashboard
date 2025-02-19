import {React, useEffect, useState} from 'react';
import { useParams } from 'react-router-dom';
import { Link } from 'react-router-dom';
import { ScoreBoard } from '../components/ScoreBoard';


export const MatchPage = () => {

    const apiUrl = process.env.REACT_APP_API_URL;

    const [matches, setMatches] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const { teamName, year} = useParams();

   
    useEffect(() => {
        fetch(`${apiUrl}/matches/${teamName}?year=${year}`)
          .then(response => response.json())
          .then(data => {
            setMatches(data);
            setLoading(false);
          })
          .catch(error => {
            setError(error);
            setLoading(false);
          });
      }, [teamName, year, apiUrl]);
    
      if (loading) return <p>Loading...</p>;
      if (error) return <p>Error: {error.message}</p>;

    return (
    <div className="MatchPage">
        <h1>{teamName} Matches in {year}</h1>
        <br></br>
        {matches.map(match => {

            const teams = [match.homeTeam,match.awayTeam];
            const score = [match.homeGoals, match.awayGoals];


            return(
            <>
            <ScoreBoard teams={teams} score={score} /><br></br>
            </>

        )}
        )}
    </div>
    );
}