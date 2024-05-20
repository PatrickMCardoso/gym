package gym.model;

import java.time.LocalDate;

public class PessoaDAO {

    private Pessoa[] pessoas;
    private int tamanho;
    private int geradorId;

    public PessoaDAO() {
        this.pessoas = new Pessoa[10];
        this.tamanho = 0;
    }

    public void adicionarPessoasExemplo() {
        Pessoa pessoa1 = new Pessoa(1, "Eduardo", 'M', LocalDate.of(1990, 5, 15), "eduardo@g.com", "eduardo123", "Admin", LocalDate.now(), LocalDate.now());
        Pessoa pessoa2 = new Pessoa(2, "Patrick Machado Cardoso", 'M', LocalDate.of(2004, 4, 12), "patrick@g.com", "patrick123", "Professor", LocalDate.now(), LocalDate.now());
        Pessoa pessoa3 = new Pessoa(3, "Ruan Emanuell", 'M', LocalDate.of(2004, 3, 10), "ruan@g.com", "ruan123", "Aluno", LocalDate.now(), LocalDate.now());

        adicionarPessoa(pessoa1, LocalDate.now());
        adicionarPessoa(pessoa2, LocalDate.now());
        adicionarPessoa(pessoa3, LocalDate.now());
    }

    public void adicionarPessoa(Pessoa pessoa, LocalDate dataAtual) {
        geradorId++;
        if (tamanho == pessoas.length) {
            aumentarCapacidade();
        }
        int id = geradorId;
        pessoa.setId(id);
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

    public void alterarPessoa(int id, Pessoa novaPessoa, LocalDate dataAtual) {
        for (int i = 0; i < tamanho; i++) {
            if (pessoas[i].getId() == id) {
                pessoas[i].setNome(novaPessoa.getNome());
                pessoas[i].setSexo(novaPessoa.getSexo());
                pessoas[i].setNascimento(novaPessoa.getNascimento());
                pessoas[i].setLogin(novaPessoa.getLogin());
                pessoas[i].setSenha(novaPessoa.getSenha());
                pessoas[i].setTipoUsuario(novaPessoa.getTipoUsuario());
                pessoas[i].setDataModificacao(dataAtual);
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
    }

    public Pessoa[] mostrarPessoas() {
        Pessoa[] pessoasExistentes = new Pessoa[tamanho];
        System.arraycopy(pessoas, 0, pessoasExistentes, 0, tamanho);
        return pessoasExistentes;
    }
    
    public Pessoa[] buscarPessoasPorTipo(String tipoUsuario) {
        int count = 0;
        for (int i = 0; i < tamanho; i++) {
            if (pessoas[i].getTipoUsuario().equals(tipoUsuario)) {
                count++;
            }
        }

        Pessoa[] pessoasPorTipo = new Pessoa[count];
        int index = 0;
        for (int i = 0; i < tamanho; i++) {
            if (pessoas[i].getTipoUsuario().equals(tipoUsuario)) {
                pessoasPorTipo[index++] = pessoas[i];
            }
        }
        return pessoasPorTipo;
    }    
    
    public boolean checarTipoPessoa (String tipoUsuario, Pessoa pessoa){
        return pessoa.getTipoUsuario().equals(tipoUsuario);
    }
}
