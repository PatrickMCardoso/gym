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

    public void adicionarMensalidadesExemplo() {
        Mensalidade mensalidade1 = new Mensalidade(1, "Mensal", 120.0, LocalDate.now(), LocalDate.now().plusMonths(1), LocalDate.now(), LocalDate.now());
        Mensalidade mensalidade2 = new Mensalidade(2, "Trimestral", 300.0, LocalDate.now(), LocalDate.now().plusMonths(3), LocalDate.now(), LocalDate.now());
        Mensalidade mensalidade3 = new Mensalidade(3, "Anual", 1000.0, LocalDate.now(), LocalDate.now().plusMonths(12), LocalDate.now(), LocalDate.now());

        adicionarMensalidade(mensalidade1);
        adicionarMensalidade(mensalidade2);
        adicionarMensalidade(mensalidade3);
    }

    public void adicionarMensalidade(Mensalidade mensalidade) {
        geradorId++;
        if (tamanho == mensalidades.length) {
            aumentarCapacidade();
        }
        int id = geradorId;
        mensalidade.setId(id);
        LocalDate dataAtual = LocalDate.now();
        mensalidade.setDataCriacao(dataAtual);
        mensalidade.setDataModificacao(dataAtual);
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
