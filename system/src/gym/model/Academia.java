/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym.model;
import java.time.LocalDate;

/**
 *
 * @author ruanemanuell
 */
public class Academia {
    private int id;
    private String nome;
    private String endereço;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    ///////////////////////////////////////////////////////////
    public Academia(int id, String nome, String endereço, LocalDate dataCriacao, LocalDate dataModificacao) {
        this.id = id;
        this.nome = nome;
        this.endereço = endereço;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }
    /////////////////////////////////////////////////////////////
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
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
