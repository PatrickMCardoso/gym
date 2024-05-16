package gym.model;

import java.time.LocalDate;

public class TreinoDAO {
    private Treino[] treinos;
    private int tamanho;
    private int geradorId;

    public TreinoDAO() {
        this.treinos = new Treino[10];
        this.tamanho = 0;
        this.geradorId = 0;
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
