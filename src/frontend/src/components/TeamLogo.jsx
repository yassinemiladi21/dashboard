import React from 'react'
import './TeamLogo.css'

export const TeamLogo = ({size, path}) => {
  return (
    <div className="TeamLogo" style={{width: size, height: size, padding:"0"}}>
        <img style={{width:"100%"}} src={path} alt="Logo" onError={(e) => e.target.src = "/images/clubs/noImage.png"}/>
    </div>
 )
}
