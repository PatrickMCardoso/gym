package gym.model;

import java.time.LocalDate;

public class DivisaoTreinoMusculoDAO {

    private DivisaoTreinoMusculo[] divisoes;
    private int tamanho;
    private DivisaoTreinoDAO divisaoTreinoDAO;

    public DivisaoTreinoMusculoDAO(DivisaoTreinoDAO divisaoTreinoDAO) {
        this.divisoes = new DivisaoTreinoMusculo[10];
        this.tamanho = 0;
        this.divisaoTreinoDAO = divisaoTreinoDAO;
    }

    public void adicionarDivisaoTreinoMusculo(int alunoId, DivisaoTreino divisaoTreino, String[] tiposExercicios, LocalDate dataAtual) {
        if (tamanho == divisoes.length) {
            aumentarCapacidade();
        }
        int id = tamanho + 1;
        DivisaoTreinoMusculo divisaoTreinoMusculo = new DivisaoTreinoMusculo(id, alunoId, divisaoTreino, dataAtual, dataAtual, tiposExercicios);
        divisoes[tamanho++] = divisaoTreinoMusculo;
    }

    private void aumentarCapacidade() {
        int novaCapacidade = divisoes.length * 2;
        DivisaoTreinoMusculo[] novoArray = new DivisaoTreinoMusculo[novaCapacidade];
        System.arraycopy(divisoes, 0, novoArray, 0, tamanho);
        divisoes = novoArray;
    }

    public DivisaoTreinoMusculo buscarDivisaoTreinoMusculo(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (divisoes[i].getId() == id) {
                return divisoes[i];
            }
        }
        return null;
    }

    public DivisaoTreinoMusculo[] mostrarDivisoesTreinoMusculo() {
        DivisaoTreinoMusculo[] divisoesExistentes = new DivisaoTreinoMusculo[tamanho];
        System.arraycopy(divisoes, 0, divisoesExistentes, 0, tamanho);
        return divisoesExistentes;
    }

    public void removerDivisaoTreinoMusculo(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (divisoes[i].getId() == id) {
                for (int j = i; j < tamanho - 1; j++) {
                    divisoes[j] = divisoes[j + 1];
                }
                tamanho--;
                break;
            }
        }

        for (int i = 0; i < tamanho; i++) {
            divisoes[i].setId(i + 1);
        }
    }

    public DivisaoTreinoMusculo[] buscarDivisoesTreinoMusculoPorAluno(int alunoId) {
        int count = 0;
        for (int i = 0; i < tamanho; i++) {
            if (divisoes[i].getAlunoId() == alunoId) {
                count++;
            }
        }
        DivisaoTreinoMusculo[] resultado = new DivisaoTreinoMusculo[count];
        int index = 0;
        for (int i = 0; i < tamanho; i++) {
            if (divisoes[i].getAlunoId() == alunoId) {
                resultado[index++] = divisoes[i];
            }
        }
        return resultado;
    }

    public DivisaoTreinoMusculo buscarPrimeiraDivisaoTreinoMusculoPorAluno(int alunoId) {
        for (int i = 0; i < tamanho; i++) {
            if (divisoes[i].getAlunoId() == alunoId) {
                return divisoes[i];
            }
        }
        return null;
    }

    public DivisaoTreinoMusculo buscarDivisaoTreinoMusculoPorTreinoAplicacaoId(int treinoAplicacaoId) {
        for (int i = 0; i < tamanho; i++) {
            if (divisoes[i].getTreinoAplicacaoId() == treinoAplicacaoId) {
                return divisoes[i];
            }
        }
        return null;
    }
}
