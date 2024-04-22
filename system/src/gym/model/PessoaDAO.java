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

    public void alterarPessoa(int id, String login, String senha, String tipoUsuario) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId() == id) {
                pessoa.setLogin(login);
                pessoa.setSenha(senha);
                pessoa.setTipoUsuario(tipoUsuario);
                pessoa.setDataModificacao(LocalDate.now());
                break; 
            }
        }
    }
    
    public Pessoa buscarPessoa(int id) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null; 
    }
    
    public void removerPessoa(int id) {
        pessoas.removeIf(pessoa -> pessoa.getId() == id);
        
        for (int i = 0; i < pessoas.size(); i++) {
            pessoas.get(i).setId(i + 1);
        }
    }
    
    public List<Pessoa> mostrarPessoas() {
        return pessoas;
    }
}
