package gym.model;

import java.time.LocalDate;

public class EntradaAluno {
    private int id;
    private LocalDate data;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    
    public EntradaAluno(int id, LocalDate data, LocalDate dataCriacao, LocalDate dataModificacao) {
        this.id = id;
        this.data = data;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
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
