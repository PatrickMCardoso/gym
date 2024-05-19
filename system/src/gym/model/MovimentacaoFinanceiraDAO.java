package gym.model;

import java.time.LocalDate;

public class MovimentacaoFinanceiraDAO {

    private MovimentacaoFinanceira[] movimentacoes;
    private int tamanho;
    private int geradorId;

    public MovimentacaoFinanceiraDAO() {
        this.movimentacoes = new MovimentacaoFinanceira[10];
        this.tamanho = 0;
        this.geradorId = 0;
    }

    public void adicionarMovimentacao(MovimentacaoFinanceira movimentacao) {
        geradorId++;
        if (tamanho == movimentacoes.length) {
            aumentarCapacidade();
        }
        int id = geradorId;
        movimentacao.setId(id);
        LocalDate dataAtual = LocalDate.now();
        movimentacao.setDataCriacao(dataAtual);
        movimentacao.setDataModificacao(dataAtual);
        movimentacoes[tamanho++] = movimentacao;
    }

    private void aumentarCapacidade() {
        int novaCapacidade = movimentacoes.length * 2;
        MovimentacaoFinanceira[] novoArray = new MovimentacaoFinanceira[novaCapacidade];
        System.arraycopy(movimentacoes, 0, novoArray, 0, tamanho);
        movimentacoes = novoArray;
    }

    public void alterarMovimentacao(int id, MovimentacaoFinanceira novaMovimentacao) {
        for (int i = 0; i < tamanho; i++) {
            if (movimentacoes[i].getId() == id) {
                movimentacoes[i].setValor(novaMovimentacao.getValor());
                movimentacoes[i].setTipo(novaMovimentacao.getTipo());
                movimentacoes[i].setDescricao(novaMovimentacao.getDescricao());
                movimentacoes[i].setDataModificacao(LocalDate.now());
                break;
            }
        }
    }

    public void removerMovimentacao(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (movimentacoes[i].getId() == id) {
                for (int j = i; j < tamanho - 1; j++) {
                    movimentacoes[j] = movimentacoes[j + 1];
                }
                tamanho--;
                break;
            }
        }
    }

    public MovimentacaoFinanceira buscarMovimentacao(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (movimentacoes[i].getId() == id) {
                return movimentacoes[i];
            }
        }
        return null;
    }

    public MovimentacaoFinanceira[] mostrarMovimentacoes() {
        MovimentacaoFinanceira[] movimentacoesExistentes = new MovimentacaoFinanceira[tamanho];
        System.arraycopy(movimentacoes, 0, movimentacoesExistentes, 0, tamanho);
        return movimentacoesExistentes;
    }
    
    public void pagarDespesasAcademia(Pessoa[] pessoas, LocalDate dataAtual){
        Double valorDespesasDoMes;
        //ALUGUEL
        valorDespesasDoMes = 1800.0;
        //ENERGIA
        valorDespesasDoMes += 400.0;   
        //AGUA
        valorDespesasDoMes += 200.0;        
        
        
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getTipoUsuario().equals("Professor")) {
                valorDespesasDoMes += 2000.0;
            }
        }
        
        MovimentacaoFinanceira movimentacaoDespesas = new MovimentacaoFinanceira(0, valorDespesasDoMes, "saida", "Despesas do mes " + dataAtual.getMonth() + "/" + dataAtual.getYear(), dataAtual, dataAtual);
        adicionarMovimentacao(movimentacaoDespesas);
    }
}
