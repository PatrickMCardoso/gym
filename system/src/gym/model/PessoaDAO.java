package gym.model;

import java.time.LocalDate;

public class PessoaDAO {

    private Pessoa[] pessoas;
    private int tamanho;

    public PessoaDAO() {
        this.pessoas = new Pessoa[10];
        this.tamanho = 0;
    }

    public void adicionarPessoasExemplo() {
        Pessoa pessoa1 = new Pessoa(1, "Eduardo", 'M', LocalDate.of(1990, 5, 15), "eduardoADMIN", "duardin", "Admin", LocalDate.now(), LocalDate.now());
        Pessoa pessoa2 = new Pessoa(2, "Patrick Machado Cardoso", 'M', LocalDate.of(2004, 4, 12), "patrickcardoso", "123123", "Aluno", LocalDate.now(), LocalDate.now());
        Pessoa pessoa3 = new Pessoa(3, "Ruan Emanuell", 'M', LocalDate.of(2004, 3, 10), "ruan789", "ruanzin", "Aluno", LocalDate.now(), LocalDate.now());
        Pessoa pessoa4 = new Pessoa(4, "Samuel Colombo", 'M', LocalDate.of(2005, 6, 27), "colombo", "samu", "Professor", LocalDate.now(), LocalDate.now());

        adicionarPessoa(pessoa1);
        adicionarPessoa(pessoa2);
        adicionarPessoa(pessoa3);
        adicionarPessoa(pessoa4);
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

    public void alterarPessoa(int id, Pessoa novaPessoa) {
        for (int i = 0; i < tamanho; i++) {
            if (pessoas[i].getId() == id) {
                pessoas[i].setNome(novaPessoa.getNome());
                pessoas[i].setSexo(novaPessoa.getSexo());
                pessoas[i].setNascimento(novaPessoa.getNascimento());
                pessoas[i].setLogin(novaPessoa.getLogin());
                pessoas[i].setSenha(novaPessoa.getSenha());
                pessoas[i].setTipoUsuario(novaPessoa.getTipoUsuario());
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
