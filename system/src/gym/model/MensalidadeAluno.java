package gym.model;

import java.time.LocalDate;

public class MensalidadeAluno {
    private int id;
    private int idAluno;
    private int idMensalidade;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public MensalidadeAluno(int id, int idAluno, int idMensalidade, LocalDate dataCriacao, LocalDate dataModificacao) {
        this.id = id;
        this.idAluno = idAluno;
        this.idMensalidade = idMensalidade;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdMensalidade() {
        return idMensalidade;
    }

    public void setIdMensalidade(int idMensalidade) {
        this.idMensalidade = idMensalidade;
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
