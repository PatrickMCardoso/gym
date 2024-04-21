/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ruanemanuell
 */

public class PessoaDAO {
    private List<Pessoa> pessoas;

    public PessoaDAO() {
        this.pessoas = new ArrayList<>();
    }

    public void adicionarPessoa(Pessoa pessoa){
        int id = pessoas.size() + 1;
        pessoa.setId(id);
        LocalDate dataAtual = LocalDate.now();
        pessoa.setDataCriacao(dataAtual);
        pessoa.setDataModificacao(dataAtual);
        pessoas.add(pessoa);
    }

    public List<Pessoa> mostrarPessoas() {
        return new ArrayList<>(pessoas);
    }
}
