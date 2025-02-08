import {React} from 'react';
import { Link } from 'react-router-dom';

export const MatchSmallCard = ({teamName, match}) => {
    if(!match) return null;
    const otherTeam = match.homeTeam === teamName ? match.awayTeam : match.homeTeam;
    const otherTeamPath = "/teams/" + otherTeam;
    const logoPath = `/images/clubs/${otherTeam}.png`;

    return (
    <div className="MatchSmallCard">
        VS
        <div style={{display: "flex", alignitems:"right"}}>
            <div style={{width:"50px"}}><img style={{width:"100%"}} src={logoPath} alt="Logo"/></div>
            <h3><Link to={otherTeamPath}>{otherTeam}</Link></h3>
        </div>
    </div>
    );
}