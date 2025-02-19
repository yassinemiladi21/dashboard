import React, { Component } from 'react'
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

      // <div>
      //   <div style={{display: "flex", alignItems:"center", justifyContent:"center"}}>
      //     <h2 style={{width:"130px", height:"60px", padding:"10px 20px 10px 0", background:"#03f1fe", color: "#38003d", display:"flex", justifyContent:"start",alignItems:"center"}}>
      //       <TeamLogo size="70px" path={homeLogoPath} />
      //     {homeTeam}</h2>
      //     <h1 style={{width:"130px", height:"60px", padding:"10px 0", background:"#38003d", color: "#03f1fe", display:"flex", justifyContent:"center",alignItems:"center"}}>{score[0]} - {score[1]}</h1>
      //     <h2 style={{width:"130px", height:"60px", padding:"10px 0 10px 20px", background:"#03f1fe", color: "#38003d", display:"flex", justifyContent:"end",alignItems:"center"}}>
      //       {awayTeam}
      //       <TeamLogo size="70px" path={awayLogoPath} /></h2>
      //   </div>
      // </div>
    )
  }

