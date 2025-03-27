import React from 'react'
import './TeamHeader.css'
import { TeamLogo } from './TeamLogo'

export const TeamHeader = ({teamName, logoPath}) => {
  return (
<div className="TeamHeader">
      <img src={logoPath} alt="Team Logo" class="team-logo"/>
      <h1 class="team-name">{teamName}</h1>
      <div class="team-meta">
        <div class="team-meta-item">Founded: 1892</div>
        <div class="team-meta-item">Stadium: Anfield</div>
        <div class="team-meta-item">Manager: Jürgen Klopp</div>
      </div>
    </div>
      )
}
