package gym.model;

import gym.controller.SQLConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class AcademiaDAO {

    private ArrayList<Academia> academias;

    public AcademiaDAO() {
        this.academias = new ArrayList<>();
    }

    public void recuperarDadosAcademia() {
        String sql = "SELECT * FROM Academia";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String endereco = rs.getString("endereco");
                    LocalDate dataCriacao = rs.getDate("dataCriacao").toLocalDate();
                    LocalDate dataModificacao = rs.getDate("dataModificacao").toLocalDate();
                    Academia academia = new Academia(id, nome, endereco, dataCriacao, dataModificacao);
                    academias.add(academia);
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public boolean checarAcademiaExisteBanco(int id) {
        String sql = "SELECT * FROM Academia WHERE id = ?";
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

    public void adicionarAcademiasExemplo() {
        if (!checarAcademiaExisteBanco(1)) {
            LocalDate dataAtual = LocalDate.now();

            Academia academia1 = new Academia(1, "Tasmanian Gym", "R. Pires de Campos, 409", dataAtual, dataAtual);
            Academia academia2 = new Academia(2, "BioTech Prime", "Av. Nenê Sabino, 915", dataAtual, dataAtual);
            Academia academia3 = new Academia(3, "Smart Fit", "Av. Guilherme Ferreira, 1550", dataAtual, dataAtual);

            adicionarAcademia(academia1, dataAtual);
            adicionarAcademia(academia2, dataAtual);
            adicionarAcademia(academia3, dataAtual);
        }
    }

    public void adicionarAcademia(Academia academia, LocalDate dataAtual) {
        String sql = "INSERT INTO Academia (nome, endereco, dataCriacao, dataModificacao) VALUES (?, ?, ?, ?)";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, academia.getNome());
                stmt.setString(2, academia.getEndereco());
                stmt.setDate(3, Date.valueOf(academia.getDataCriacao()));
                stmt.setDate(4, Date.valueOf(academia.getDataModificacao()));

                int id = academia.getId();

                if (!checarAcademiaExisteBanco(id)) {
                    stmt.executeUpdate();
                    academias.clear();
                    recuperarDadosAcademia();
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public void alterarAcademia(int id, Academia novaAcademia, LocalDate dataAtual) {
        for (Academia academia : academias) {
            if (academia.getId() == id) {
                academia.setNome(novaAcademia.getNome());
                academia.setEndereco(novaAcademia.getEndereco());
                academia.setDataModificacao(dataAtual);

                String sql = "UPDATE Academia SET nome = ?, endereco = ?, dataModificacao = ? WHERE id = ?";
                try {
                    try (Connection conn = SQLConnection.getConnection()) {
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setString(1, academia.getNome());
                        stmt.setString(2, academia.getEndereco());
                        stmt.setDate(3, Date.valueOf(academia.getDataModificacao()));
                        stmt.setInt(4, academia.getId());
                        stmt.executeUpdate();
                        academias.clear();
                        recuperarDadosAcademia();
                    }
                } catch (SQLException e) {
                    System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
                }
                break;
            }
        }
    }

    public void removerAcademia(int id) {
        academias.removeIf(academia -> academia.getId() == id);

        String sql = "DELETE FROM Academia WHERE id = ?";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.executeUpdate();
                academias.clear();
                recuperarDadosAcademia();
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public Academia buscarAcademia(int id) {
        for (Academia academia : academias) {
            if (academia.getId() == id) {
                return academia;
            }
        }
        return null;
    }

    public ArrayList<Academia> mostrarAcademias() {
        return new ArrayList<>(academias);
    }
}
