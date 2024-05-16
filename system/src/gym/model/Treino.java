package gym.model;

import java.time.LocalDate;

public class Treino {
    private int id;
    private String objetivo;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private DivisaoTreino divisaoTreino;
    private Pessoa pessoa;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Treino(int id, Pessoa pessoa, String objetivo, LocalDate dataInicio, LocalDate dataTermino, DivisaoTreino divisaoTreino, LocalDate dataCriacao, LocalDate dataModificacao) {
        this.id = id;
        this.pessoa = pessoa;
        this.objetivo = objetivo;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
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
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
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
    
    public int getIdAluno() {
        return pessoa.getId();
    }

    public String getNomeAluno() {
        return pessoa.getNome();
    }

    public String getTipoUsuarioAluno() {
        return pessoa.getTipoUsuario();
    }

    public int getIdDivisaoTreino() {
        return divisaoTreino.getId();
    }

    public String getNomeDivisaoTreino() {
        return divisaoTreino.getNome();
    }
}