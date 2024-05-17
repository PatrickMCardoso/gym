package gym.model;

import java.time.LocalDate;

public class AvaliacaoFisica {
    private int id;
    private Pessoa pessoa;
    private Treino ultimoTreino;
    private double peso;
    private double altura;
    private double imc;
    private int indiceSatisfacao;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;    

    public AvaliacaoFisica(int id, Pessoa pessoa, Treino ultimoTreino, double peso, double altura, int indiceSatisfacao) {
        this.id = id;
        this.pessoa = pessoa;
        this.ultimoTreino = ultimoTreino;
        this.peso = peso;
        this.altura = altura;
        this.imc = calcularIMC(peso, altura);
        this.indiceSatisfacao = indiceSatisfacao;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    private double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Treino getUltimoTreino() {
        return ultimoTreino;
    }

    public void setUltimoTreino(Treino ultimoTreino) {
        this.ultimoTreino = ultimoTreino;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public int getIndiceSatisfacao() {
        return indiceSatisfacao;
    }

    public void setIndiceSatisfacao(int indiceSatisfacao) {
        this.indiceSatisfacao = indiceSatisfacao;
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
