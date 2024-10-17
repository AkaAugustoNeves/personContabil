// App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import Header from './layout/header/header';
import routes from "./routes";
import Container from '@mui/material/Container';

function App() { 

  return (
    <Container>
      <Router>
        <Header />
        <Routes>
          <Route path="/" element={<Navigate to="/competencia" />} />
          {routes.map((route) => (
            <Route path={route.route} element={route.component} key={route.key} />
          ))}
        </Routes>
      </Router>
    </Container>
  );
}

export default App;
