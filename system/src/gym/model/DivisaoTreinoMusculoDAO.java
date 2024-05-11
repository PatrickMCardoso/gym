package gym.model;

import java.time.LocalDate;

public class DivisaoTreinoMusculoDAO {

    private DivisaoTreinoMusculo[] divisoesTreinoMusculo;
    private int tamanho;

    public DivisaoTreinoMusculoDAO() {
        this.divisoesTreinoMusculo = new DivisaoTreinoMusculo[10];
        this.tamanho = 0;
    }

    public void adicionarDivisaoTreinoMusculo(DivisaoTreinoMusculo divisaoTreinoMusculo) {
        if (tamanho == divisoesTreinoMusculo.length) {
            aumentarCapacidade();
        }
        divisaoTreinoMusculo.setId(tamanho + 1);
        divisoesTreinoMusculo[tamanho++] = divisaoTreinoMusculo;
    }

    public void alterarDivisaoTreinoMusculo(int id, DivisaoTreinoMusculo novaDivisaoTreinoMusculo) {
        for (int i = 0; i < tamanho; i++) {
            if (divisoesTreinoMusculo[i].getId() == id) {
                divisoesTreinoMusculo[i] = novaDivisaoTreinoMusculo;
                break;
            }
        }
    }

    public void removerDivisaoTreinoMusculo(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (divisoesTreinoMusculo[i].getId() == id) {
                for (int j = i; j < tamanho - 1; j++) {
                    divisoesTreinoMusculo[j] = divisoesTreinoMusculo[j + 1];
                }
                tamanho--;
                break;
            }
        }

        for (int i = 0; i < tamanho; i++) {
            divisoesTreinoMusculo[i].setId(i + 1);
        }
    }

    public DivisaoTreinoMusculo buscarDivisaoTreinoMusculo(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (divisoesTreinoMusculo[i].getId() == id) {
                return divisoesTreinoMusculo[i];
            }
        }
        return null;
    }

    public DivisaoTreinoMusculo[] mostrarDivisoesTreinoMusculo() {
        DivisaoTreinoMusculo[] divisoesExistentes = new DivisaoTreinoMusculo[tamanho];
        System.arraycopy(divisoesTreinoMusculo, 0, divisoesExistentes, 0, tamanho);
        return divisoesExistentes;
    }

    private void aumentarCapacidade() {
        int novaCapacidade = divisoesTreinoMusculo.length * 2;
        DivisaoTreinoMusculo[] novoArray = new DivisaoTreinoMusculo[novaCapacidade];
        System.arraycopy(divisoesTreinoMusculo, 0, novoArray, 0, tamanho);
        divisoesTreinoMusculo = novoArray;
    }
}
