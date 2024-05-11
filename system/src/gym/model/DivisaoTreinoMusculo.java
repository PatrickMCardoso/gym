package gym.model;

import java.time.LocalDate;

public class DivisaoTreinoMusculo {
    private int id;
    private String descricao;
    private String divisaoTreino;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public DivisaoTreinoMusculo(int id, String descricao, String divisaoTreino, LocalDate dataCriacao, LocalDate dataModificacao) {
        this.id = id;
        this.descricao = descricao;
        this.divisaoTreino = divisaoTreino;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDivisaoTreino() {
        return divisaoTreino;
    }

    public void setDivisaoTreino(String divisaoTreino) {
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
}
