package gym.model;

import gym.controller.SQLConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MovimentacaoFinanceiraDAO {

    private ArrayList<MovimentacaoFinanceira> movimentacoes;

    public MovimentacaoFinanceiraDAO() {
        this.movimentacoes = new ArrayList<>();
    }

    public void recuperarMovimentacoes() {
        String sql = "SELECT * FROM MovimentacaoFinanceira";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    double valor = rs.getDouble("valor");
                    String tipo = rs.getString("tipo");
                    String descricao = rs.getString("descricao");
                    LocalDate dataCriacao = rs.getDate("dataCriacao").toLocalDate();
                    LocalDate dataModificacao = rs.getDate("dataModificacao").toLocalDate();
                    MovimentacaoFinanceira movimentacao = new MovimentacaoFinanceira(id, valor, tipo, descricao, dataCriacao, dataModificacao);
                    movimentacoes.add(movimentacao);
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public boolean checarMovimentacaoExisteBanco(int id) {
        String sql = "SELECT * FROM MovimentacaoFinanceira WHERE id = ?";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }

        return false;
    }

    public void adicionarMovimentacao(MovimentacaoFinanceira movimentacao, LocalDate dataAtual) {
        String sql = "INSERT INTO MovimentacaoFinanceira (valor, tipo, descricao, dataCriacao, dataModificacao) VALUES (?, ?, ?, ?, ?)";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setDouble(1, movimentacao.getValor());
                stmt.setString(2, movimentacao.getTipo());
                stmt.setString(3, movimentacao.getDescricao());
                stmt.setDate(4, Date.valueOf(movimentacao.getDataCriacao()));
                stmt.setDate(5, Date.valueOf(movimentacao.getDataModificacao()));

                stmt.executeUpdate();

                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    movimentacao.setId(id);
                    movimentacoes.add(movimentacao);
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public void alterarMovimentacao(int id, MovimentacaoFinanceira novaMovimentacao, LocalDate dataAtual) {
        String sql = "UPDATE MovimentacaoFinanceira SET valor = ?, tipo = ?, descricao = ?, dataModificacao = ? WHERE id = ?";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setDouble(1, novaMovimentacao.getValor());
                stmt.setString(2, novaMovimentacao.getTipo());
                stmt.setString(3, novaMovimentacao.getDescricao());
                stmt.setDate(4, Date.valueOf(novaMovimentacao.getDataModificacao()));
                stmt.setInt(5, id);
                stmt.executeUpdate();

                for (MovimentacaoFinanceira movimentacao : movimentacoes) {
                    if (movimentacao.getId() == id) {
                        movimentacao.setValor(novaMovimentacao.getValor());
                        movimentacao.setTipo(novaMovimentacao.getTipo());
                        movimentacao.setDescricao(novaMovimentacao.getDescricao());
                        movimentacao.setDataModificacao(dataAtual);
                        break;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public void removerMovimentacao(int id) {
        String sql = "DELETE FROM MovimentacaoFinanceira WHERE id = ?";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.executeUpdate();

                movimentacoes.removeIf(movimentacao -> movimentacao.getId() == id);
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public MovimentacaoFinanceira buscarMovimentacao(int id) {
        for (MovimentacaoFinanceira movimentacao : movimentacoes) {
            if (movimentacao.getId() == id) {
                return movimentacao;
            }
        }
        return null;
    }

    public ArrayList<MovimentacaoFinanceira> mostrarMovimentacoes() {
        return new ArrayList<>(movimentacoes);
    }

    public void pagarDespesasAcademia(ArrayList<Pessoa> pessoas, LocalDate dataAtual) {
        Double valorDespesasDoMes = 0.0;

        // Simulacao de despesas fixas
        valorDespesasDoMes += 1800.0; // ALUGUEL
        valorDespesasDoMes += 400.0;  // ENERGIA
        valorDespesasDoMes += 200.0;  // AGUA

        // Adicionando despesas de professores
        for (Pessoa pessoa : pessoas) {
            if ("Professor".equals(pessoa.getTipoUsuario())) {
                valorDespesasDoMes += 2000.0;
            }
        }

        MovimentacaoFinanceira movimentacaoDespesas = new MovimentacaoFinanceira(0, valorDespesasDoMes, "saida", "Despesas do mês " + (dataAtual.getMonthValue() - 1) + "/" + dataAtual.getYear(), dataAtual.minusWeeks(1), dataAtual);
        adicionarMovimentacao(movimentacaoDespesas, dataAtual.minusWeeks(1));
    }
}
