package gym.model;

import java.time.LocalDate;

public class Mensalidade {

    private int id;
    private String descricao;
    private Double valor;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private int termino;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Mensalidade(int id, String descricao, Double valor, LocalDate dataInicio, LocalDate dataFim, int termino, LocalDate dataCriacao, LocalDate dataModificacao) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.termino = termino;
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

    public void setId(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
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

    public int getTermino() {
        return termino;
    }

    public void setTermino(int termino) {
        this.termino = termino;
    }
}
