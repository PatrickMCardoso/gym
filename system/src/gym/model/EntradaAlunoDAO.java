package gym.model;

import java.time.LocalDate;

public class EntradaAlunoDAO {

    private EntradaAluno[] entradasAlunos;
    private int tamanho;
    private int geradorId;

    public EntradaAlunoDAO() {
        this.entradasAlunos = new EntradaAluno[10];
        this.tamanho = 0;
        this.geradorId = 0;
    }
    
    public void adicionarEntradaAluno(EntradaAluno entradaAluno) {
        geradorId++;
        if (tamanho == entradasAlunos.length) {
            aumentarCapacidade();
        }
        int id = geradorId;
        entradaAluno.setId(id);
        LocalDate dataAtual = LocalDate.now();
        entradaAluno.setDataCriacao(dataAtual);
        entradaAluno.setDataModificacao(dataAtual);
        entradasAlunos[tamanho++] = entradaAluno;
    }

    private void aumentarCapacidade() {
        int novaCapacidade = entradasAlunos.length * 2;
        EntradaAluno[] novoArray = new EntradaAluno[novaCapacidade];
        System.arraycopy(entradasAlunos, 0, novoArray, 0, tamanho);
        entradasAlunos = novoArray;
    }

    public void alterarEntradaAluno(int id, EntradaAluno novaEntradaAluno) {
        for (int i = 0; i < tamanho; i++) {
            if (entradasAlunos[i].getId() == id) {
                entradasAlunos[i].setData(novaEntradaAluno.getData());
                entradasAlunos[i].setDataModificacao(LocalDate.now());
                break;
            }
        }
    }

    public void removerEntradaAluno(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (entradasAlunos[i].getId() == id) {
                for (int j = i; j < tamanho - 1; j++) {
                    entradasAlunos[j] = entradasAlunos[j + 1];
                }
                tamanho--;
                break;
            }
        }
    }

    public EntradaAluno buscarEntradaAluno(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (entradasAlunos[i].getId() == id) {
                return entradasAlunos[i];
            }
        }
        return null;
    }

    public EntradaAluno[] mostrarEntradasAlunos() {
        EntradaAluno[] entradasExistentes = new EntradaAluno[tamanho];
        System.arraycopy(entradasAlunos, 0, entradasExistentes, 0, tamanho);
        return entradasExistentes;
    }
}
