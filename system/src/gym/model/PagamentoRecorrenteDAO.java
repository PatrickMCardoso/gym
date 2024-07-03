package gym.model;

import gym.controller.SQLConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PagamentoRecorrenteDAO {

    private ArrayList<PagamentoRecorrente> pagamentos;

    public PagamentoRecorrenteDAO() {
        this.pagamentos = new ArrayList<>();
    }

    public void recuperarDadosPagamentoRecorrente() {
        String sql = "SELECT * FROM PagamentoRecorrente";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    int idPessoa = rs.getInt("idPessoa");
                    int idMensalidadeAluno = rs.getInt("idMensalidadeAluno");
                    LocalDate data = rs.getDate("data").toLocalDate();
                    String cartaoDeCredito = rs.getString("cartaoDeCredito");
                    double valor = rs.getDouble("valor");
                    LocalDate dataDeInicio = rs.getDate("dataDeInicio").toLocalDate();
                    int numeroDeMeses = rs.getInt("numeroDeMeses");
                    LocalDate dataCriacao = rs.getDate("dataCriacao").toLocalDate();
                    LocalDate dataModificacao = rs.getDate("dataModificacao").toLocalDate();

                    PagamentoRecorrente pagamento = new PagamentoRecorrente(id, idPessoa, idMensalidadeAluno, data, cartaoDeCredito, valor, dataDeInicio, numeroDeMeses, dataCriacao, dataModificacao);
                    pagamentos.add(pagamento);
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public boolean checarPagamentoRecorrenteExisteBanco(int id) {
        String sql = "SELECT * FROM PagamentoRecorrente WHERE id = ?";
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

    public void adicionarPagamentoRecorrente(PagamentoRecorrente pagamento, LocalDate dataAtual) {
        String sql = "INSERT INTO PagamentoRecorrente (idPessoa, idMensalidadeAluno, data, cartaoDeCredito, valor, dataDeInicio, numeroDeMeses, dataCriacao, dataModificacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, pagamento.getIdPessoa());
                stmt.setInt(2, pagamento.getIdMensalidadeAluno());
                stmt.setDate(3, Date.valueOf(pagamento.getData()));
                stmt.setString(4, pagamento.getCartaoDeCredito());
                stmt.setDouble(5, pagamento.getValor());
                stmt.setDate(6, Date.valueOf(pagamento.getDataDeInicio()));
                stmt.setInt(7, pagamento.getNumeroDeMeses());
                stmt.setDate(8, Date.valueOf(dataAtual));
                stmt.setDate(9, Date.valueOf(dataAtual));

                if (!checarPagamentoRecorrenteExisteBanco(pagamento.getId())) {
                    stmt.executeUpdate();
                    ResultSet rs = stmt.getGeneratedKeys();
                    if (rs.next()) {
                        pagamento.setId(rs.getInt(1));
                    }
                    pagamentos.clear();
                    recuperarDadosPagamentoRecorrente();
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public void alterarPagamentoRecorrente(int id, PagamentoRecorrente novoPagamento, LocalDate dataAtual) {
        for (PagamentoRecorrente pagamento : pagamentos) {
            if (pagamento.getId() == id) {
                pagamento.setIdPessoa(novoPagamento.getIdPessoa());
                pagamento.setData(novoPagamento.getData());
                pagamento.setCartaoDeCredito(novoPagamento.getCartaoDeCredito());
                pagamento.setDataDeInicio(novoPagamento.getDataDeInicio());
                pagamento.setNumeroDeMeses(novoPagamento.getNumeroDeMeses());
                pagamento.setDataModificacao(dataAtual);

                String sql = "UPDATE PagamentoRecorrente SET idPessoa = ?, idMensalidadeAluno = ?, data = ?, cartaoDeCredito = ?, valor = ?, dataDeInicio = ?, numeroDeMeses = ?, dataModificacao = ? WHERE id = ?";
                try {
                    try (Connection conn = SQLConnection.getConnection()) {
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setInt(1, novoPagamento.getIdPessoa());
                        stmt.setInt(2, novoPagamento.getIdMensalidadeAluno());
                        stmt.setDate(3, Date.valueOf(novoPagamento.getData()));
                        stmt.setString(4, novoPagamento.getCartaoDeCredito());
                        stmt.setDouble(5, novoPagamento.getValor());
                        stmt.setDate(6, Date.valueOf(novoPagamento.getDataDeInicio()));
                        stmt.setInt(7, novoPagamento.getNumeroDeMeses());
                        stmt.setDate(8, Date.valueOf(dataAtual));
                        stmt.setInt(9, id);
                        stmt.executeUpdate();
                        pagamentos.clear();
                        recuperarDadosPagamentoRecorrente();
                    }
                } catch (SQLException e) {
                    System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
                }
                break;
            }
        }
    }

    public void removerPagamentoRecorrente(int id) {
        pagamentos.removeIf(pagamento -> pagamento.getId() == id);

        String sql = "DELETE FROM PagamentoRecorrente WHERE id = ?";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.executeUpdate();
                pagamentos.clear();
                recuperarDadosPagamentoRecorrente();
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public PagamentoRecorrente buscarPagamentoRecorrente(int id) {
        for (PagamentoRecorrente pagamento : pagamentos) {
            if (pagamento.getId() == id) {
                return pagamento;
            }
        }
        return null;
    }

    public ArrayList<PagamentoRecorrente> mostrarPagamentosRecorrentes() {
        return new ArrayList<>(pagamentos);
    }
}
