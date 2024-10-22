// App.js
// import React from 'react';
// import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
// import Header from './layout/header/header';
// import routes from "./routes";
// import Container from '@mui/material/Container';

import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import { AppBar, Toolbar, Typography, Drawer, List, ListItem, ListItemText, CssBaseline } from '@mui/material';
import Competencia from "./competencia";
import './App.css';

const drawerWidth = 240;


function App() { 

  return (
    // <Container>
    //   <Router>
    //     <Header />
    //     <Routes>
    //       <Route path="/" element={<Navigate to="/competencia" />} />
    //       {routes.map((route) => (
    //         <Route path={route.route} element={route.component} key={route.key} />
    //       ))}
    //     </Routes>
    //   </Router>
    // </Container>
      <Router>
      <div style={{ display: 'flex' }}>
        <CssBaseline />
        
        <AppBar position="fixed" sx={{ zIndex: (theme) => theme.zIndex.drawer + 1 }}>
          <Toolbar>
            <Typography variant="h6" noWrap>
              My Application
            </Typography>
          </Toolbar>
        </AppBar>
        
        <Drawer
          variant="permanent"
          sx={{
            width: drawerWidth,
            flexShrink: 0,
            [`& .MuiDrawer-paper`]: { width: drawerWidth, boxSizing: 'border-box' },
          }}
        >
          <Toolbar />
          <List>
            <ListItem button component={Link} to="/">
              <ListItemText primary="Competencia" />
            </ListItem>
            <ListItem button component={Link} to="/competencia">
              <ListItemText primary="Competencia" />
            </ListItem>
          </List>
        </Drawer>

        <main style={{ flexGrow: 1, padding: '20px', marginLeft: `${drawerWidth}px` }}>
          <Toolbar />
          <Routes>
            <Route path="/" element={<Competencia />} />
          </Routes>
        </main>
      </div>
    </Router>

    
  );
}

export default App;
