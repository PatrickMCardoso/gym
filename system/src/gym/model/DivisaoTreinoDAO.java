package gym.model;

import java.time.LocalDate;

public class DivisaoTreinoDAO {

    private DivisaoTreino[] divisoes;
    private int tamanho;

    public DivisaoTreinoDAO() {
        this.divisoes = new DivisaoTreino[10];
        this.tamanho = 0;
    }
    
    public void adicionarDivisaoTreinoExemplos() {
        String[][] exemplos = {
            {"AB", "AB 2x descansa 1x"},
            {"ABC", "ABC 2x descansa 1x"},
            {"ABC", "ABC descansa 1x ABC descansa 1x"},
            {"ABCD", "ABCD descansa 1x ABCD descansa 1x"},
            {"ABCDE", "ABCDE descansa 1x"}
        };

        for (String[] exemplo : exemplos) {
            adicionarDivisaoTreino(exemplo[0], exemplo[1]);
        }
    }

    public void adicionarDivisaoTreino(String nome, String descricao) {
        if (tamanho == divisoes.length) {
            aumentarCapacidade();
        }
        int id = tamanho + 1;
        DivisaoTreino divisao = new DivisaoTreino(id, nome, descricao, LocalDate.now(), LocalDate.now());
        divisoes[tamanho++] = divisao;
    }

    public void alterarDivisaoTreino(int id, String nome, String descricao) {
        for (int i = 0; i < tamanho; i++) {
            if (divisoes[i].getId() == id) {
                divisoes[i].setNome(nome);
                divisoes[i].setDescricao(descricao);
                divisoes[i].setDataModificacao(LocalDate.now());
                break;
            }
        }
    }

    public void removerDivisaoTreino(int id) {
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

    public DivisaoTreino buscarDivisaoTreino(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (divisoes[i] != null && divisoes[i].getId() == id) {
                return divisoes[i];
            }
        }
        return null;
    }

    public DivisaoTreino[] mostrarDivisoesTreino() {
        DivisaoTreino[] divisoesExistentes = new DivisaoTreino[tamanho];
        System.arraycopy(divisoes, 0, divisoesExistentes, 0, tamanho);
        return divisoesExistentes;
    }
    
    public DivisaoTreino buscarDivisaoTreinoPorNome(String nome) {
        for (DivisaoTreino divisaoTreino : divisoes) {
            if (divisaoTreino != null && divisaoTreino.getNome().equalsIgnoreCase(nome)) {
                return divisaoTreino;
            }
        }
        return null;
    }
    
    public void mostrarTodasDivisoesTreinoMenu() {
        DivisaoTreino[] divisoesTreino = mostrarDivisoesTreino();
        System.out.println("Divisoes de Treino Disponiveis:");
        for (DivisaoTreino divisaoTreino : divisoesTreino) {
            System.out.println("ID: " + divisaoTreino.getId() + ", Nome: " + divisaoTreino.getNome());
        }
    }


    private void aumentarCapacidade() {
        int novaCapacidade = divisoes.length * 2;
        DivisaoTreino[] novoArray = new DivisaoTreino[novaCapacidade];
        System.arraycopy(divisoes, 0, novoArray, 0, tamanho);
        divisoes = novoArray;
    }
}
