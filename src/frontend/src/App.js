import './App.css';
import { TeamPage } from './pages/TeamPage';
import { MatchPage } from './pages/MatchPage';
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';


function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path='/' element={<div><h1>Welcome to home page</h1><h4>Still under development ..</h4></div>}></Route>
          <Route path="/teams/:teamName" element={<TeamPage />}></Route>
          <Route path="/matches/:teamName/:year" element={<MatchPage />}></Route>
          </Routes>
      </Router>
    </div>
  );
}

export default App;
