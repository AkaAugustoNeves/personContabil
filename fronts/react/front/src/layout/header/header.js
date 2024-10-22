import React from 'react';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import { Box } from '@mui/material';

function Header() {
    return (
        <Toolbar>
            <Box sx={{ flexGrow: 1, display: 'flex', justifyContent: 'center' }}>
            <Typography variant="h6" component="div">
                Controle de Finanças
            </Typography>
            </Box>
        </Toolbar>
    );
}
export default Header;