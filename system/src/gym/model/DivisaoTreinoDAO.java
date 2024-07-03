package gym.model;

import gym.controller.SQLConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DivisaoTreinoDAO {

    private ArrayList<DivisaoTreino> divisoes;

    public DivisaoTreinoDAO() {
        this.divisoes = new ArrayList<>();
    }

    public void recuperarDadosDivisaoTreino() {
        String sql = "SELECT * FROM DivisaoTreino";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String descricao = rs.getString("descricao");
                    LocalDate dataCriacao = rs.getDate("dataCriacao").toLocalDate();
                    LocalDate dataModificacao = rs.getDate("dataModificacao").toLocalDate();
                    DivisaoTreino divisao = new DivisaoTreino(id, nome, descricao, dataCriacao, dataModificacao);
                    divisoes.add(divisao);
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public boolean checarDivisaoTreinoExisteBanco(int id) {
        String sql = "SELECT * FROM DivisaoTreino WHERE id = ?";
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

    public void adicionarDivisaoTreinoExemplos() {
        if (!checarDivisaoTreinoExisteBanco(1)) {
            LocalDate dataAtual = LocalDate.now();

            DivisaoTreino[] divisoesExemplo = {
                new DivisaoTreino(1, "AB", "AB 2x descansa 1x", dataAtual, dataAtual),
                new DivisaoTreino(2, "ABC", "ABC 2x descansa 1x", dataAtual, dataAtual),
                new DivisaoTreino(3, "ABC", "ABC descansa 1x ABC descansa 1x", dataAtual, dataAtual),
                new DivisaoTreino(4, "ABCD", "ABCD descansa 1x ABCD descansa 1x", dataAtual, dataAtual),
                new DivisaoTreino(5, "ABCDE", "ABCDE descansa 1x", dataAtual, dataAtual)
            };

            for (DivisaoTreino divisao : divisoesExemplo) {
                adicionarDivisaoTreino(divisao, dataAtual);
            }
        }
    }

    public void adicionarDivisaoTreino(DivisaoTreino divisao, LocalDate dataAtual) {
        String sql = "INSERT INTO DivisaoTreino (nome, descricao, dataCriacao, dataModificacao) VALUES (?, ?, ?, ?)";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, divisao.getNome());
                stmt.setString(2, divisao.getDescricao());
                stmt.setDate(3, Date.valueOf(divisao.getDataCriacao()));
                stmt.setDate(4, Date.valueOf(divisao.getDataModificacao()));

                int id = divisao.getId();

                if (!checarDivisaoTreinoExisteBanco(id)) {
                    stmt.executeUpdate();
                    divisoes.clear();
                    recuperarDadosDivisaoTreino();
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public void alterarDivisaoTreino(int id, DivisaoTreino novaDivisao, LocalDate dataAtual) {
        for (DivisaoTreino divisao : divisoes) {
            if (divisao.getId() == id) {
                divisao.setNome(novaDivisao.getNome());
                divisao.setDescricao(novaDivisao.getDescricao());
                divisao.setDataModificacao(dataAtual);

                String sql = "UPDATE DivisaoTreino SET nome = ?, descricao = ?, dataModificacao = ? WHERE id = ?";
                try {
                    try (Connection conn = SQLConnection.getConnection()) {
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setString(1, divisao.getNome());
                        stmt.setString(2, divisao.getDescricao());
                        stmt.setDate(3, Date.valueOf(divisao.getDataModificacao()));
                        stmt.setInt(4, divisao.getId());
                        stmt.executeUpdate();
                        divisoes.clear();
                        recuperarDadosDivisaoTreino();
                    }
                } catch (SQLException e) {
                    System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
                }
                break;
            }
        }
    }

    public void removerDivisaoTreino(int id) {
        divisoes.removeIf(divisao -> divisao.getId() == id);

        String sql = "DELETE FROM DivisaoTreino WHERE id = ?";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.executeUpdate();
                divisoes.clear();
                recuperarDadosDivisaoTreino();
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public DivisaoTreino buscarDivisaoTreino(int id) {
        for (DivisaoTreino divisao : divisoes) {
            if (divisao.getId() == id) {
                return divisao;
            }
        }
        return null;
    }

    public ArrayList<DivisaoTreino> mostrarDivisoesTreino() {
        return new ArrayList<>(divisoes);
    }

    public DivisaoTreino buscarDivisaoTreinoPorNome(String nome) {
        String sql = "SELECT * FROM DivisaoTreino WHERE nome = ?";
        try (Connection conn = SQLConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                LocalDate dataCriacao = rs.getDate("dataCriacao").toLocalDate();
                LocalDate dataModificacao = rs.getDate("dataModificacao").toLocalDate();

                return new DivisaoTreino(id, nome, descricao, dataCriacao, dataModificacao);
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao buscar a divisao de treino por nome: " + e.getMessage());
        }
        return null;
    }

    public void mostrarTodasDivisoesTreinoMenu() {
        ArrayList<DivisaoTreino> divisoesTreino = mostrarDivisoesTreino();
        System.out.println("Divisoes de Treino Disponiveis:");
        for (DivisaoTreino divisaoTreino : divisoesTreino) {
            System.out.println("ID: " + divisaoTreino.getId() + ", Nome: " + divisaoTreino.getNome());
        }
    }
}
