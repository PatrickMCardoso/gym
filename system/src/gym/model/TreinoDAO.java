package gym.model;

import java.time.LocalDate;

public class TreinoDAO {
    private Treino[] treinos;
    private int tamanho;
    private int geradorId;
    private PessoaDAO pessoaDAO;
    private DivisaoTreinoDAO divisaoTreinoDAO;

    public TreinoDAO(PessoaDAO pessoaDAO, DivisaoTreinoDAO divisaoTreinoDAO) {
        this.treinos = new Treino[10];
        this.tamanho = 0;
        this.geradorId = 0;
        this.pessoaDAO = pessoaDAO;
        this.divisaoTreinoDAO = divisaoTreinoDAO;
    }
    
    public void adicionarTreinoExemplos() {        
        
        String[] objetivos = {"Definir abdomen", "Ganho de Massa Muscular"};

        Pessoa pessoa2 = pessoaDAO.buscarPessoa(2);
        Pessoa pessoa3 = pessoaDAO.buscarPessoa(3);
        
        DivisaoTreino divisao1 = divisaoTreinoDAO.buscarDivisaoTreino(1);
        DivisaoTreino divisao2 = divisaoTreinoDAO.buscarDivisaoTreino(2);

        if (pessoa2 != null && divisao1 != null) {
            Treino treino1 = new Treino(1, pessoa2, objetivos[0], LocalDate.now().minusDays(62), LocalDate.now().minusDays(32), divisao1, LocalDate.now(), LocalDate.now());
            Treino treino2 = new Treino(2, pessoa3, objetivos[1], LocalDate.now().minusDays(32), LocalDate.now().minusDays(2), divisao2, LocalDate.now(), LocalDate.now());
            adicionarTreino(treino1);
            adicionarTreino(treino2);
        }

        if (pessoa3 != null && divisao2 != null) {
            Treino treino3 = new Treino(3, pessoa3, objetivos[1], LocalDate.now().minusDays(62), LocalDate.now().minusDays(32), divisao2, LocalDate.now(), LocalDate.now());
            Treino treino4 = new Treino(4, pessoa3, objetivos[1], LocalDate.now().minusDays(32), LocalDate.now().minusDays(2), divisao2, LocalDate.now(), LocalDate.now());
            adicionarTreino(treino3);
            adicionarTreino(treino4);
        }
    }

    public void adicionarTreino(Treino treino) {
        if (tamanho == treinos.length) {
            aumentarCapacidade();
        }
        treino.setId(++geradorId);
        treino.setDataCriacao(LocalDate.now());
        treino.setDataModificacao(LocalDate.now());
        treinos[tamanho++] = treino;
    }

    public void alterarTreino(int id, Treino novoTreino) {
        for (int i = 0; i < tamanho; i++) {
            if (treinos[i].getId() == id) {
                treinos[i] = novoTreino; 
                treinos[i].setDataModificacao(LocalDate.now());
                break;
            }
        }
    }

    public void removerTreino(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (treinos[i].getId() == id) {
                for (int j = i; j < tamanho - 1; j++) {
                    treinos[j] = treinos[j + 1];
                }
                tamanho--;
                break;
            }
        }
    }

    public Treino buscarTreino(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (treinos[i].getId() == id) {
                return treinos[i];
            }
        }
        return null;
    }

    public Treino[] mostrarTreinos() {
        Treino[] treinosExistentes = new Treino[tamanho];
        System.arraycopy(treinos, 0, treinosExistentes, 0, tamanho);
        return treinosExistentes;
    }

    private void aumentarCapacidade() {
        int novaCapacidade = treinos.length * 2;
        Treino[] novoArray = new Treino[novaCapacidade];
        System.arraycopy(treinos, 0, novoArray, 0, tamanho);
        treinos = novoArray;
    }
}
