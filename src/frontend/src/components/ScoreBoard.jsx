import React from 'react'
import { TeamLogo } from './TeamLogo';
import "./ScoreBoard.css"

export const ScoreBoard = ({teams, score}) => {

  const homeTeam = teams[0].slice(0,3).toUpperCase();
  const awayTeam = teams[1].slice(0,3).toUpperCase();
  const homeLogoPath = `/images/clubs/${teams[0]}.png`;
  const awayLogoPath = `/images/clubs/${teams[1]}.png`;
    return (
      <div className="ScoreBoard">
        <div className="homeTeam">
          <TeamLogo size="70px" path={homeLogoPath} />
          <span>{homeTeam}</span>
        </div>

        <div className="score">
          <span>{score[0]} - {score[1]}</span>
        </div>

        <div className="awayTeam">
          <span>{awayTeam}</span>
          <TeamLogo size="70px" path={awayLogoPath} />
        </div>
      </div>
    )
  }

