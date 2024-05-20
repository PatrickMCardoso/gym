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
    private int treinoAplicacaoId;
    

    public DivisaoTreinoMusculo(int id, int alunoId, DivisaoTreino divisaoTreino, LocalDate dataCriacao, LocalDate dataModificacao, String[] tiposExercicios) {
        this.id = id;        
        this.alunoId = alunoId;
        this.divisaoTreino = divisaoTreino;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
        this.tiposExercicios = tiposExercicios;
        this.treinoAplicacaoId = -1;
    }

    public int getAlunoId() {
        return alunoId;
    }
    
    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
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
    
    public int getTreinoAplicacaoId() {
        return treinoAplicacaoId;
    }

    public void setTreinoAplicacaoId(int treinoAplicacaoId) {
        this.treinoAplicacaoId = treinoAplicacaoId;
    }
}
