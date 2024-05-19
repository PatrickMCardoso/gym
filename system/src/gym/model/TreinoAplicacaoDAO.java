package gym.model;

import java.time.LocalDate;

public class TreinoAplicacaoDAO {
    private TreinoAplicacao[] treinoAplicacoes;
    private int tamanho;
    private int geradorId;

    public TreinoAplicacaoDAO() {
        this.treinoAplicacoes = new TreinoAplicacao[10];
        this.tamanho = 0;
        this.geradorId = 1;
    }

    public void adicionarTreinoAplicacao(TreinoAplicacao treinoAplicacao) {
        if (tamanho == treinoAplicacoes.length) {
            aumentarCapacidade();
        }
        treinoAplicacao.setId(geradorId++);
        treinoAplicacoes[tamanho++] = treinoAplicacao;
    }

    public TreinoAplicacao buscarTreinoAplicacao(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (treinoAplicacoes[i].getId() == id) {
                return treinoAplicacoes[i];
            }
        }
        return null;
    }

    public void alterarTreinoAplicacao(int id, TreinoAplicacao novoTreinoAplicacao) {
        for (int i = 0; i < tamanho; i++) {
            if (treinoAplicacoes[i].getId() == id) {
                novoTreinoAplicacao.setId(id);
                treinoAplicacoes[i] = novoTreinoAplicacao;
                return;
            }
        }
    }

    public void removerTreinoAplicacao(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (treinoAplicacoes[i].getId() == id) {
                for (int j = i; j < tamanho - 1; j++) {
                    treinoAplicacoes[j] = treinoAplicacoes[j + 1];
                }
                treinoAplicacoes[--tamanho] = null;
                return;
            }
        }
    }

    public TreinoAplicacao[] listarTodos() {
        TreinoAplicacao[] resultado = new TreinoAplicacao[tamanho];
        System.arraycopy(treinoAplicacoes, 0, resultado, 0, tamanho);
        return resultado;
    }

    private void aumentarCapacidade() {
        TreinoAplicacao[] novoArray = new TreinoAplicacao[treinoAplicacoes.length * 2];
        System.arraycopy(treinoAplicacoes, 0, novoArray, 0, treinoAplicacoes.length);
        treinoAplicacoes = novoArray;
    }
}
