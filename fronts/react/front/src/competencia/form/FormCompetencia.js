import React from 'react';
import { Box, TextField, FormControl, FormLabel, RadioGroup, FormControlLabel, Radio, Button } from '@mui/material';

function FormCompetencia() {
    return (
      <Box
        component="form"
        sx={{
          display: 'flex', // Define o layout flexível
          flexDirection: 'row', // Alinha os itens em linha
          gap: 2, // Define o espaçamento entre os itens
          alignItems: 'center', // Alinha os itens ao centro verticalmente
          flexWrap: 'wrap', // Para garantir que os itens se ajustem em telas menores
          padding: 2, // Adiciona espaçamento interno ao redor do formulário
        }}
      >
        {/* Campo de Texto 1 */}
        <TextField
          label="Descrição"
          variant="outlined"
          size="small"
        />
  
        {/* Campo de Texto 2 */}
        <TextField
          label="Valor"
          variant="outlined"
          size="small"
        />
  
        {/* Campo de Rádio */}
        <FormControl component="fieldset">
          <FormLabel component="legend">Escolha uma opção</FormLabel>
          <RadioGroup row aria-label="tipo" name="tipo" defaultValue="ENTRADA">
            <FormControlLabel value="ENTRADA" control={<Radio />} label="Entrada" />
            <FormControlLabel value="SAIDA" control={<Radio />} label="Saída" />
          </RadioGroup>
        </FormControl>
  
        {/* Botão de Submissão */}
        <Button variant="contained" color="primary">Enviar</Button>
      </Box>
    );
  }
  
  export default FormCompetencia;