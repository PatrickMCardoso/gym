package gym.model;

import java.time.LocalDate;

public class PagamentoRecorrenteDAO {

    private PagamentoRecorrente[] pagamentos;
    private int tamanho;
    private int geradorId;

    public PagamentoRecorrenteDAO() {
        this.pagamentos = new PagamentoRecorrente[10];
        this.tamanho = 0;
        this.geradorId = 0;
    }

    public void adicionarPagamento(PagamentoRecorrente pagamento, LocalDate dataAtual) {
        geradorId++;
        if (tamanho == pagamentos.length) {
            aumentarCapacidade();
        }
        pagamento.setId(geradorId);
        pagamento.setDataCriacao(dataAtual);
        pagamento.setDataModificacao(dataAtual);
        pagamentos[tamanho++] = pagamento;
    }

    private void aumentarCapacidade() {
        int novaCapacidade = pagamentos.length * 2;
        PagamentoRecorrente[] novoArray = new PagamentoRecorrente[novaCapacidade];
        System.arraycopy(pagamentos, 0, novoArray, 0, tamanho);
        pagamentos = novoArray;
    }

    public void alterarPagamento(int id, PagamentoRecorrente novoPagamento, LocalDate dataAtual) {
        for (int i = 0; i < tamanho; i++) {
            if (pagamentos[i].getId() == id) {
                pagamentos[i].setIdPessoa(novoPagamento.getIdPessoa());
                pagamentos[i].setData(novoPagamento.getData());
                pagamentos[i].setCartaoDeCredito(novoPagamento.getCartaoDeCredito());
                pagamentos[i].setDataDeInicio(novoPagamento.getDataDeInicio());
                pagamentos[i].setNumeroDeMeses(novoPagamento.getNumeroDeMeses());
                pagamentos[i].setDataModificacao(dataAtual);
                break;
            }
        }
    }

    public void removerPagamento(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (pagamentos[i].getId() == id) {
                for (int j = i; j < tamanho - 1; j++) {
                    pagamentos[j] = pagamentos[j + 1];
                }
                tamanho--;
                break;
            }
        }
    }

    public PagamentoRecorrente buscarPagamento(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (pagamentos[i].getId() == id) {
                return pagamentos[i];
            }
        }
        return null;
    }

    public PagamentoRecorrente[] mostrarPagamentos() {
        PagamentoRecorrente[] pagamentosExistentes = new PagamentoRecorrente[tamanho];
        System.arraycopy(pagamentos, 0, pagamentosExistentes, 0, tamanho);
        return pagamentosExistentes;
    }
}
