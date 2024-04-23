package gym.model;

import java.time.LocalDate;

/**
 *
 * @author ruanemanuell
 */

public class PessoaDAO {
    private Pessoa[] pessoas;
    private int tamanho;

    public PessoaDAO() {
        this.pessoas = new Pessoa[10]; 
        this.tamanho = 0;
    }

    public void adicionarPessoa(Pessoa pessoa) {
        if (tamanho == pessoas.length) {
            aumentarCapacidade();
        }
        int id = tamanho + 1;
        pessoa.setId(id);
        LocalDate dataAtual = LocalDate.now();
        pessoa.setDataCriacao(dataAtual);
        pessoa.setDataModificacao(dataAtual);
        pessoas[tamanho++] = pessoa;
    }

    private void aumentarCapacidade() {
        int novaCapacidade = pessoas.length * 2;
        Pessoa[] novoArray = new Pessoa[novaCapacidade];
        System.arraycopy(pessoas, 0, novoArray, 0, tamanho);
        pessoas = novoArray;
    }

    public void alterarPessoa(int id, String login, String senha, String tipoUsuario) {
        for (int i = 0; i < tamanho; i++) {
            if (pessoas[i].getId() == id) {
                pessoas[i].setLogin(login);
                pessoas[i].setSenha(senha);
                pessoas[i].setTipoUsuario(tipoUsuario);
                pessoas[i].setDataModificacao(LocalDate.now());
                break;
            }
        }
    }

    public Pessoa buscarPessoa(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (pessoas[i].getId() == id) {
                return pessoas[i];
            }
        }
        return null;
    }

    public void removerPessoa(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (pessoas[i].getId() == id) {
                for (int j = i; j < tamanho - 1; j++) {
                    pessoas[j] = pessoas[j + 1];
                }
                tamanho--;
                break;
            }
        }

        for (int i = 0; i < tamanho; i++) {
            pessoas[i].setId(i + 1);
        }
    }

    public Pessoa[] mostrarPessoas() {
        Pessoa[] pessoasExistentes = new Pessoa[tamanho];
        System.arraycopy(pessoas, 0, pessoasExistentes, 0, tamanho);
        return pessoasExistentes;
    }
}
