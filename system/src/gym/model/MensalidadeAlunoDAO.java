package gym.model;

import gym.controller.SQLConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MensalidadeAlunoDAO {

    private ArrayList<MensalidadeAluno> mensalidadesAluno;

    public MensalidadeAlunoDAO() {
        this.mensalidadesAluno = new ArrayList<>();
    }

    public void recuperarDadosMensalidadeAluno() {
        String sql = "SELECT * FROM MensalidadeAluno";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    int idAluno = rs.getInt("idAluno");
                    int idMensalidade = rs.getInt("idMensalidade");
                    LocalDate dataVencimento = rs.getDate("dataVencimento").toLocalDate();
                    LocalDate dataPagamento = rs.getDate("dataPagamento").toLocalDate();
                    double valorPago = rs.getDouble("valorPago");
                    String modalidade = rs.getString("modalidade");
                    LocalDate dataCriacao = rs.getDate("dataCriacao").toLocalDate();
                    LocalDate dataModificacao = rs.getDate("dataModificacao").toLocalDate();

                    MensalidadeAluno mensalidadeAluno = new MensalidadeAluno(id, idAluno, idMensalidade, dataVencimento, dataPagamento, valorPago, modalidade, dataCriacao, dataModificacao);
                    mensalidadesAluno.add(mensalidadeAluno);
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public boolean checarMensalidadeAlunoExisteBanco(int id) {
        String sql = "SELECT * FROM MensalidadeAluno WHERE id = ?";
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

    public void adicionarMensalidadeAluno(MensalidadeAluno mensalidadeAluno, LocalDate dataAtual) {
        String sql = "INSERT INTO MensalidadeAluno (idAluno, idMensalidade, dataVencimento, dataPagamento, valorPago, modalidade, dataCriacao, dataModificacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, mensalidadeAluno.getIdAluno());
                stmt.setInt(2, mensalidadeAluno.getIdMensalidade());
                stmt.setDate(3, Date.valueOf(mensalidadeAluno.getDataVencimento()));
                stmt.setDate(4, Date.valueOf(mensalidadeAluno.getDataPagamento()));
                stmt.setDouble(5, mensalidadeAluno.getValorPago());
                stmt.setString(6, mensalidadeAluno.getModalidade());
                stmt.setDate(7, Date.valueOf(dataAtual));
                stmt.setDate(8, Date.valueOf(dataAtual));

                if (!checarMensalidadeAlunoExisteBanco(mensalidadeAluno.getId())) {
                    stmt.executeUpdate();
                    ResultSet rs = stmt.getGeneratedKeys();
                    if (rs.next()) {
                        mensalidadeAluno.setId(rs.getInt(1));
                    }
                    mensalidadesAluno.clear();
                    recuperarDadosMensalidadeAluno();
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public void alterarMensalidadeAluno(int id, MensalidadeAluno novaMensalidadeAluno, LocalDate dataAtual) {
        for (MensalidadeAluno mensalidadeAluno : mensalidadesAluno) {
            if (mensalidadeAluno.getId() == id) {
                mensalidadeAluno.setIdAluno(novaMensalidadeAluno.getIdAluno());
                mensalidadeAluno.setIdMensalidade(novaMensalidadeAluno.getIdMensalidade());
                mensalidadeAluno.setDataVencimento(novaMensalidadeAluno.getDataVencimento());
                mensalidadeAluno.setDataPagamento(novaMensalidadeAluno.getDataPagamento());
                mensalidadeAluno.setValorPago(novaMensalidadeAluno.getValorPago());
                mensalidadeAluno.setModalidade(novaMensalidadeAluno.getModalidade());
                mensalidadeAluno.setDataModificacao(dataAtual);

                String sql = "UPDATE MensalidadeAluno SET idAluno = ?, idMensalidade = ?, dataVencimento = ?, dataPagamento = ?, valorPago = ?, modalidade = ?, dataModificacao = ? WHERE id = ?";
                try {
                    try (Connection conn = SQLConnection.getConnection()) {
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setInt(1, novaMensalidadeAluno.getIdAluno());
                        stmt.setInt(2, novaMensalidadeAluno.getIdMensalidade());
                        stmt.setDate(3, Date.valueOf(novaMensalidadeAluno.getDataVencimento()));
                        stmt.setDate(4, Date.valueOf(novaMensalidadeAluno.getDataPagamento()));
                        stmt.setDouble(5, novaMensalidadeAluno.getValorPago());
                        stmt.setString(6, novaMensalidadeAluno.getModalidade());
                        stmt.setDate(7, Date.valueOf(dataAtual));
                        stmt.setInt(8, id);
                        stmt.executeUpdate();
                        mensalidadesAluno.clear();
                        recuperarDadosMensalidadeAluno();
                    }
                } catch (SQLException e) {
                    System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
                }
                break;
            }
        }
    }

    public void removerMensalidadeAluno(int id) {
        mensalidadesAluno.removeIf(mensalidadeAluno -> mensalidadeAluno.getId() == id);

        String sql = "DELETE FROM MensalidadeAluno WHERE id = ?";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.executeUpdate();
                mensalidadesAluno.clear();
                recuperarDadosMensalidadeAluno();
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public MensalidadeAluno buscarMensalidadeAluno(int id) {
        for (MensalidadeAluno mensalidadeAluno : mensalidadesAluno) {
            if (mensalidadeAluno.getId() == id) {
                return mensalidadeAluno;
            }
        }
        return null;
    }

    public ArrayList<MensalidadeAluno> mostrarMensalidadesAluno() {
        return new ArrayList<>(mensalidadesAluno);
    }

    public LocalDate ajustarDataVencimento(LocalDate dataPagamento, LocalDate dataMensalidade) {
        LocalDate dataAtual = LocalDate.now();
        int diferencaMeses = dataMensalidade.getMonthValue() - dataPagamento.getMonthValue();
        return dataAtual.plusMonths(diferencaMeses);
    }
}
