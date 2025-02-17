import {React, useEffect, useState} from 'react';
import { useParams } from 'react-router-dom';
import { Link } from 'react-router-dom';


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
        <h1>This is matches page</h1>
        <br></br>
        {matches.map(match => {

            const homeTeamPath = "/teams/" + match.homeTeam;
            const awayTeamPath = "/teams/" + match.awayTeam;
            const homeLogoPath = `/images/clubs/${match.homeTeam}.png`;
            const awayLogoPath = `/images/clubs/${match.awayTeam}.png`;


            return(
                
            <div style={{display: "flex", flexDirection:"row", alignItems:"center", justifyContent:"center"}}>
                <div style={{display: "flex", alignItems:"center", justifyContent:"center"}}>
                    <div style={{width:"60px", height:"60px", padding:"10px", background:"#03f1fe", display:"flex", justifyContent:"center",alignItems:"center"}}><img style={{width:"100%"}} src={homeLogoPath} alt="Logo"/></div>
                    <h2 style={{width:"250px", height:"60px", padding:"10px 20px", background:"#38003d", display:"flex", justifyContent:"center",alignItems:"center"}}><Link style={{color: "#03f1fe", textDecoration:"none"}} to={homeTeamPath}>{match.homeTeam}</Link></h2>
                </div>
                <h2 style={{padding:"10px 20px", color:"#38003d"}}>VS</h2>
                <div style={{display: "flex", alignItems:"center", justifyContent:"center"}}>
                    <div style={{width:"60px", height:"60px", padding:"10px", background:"#03f1fe", display:"flex", justifyContent:"center",alignItems:"center"}}><img style={{width:"100%"}} src={awayLogoPath} alt="Logo"/></div>
                    <h2 style={{width:"250px", height:"60px", padding:"10px 20px", background:"#38003d", display:"flex", justifyContent:"center",alignItems:"center"}}><Link style={{color: "#03f1fe", textDecoration:"none"}} to={awayTeamPath}>{match.awayTeam}</Link></h2>
                </div>
                <br></br>
            </div>
        )}
        )}
    </div>
    );
}