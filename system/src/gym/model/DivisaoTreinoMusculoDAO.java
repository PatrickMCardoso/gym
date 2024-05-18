package gym.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class DivisaoTreinoMusculoDAO {

    private DivisaoTreinoMusculo[] divisoes;
    private int tamanho;
    private DivisaoTreinoDAO divisaoTreinoDAO;

    public DivisaoTreinoMusculoDAO(DivisaoTreinoDAO divisaoTreinoDAO) {
        this.divisoes = new DivisaoTreinoMusculo[10];
        this.tamanho = 0;
        this.divisaoTreinoDAO = divisaoTreinoDAO;
    }

    public void adicionarDivisaoTreinoMusculo(DivisaoTreino divisaoTreino, String[] tiposExercicios) {
        if (tamanho == divisoes.length) {
            aumentarCapacidade();
        }
        int id = tamanho + 1;
        DivisaoTreinoMusculo divisaoTreinoMusculo = new DivisaoTreinoMusculo(id, divisaoTreino, LocalDate.now(), LocalDate.now(), tiposExercicios);
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
}
