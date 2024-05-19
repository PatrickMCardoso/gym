package gym.model;

import java.time.LocalDate;
import java.util.Arrays;

public class DivisaoTreinoMusculo {
    private int id;    
    private DivisaoTreino divisaoTreino;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    private String[] tiposExercicios;
    private String[] musculos;
    private int alunoId;
    

    public DivisaoTreinoMusculo(int id, DivisaoTreino divisaoTreino, LocalDate dataCriacao, LocalDate dataModificacao, String[] tiposExercicios) {
        this.id = id;        
        this.divisaoTreino = divisaoTreino;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
        this.tiposExercicios = tiposExercicios;
    }

    public int getAlunoId() {
        return alunoId;
    }
    
    public String[] getMusculo() {
        return musculos;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DivisaoTreino getDivisaoTreino() {
        return divisaoTreino;
    }

    public void setDivisaoTreino(DivisaoTreino divisaoTreino) {
        this.divisaoTreino = divisaoTreino;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public String[] getTiposExercicios() {
        return tiposExercicios;
    }

    public void setTiposExercicios(String[] tiposExercicios) {
        this.tiposExercicios = tiposExercicios;
    }
}
