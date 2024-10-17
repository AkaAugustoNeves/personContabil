import React from "react";
import { Select, MenuItem, FormControl, InputLabel, Box } from '@mui/material';
import meses from "./Meses";

class Competencia extends React.Component{
    
    constructor(props){
        super(props)
        this.state = {
            competencia: {
                mesSelecionado: ``,
                anoSelecionado: ``
            },
            anos: []
        }
    }

    componentDidMount(){
        this.setCompetenciaAtual()
        this.getAnos();
    }

    getAnos = async () => {
        try {
            const response = await fetch('http://localhost:8080/competencia/anos');
            if (!response.ok) {
                throw new Error('Erro ao buscar anos');
            }
            const data = await response.json();
            console.log("getAnos: ", data)
            this.setState({ anos: data }); // Atualiza o estado com os anos recebidos
        } catch (error) {
            console.error('Erro ao buscar anos:', error);
        }
    };

    render(){
        const { mesSelecionado, anoSelecionado } = this.state.competencia;
        return (
            <Box component="form" sx={{ display: 'flex', flexDirection: 'column', gap: 2 }}>
                <FormControl fullWidth variant="outlined">
                    <InputLabel id="select-mes-label">Selecione o Mês</InputLabel>
                    <Select
                        labelId="select-mes-label"
                        value={mesSelecionado}
                        onChange={this.handleChangeMes}
                        label="Selecione o Mês"
                    >
                        {meses.map(mes => (
                            <MenuItem key={mes.numero} value={mes.numero}>
                                {mes.nome}
                            </MenuItem>
                        ))}
                    </Select>
                </FormControl>

                <FormControl fullWidth variant="outlined">
                    <InputLabel id="select-ano-label">Selecione o Ano</InputLabel>
                    <Select
                        labelId="select-ano-label"
                        value={anoSelecionado}
                        onChange={this.handleChangeAno}
                        label="Selecione o Ano"
                    >
                        {this.state.anos.map(ano => (
                            <MenuItem key={ano} value={ano}>
                                {ano}
                            </MenuItem>
                        ))}
                    </Select>
                </FormControl>
            </Box>
        );
    }

    setCompetenciaAtual() {
        const dataAtual = new Date();
        this.updateCompetencia('mesSelecionado', dataAtual.getMonth() + 1);
        this.updateCompetencia('anoSelecionado', dataAtual.getFullYear());
    }

    updateCompetencia(field, value) {
        this.setState(prevState => ({
            competencia: {
                ...prevState.competencia,
                [field]: value
            }
        }));
    }

    handleChangeMes = (event) => {
        this.updateCompetencia('mesSelecionado', event.target.value);
    };

    handleChangeAno = (event) => {
        this.updateCompetencia('anoSelecionado', event.target.value);
    };

}
export default Competencia;