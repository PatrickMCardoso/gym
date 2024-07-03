package gym.model;

import gym.controller.SQLConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class EntradaAlunoDAO {

    private ArrayList<EntradaAluno> entradasAlunos;

    public EntradaAlunoDAO() {
        this.entradasAlunos = new ArrayList<>();
    }

    public void recuperarDadosEntradaAluno() {
        String sql = "SELECT * FROM EntradaAluno";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    LocalDate data = rs.getDate("data").toLocalDate();
                    LocalDate dataCriacao = rs.getDate("dataCriacao").toLocalDate();
                    LocalDate dataModificacao = rs.getDate("dataModificacao").toLocalDate();

                    EntradaAluno entradaAluno = new EntradaAluno(id, data, dataCriacao, dataModificacao);
                    entradasAlunos.add(entradaAluno);
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public boolean checarEntradaAlunoExisteBanco(int id) {
        String sql = "SELECT * FROM EntradaAluno WHERE id = ?";
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

    public void adicionarEntradaAluno(EntradaAluno entradaAluno, LocalDate dataAtual) {
        String sql = "INSERT INTO EntradaAluno (data, dataCriacao, dataModificacao) VALUES (?, ?, ?)";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setDate(1, Date.valueOf(entradaAluno.getData()));
                stmt.setDate(2, Date.valueOf(dataAtual));
                stmt.setDate(3, Date.valueOf(dataAtual));

                if (!checarEntradaAlunoExisteBanco(entradaAluno.getId())) {
                    stmt.executeUpdate();
                    ResultSet rs = stmt.getGeneratedKeys();
                    if (rs.next()) {
                        entradaAluno.setId(rs.getInt(1));
                    }
                    entradasAlunos.clear();
                    recuperarDadosEntradaAluno();
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public void alterarEntradaAluno(int id, EntradaAluno novaEntradaAluno, LocalDate dataAtual) {
        for (EntradaAluno entradaAluno : entradasAlunos) {
            if (entradaAluno.getId() == id) {
                entradaAluno.setData(novaEntradaAluno.getData());
                entradaAluno.setDataModificacao(dataAtual);

                String sql = "UPDATE EntradaAluno SET data = ?, dataModificacao = ? WHERE id = ?";
                try {
                    try (Connection conn = SQLConnection.getConnection()) {
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setDate(1, Date.valueOf(novaEntradaAluno.getData()));
                        stmt.setDate(2, Date.valueOf(dataAtual));
                        stmt.setInt(3, id);
                        stmt.executeUpdate();
                        entradasAlunos.clear();
                        recuperarDadosEntradaAluno();
                    }
                } catch (SQLException e) {
                    System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
                }
                break;
            }
        }
    }

    public void removerEntradaAluno(int id) {
        entradasAlunos.removeIf(entradaAluno -> entradaAluno.getId() == id);

        String sql = "DELETE FROM EntradaAluno WHERE id = ?";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.executeUpdate();
                entradasAlunos.clear();
                recuperarDadosEntradaAluno();
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public EntradaAluno buscarEntradaAluno(int id) {
        for (EntradaAluno entradaAluno : entradasAlunos) {
            if (entradaAluno.getId() == id) {
                return entradaAluno;
            }
        }
        return null;
    }

    public ArrayList<EntradaAluno> mostrarEntradasAlunos() {
        return new ArrayList<>(entradasAlunos);
    }
}
