package gym.model;

import java.time.LocalDate;

public class PagamentoRecorrente {

    private int id;
    private int idPessoa;
    private int idMensalidadeAluno;
    private LocalDate data;
    private String cartaoDeCredito;
    private Double valor;
    private LocalDate dataDeInicio;
    private int numeroDeMeses;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public PagamentoRecorrente(int id, int idPessoa, int idMensalidadeAluno, LocalDate data, String cartaoDeCredito, Double valor, LocalDate dataDeInicio, int numeroDeMeses, LocalDate dataCriacao, LocalDate dataModificacao) {
        this.id = id;
        this.idPessoa = idPessoa;
        this.idMensalidadeAluno= idMensalidadeAluno;
        this.data = data;
        this.cartaoDeCredito = cartaoDeCredito;
        this.valor = valor;
        this.dataDeInicio = dataDeInicio;
        this.numeroDeMeses = numeroDeMeses;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getCartaoDeCredito() {
        return cartaoDeCredito;
    }

    public void setCartaoDeCredito(String cartaoDeCredito) {
        this.cartaoDeCredito = cartaoDeCredito;
    }

    public LocalDate getDataDeInicio() {
        return dataDeInicio;
    }

    public void setDataDeInicio(LocalDate dataDeInicio) {
        this.dataDeInicio = dataDeInicio;
    }

    public int getNumeroDeMeses() {
        return numeroDeMeses;
    }

    public void setNumeroDeMeses(int numeroDeMeses) {
        this.numeroDeMeses = numeroDeMeses;
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

    public Double getValor() {
        return valor;
    }

    public Double setValor(Double valor) {
        return this.valor = valor;
    }

    public int getIdMensalidadeAluno() {
        return idMensalidadeAluno;
    }

    public void setIdMensalidadeAluno(int idMensalidadeAluno) {
        this.idMensalidadeAluno = idMensalidadeAluno;
    }

}
