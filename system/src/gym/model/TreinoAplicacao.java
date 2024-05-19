package gym.model;

import java.time.LocalDate;

public class TreinoAplicacao {
    private int id;
    private int usuarioId;
    private Treino treino;
    private Exercicio exercicio;
    private ExercicioAplicacao exercicioAplicacao;
    private DivisaoTreino divisaoTreino;
    private DivisaoTreinoMusculo divisaoTreinoMusculo;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    
    public TreinoAplicacao(int id, int usuarioId, Treino treino, Exercicio exercicio, ExercicioAplicacao exercicioAplicacao, DivisaoTreino divisaoTreino, DivisaoTreinoMusculo divisaoTreinoMusculo, LocalDate dataCriacao, LocalDate dataModificacao) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.treino = treino;
        this.exercicio = exercicio;
        this.exercicioAplicacao = exercicioAplicacao;
        this.divisaoTreino = divisaoTreino;
        this.divisaoTreinoMusculo = divisaoTreinoMusculo;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public ExercicioAplicacao getExercicioAplicacao() {
        return exercicioAplicacao;
    }

    public void setExercicioAplicacao(ExercicioAplicacao exercicioAplicacao) {
        this.exercicioAplicacao = exercicioAplicacao;
    }

    public DivisaoTreino getDivisaoTreino() {
        return divisaoTreino;
    }

    public void setDivisaoTreino(DivisaoTreino divisaoTreino) {
        this.divisaoTreino = divisaoTreino;
    }

    public DivisaoTreinoMusculo getDivisaoTreinoMusculo() {
        return divisaoTreinoMusculo;
    }

    public void setDivisaoTreinoMusculo(DivisaoTreinoMusculo divisaoTreinoMusculo) {
        this.divisaoTreinoMusculo = divisaoTreinoMusculo;
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
