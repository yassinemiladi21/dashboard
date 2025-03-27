import React from 'react'

export const StatCard = ({kpi, value, tone}) => {
  return (
    <div className="StatCard">
        <h3>{kpi}</h3>
        <div class="stat-value">{value}</div>
        <div class={`stat-diff ${tone}`}>+2 from last week</div>
    </div>
)
}
