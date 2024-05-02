package gym.model;

import java.time.LocalDate;

public class ExercicioAplicacao {
    private int id;
    private int idExercicio;
    private String descricao;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public ExercicioAplicacao(int id, int idExercicio, String descricao, LocalDate dataCriacao, LocalDate dataModificacao) {
        this.id = id;
        this.idExercicio = idExercicio;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdExercicio() {
        return idExercicio;
    }

    public void setIdExercicio(int idExercicio) {
        this.idExercicio = idExercicio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
