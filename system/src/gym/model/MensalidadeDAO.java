package gym.model;

import gym.controller.SQLConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MensalidadeDAO {

    private ArrayList<Mensalidade> mensalidades;

    public MensalidadeDAO() {
        this.mensalidades = new ArrayList<>();
    }

    public void recuperarDadosMensalidade() {
        String sql = "SELECT * FROM Mensalidade";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String descricao = rs.getString("descricao");
                    double valor = rs.getDouble("valor");
                    LocalDate dataInicio = rs.getDate("dataInicio").toLocalDate();
                    LocalDate dataFim = rs.getDate("dataFim").toLocalDate();
                    int termino = rs.getInt("termino");
                    LocalDate dataCriacao = rs.getDate("dataCriacao").toLocalDate();
                    LocalDate dataModificacao = rs.getDate("dataModificacao").toLocalDate();
                    Mensalidade mensalidade = new Mensalidade(id, descricao, valor, dataInicio, dataFim, termino, dataCriacao, dataModificacao);
                    mensalidades.add(mensalidade);
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public boolean checarMensalidadeExisteBanco(int id) {
        String sql = "SELECT * FROM Mensalidade WHERE id = ?";
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

    public void adicionarMensalidadesExemplo() {
        if (!checarMensalidadeExisteBanco(1)) {
            LocalDate dataAtual = LocalDate.now();

            Mensalidade mensalidade1 = new Mensalidade(1, "Mensal", 120.0, dataAtual, dataAtual.plusMonths(1), 1, dataAtual, dataAtual);
            Mensalidade mensalidade2 = new Mensalidade(2, "Trimestral", 300.0, dataAtual, dataAtual.plusMonths(3), 3, dataAtual, dataAtual);
            Mensalidade mensalidade3 = new Mensalidade(3, "Anual", 1000.0, dataAtual, dataAtual.plusMonths(12), 12, dataAtual, dataAtual);

            adicionarMensalidade(mensalidade1, dataAtual);
            adicionarMensalidade(mensalidade2, dataAtual);
            adicionarMensalidade(mensalidade3, dataAtual);
        }
    }

    public void adicionarMensalidade(Mensalidade mensalidade, LocalDate dataAtual) {
        String sql = "INSERT INTO Mensalidade (descricao, valor, dataInicio, dataFim, termino, dataCriacao, dataModificacao) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, mensalidade.getDescricao());
                stmt.setDouble(2, mensalidade.getValor());
                stmt.setDate(3, Date.valueOf(mensalidade.getDataInicio()));
                stmt.setDate(4, Date.valueOf(mensalidade.getDataFim()));
                stmt.setInt(5, mensalidade.getTermino());
                stmt.setDate(6, Date.valueOf(mensalidade.getDataCriacao()));
                stmt.setDate(7, Date.valueOf(mensalidade.getDataModificacao()));

                int id = mensalidade.getId();

                if (!checarMensalidadeExisteBanco(id)) {
                    stmt.executeUpdate();
                    mensalidades.clear();
                    recuperarDadosMensalidade();
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public void alterarMensalidade(int id, Mensalidade novaMensalidade, LocalDate dataAtual) {
        for (Mensalidade mensalidade : mensalidades) {
            if (mensalidade.getId() == id) {
                mensalidade.setDescricao(novaMensalidade.getDescricao());
                mensalidade.setValor(novaMensalidade.getValor());
                mensalidade.setDataInicio(novaMensalidade.getDataInicio());
                mensalidade.setDataFim(novaMensalidade.getDataFim());
                mensalidade.setTermino(novaMensalidade.getTermino());
                mensalidade.setDataModificacao(dataAtual);

                String sql = "UPDATE Mensalidade SET descricao = ?, valor = ?, dataInicio = ?, dataFim = ?, termino = ?, dataModificacao = ? WHERE id = ?";
                try {
                    try (Connection conn = SQLConnection.getConnection()) {
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setString(1, mensalidade.getDescricao());
                        stmt.setDouble(2, mensalidade.getValor());
                        stmt.setDate(3, Date.valueOf(mensalidade.getDataInicio()));
                        stmt.setDate(4, Date.valueOf(mensalidade.getDataFim()));
                        stmt.setInt(5, mensalidade.getTermino());
                        stmt.setDate(6, Date.valueOf(mensalidade.getDataModificacao()));
                        stmt.setInt(7, mensalidade.getId());
                        stmt.executeUpdate();
                        mensalidades.clear();
                        recuperarDadosMensalidade();
                    }
                } catch (SQLException e) {
                    System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
                }
                break;
            }
        }
    }

    public void removerMensalidade(int id) {
        mensalidades.removeIf(mensalidade -> mensalidade.getId() == id);

        String sql = "DELETE FROM Mensalidade WHERE id = ?";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.executeUpdate();
                mensalidades.clear();
                recuperarDadosMensalidade();
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public Mensalidade buscarMensalidade(int id) {
        for (Mensalidade mensalidade : mensalidades) {
            if (mensalidade.getId() == id) {
                return mensalidade;
            }
        }
        return null;
    }

    public ArrayList<Mensalidade> mostrarMensalidades() {
        return new ArrayList<>(mensalidades);
    }
}
