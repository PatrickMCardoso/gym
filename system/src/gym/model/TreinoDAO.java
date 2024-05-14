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

    public void adicionarTreino(Pessoa pessoa, String objetivo, LocalDate dataInicio, LocalDate dataTermino, DivisaoTreino divisaoTreino) {
        if (tamanho == treinos.length) {
            aumentarCapacidade();
        }
        int id = ++geradorId;
        LocalDate dataAtual = LocalDate.now();
        Treino treino = new Treino(id, pessoa, objetivo, dataInicio, dataTermino, divisaoTreino, dataAtual, dataAtual);
        treinos[tamanho++] = treino;
    }

    public void alterarTreino(int id, String objetivo, LocalDate dataInicio, LocalDate dataTermino, DivisaoTreino divisaoTreino) {
        for (int i = 0; i < tamanho; i++) {
            if (treinos[i].getId() == id) {
                treinos[i].setObjetivo(objetivo);
                treinos[i].setDataInicio(dataInicio);
                treinos[i].setDataTermino(dataTermino);
                treinos[i].setDivisaoTreino(divisaoTreino);
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
