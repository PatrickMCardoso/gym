package gym.model;

import java.time.LocalDate;

public class MensalidadeDAO {

    private Mensalidade[] mensalidades;
    private int tamanho;
    private int geradorId;

    public MensalidadeDAO() {
        this.mensalidades = new Mensalidade[10];
        this.tamanho = 0;
        this.geradorId = 0;
    }

    public void adicionarMensalidade(double valor, LocalDate dataInicio, LocalDate dataFim) {
        geradorId++;
        if (tamanho == mensalidades.length) {
            aumentarCapacidade();
        }
        int id = geradorId;
        LocalDate dataAtual = LocalDate.now();
        Mensalidade mensalidade = new Mensalidade(id, valor, dataInicio, dataFim, dataAtual, dataAtual);
        mensalidades[tamanho++] = mensalidade;
    }

    private void aumentarCapacidade() {
        int novaCapacidade = mensalidades.length * 2;
        Mensalidade[] novoArray = new Mensalidade[novaCapacidade];
        System.arraycopy(mensalidades, 0, novoArray, 0, tamanho);
        mensalidades = novoArray;
    }

    public void alterarMensalidade(int id, Mensalidade novaMensalidade) {
        for (int i = 0; i < tamanho; i++) {
            if (mensalidades[i].getId() == id) {
                mensalidades[i].setValor(novaMensalidade.getValor());
                mensalidades[i].setDataInicio(novaMensalidade.getDataInicio());
                mensalidades[i].setDataFim(novaMensalidade.getDataFim());
                mensalidades[i].setDataModificacao(LocalDate.now());
                break;
            }
        }
    }

    public void removerMensalidade(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (mensalidades[i].getId() == id) {
                for (int j = i; j < tamanho - 1; j++) {
                    mensalidades[j] = mensalidades[j + 1];
                }
                tamanho--;
                break;
            }
        }
    }

    public Mensalidade buscarMensalidade(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (mensalidades[i].getId() == id) {
                return mensalidades[i];
            }
        }
        return null;
    }

    public Mensalidade[] mostrarMensalidades() {
        Mensalidade[] mensalidadesExistentes = new Mensalidade[tamanho];
        System.arraycopy(mensalidades, 0, mensalidadesExistentes, 0, tamanho);
        return mensalidadesExistentes;
    }
}
