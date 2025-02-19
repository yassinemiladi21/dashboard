import React from 'react'
import { Link } from 'react-router-dom'

export const TeamCard = ({teamName, logoPath}) => {
    const teamPath = `/teams/${teamName}`;
  return (
    <div className="TeamCard" style={{display: "flex", alignItems:"center", justifyContent:"center"}}>
      <h1>test</h1>
        <div style={{width:"180px", height:"180px", padding:"10px", background:"#03f1fe", display:"flex", justifyContent:"center",alignItems:"center"}}><img style={{width:"100%"}} src={logoPath} alt="Logo"/></div>
        <h1 style={{width:"350px", height:"180px", padding:"10px 20px", background:"#38003d", display:"flex", justifyContent:"center",alignItems:"center", fontSize:"50px"}}><Link style={{color: "#03f1fe", textDecoration:"none"}} to={teamPath}>{teamName}</Link></h1>
    </div>
  )
}
