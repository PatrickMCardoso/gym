package gym.model;

import gym.controller.SQLConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class ExercicioAplicacaoDAO {

    private ArrayList<ExercicioAplicacao> exerciciosAplicacao;

    public ExercicioAplicacaoDAO() {
        this.exerciciosAplicacao = new ArrayList<>();
    }

    public void recuperarDadosExercicioAplicacao() {
        String sql = "SELECT * FROM ExercicioAplicacao";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    int idExercicio = rs.getInt("idExercicio");
                    String descricao = rs.getString("descricao");
                    LocalDate dataCriacao = rs.getDate("dataCriacao").toLocalDate();
                    LocalDate dataModificacao = rs.getDate("dataModificacao").toLocalDate();
                    ExercicioAplicacao exercicioAplicacao = new ExercicioAplicacao(id, idExercicio, descricao, dataCriacao, dataModificacao);
                    exerciciosAplicacao.add(exercicioAplicacao);
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public boolean checarExercicioAplicacaoExisteBanco(int id) {
        String sql = "SELECT * FROM ExercicioAplicacao WHERE id = ?";
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

    public void adicionarExercicioAplicacaoExemplos() {
        Random random = new Random();
        String[] descricoes = {"4x12", "4x10", "12 reps com rest pause", "5x5 com carga maxima", "4xMAX"};

        for (int i = 1; i <= 36; i++) {
            int idExercicio = i;
            String descricao = descricoes[random.nextInt(descricoes.length)];

            adicionarExercicioAplicacao(idExercicio, descricao, LocalDate.now());
        }
    }

    public void adicionarExercicioAplicacao(int idExercicio, String descricao, LocalDate dataAtual) {
        String sql = "INSERT INTO ExercicioAplicacao (idExercicio, descricao, dataCriacao, dataModificacao) VALUES (?, ?, ?, ?)";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, idExercicio);
                stmt.setString(2, descricao);
                stmt.setDate(3, Date.valueOf(dataAtual));
                stmt.setDate(4, Date.valueOf(dataAtual));

                if (!checarExercicioAplicacaoExisteBanco(idExercicio)) {
                    stmt.executeUpdate();
                    exerciciosAplicacao.clear();
                    recuperarDadosExercicioAplicacao();
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public void alterarExercicioAplicacao(int id, ExercicioAplicacao novoExercicioAplicacao, LocalDate dataAtual) {
        for (ExercicioAplicacao exercicioAplicacao : exerciciosAplicacao) {
            if (exercicioAplicacao.getId() == id) {
                exercicioAplicacao.setDescricao(novoExercicioAplicacao.getDescricao());
                exercicioAplicacao.setDataModificacao(dataAtual);

                String sql = "UPDATE ExercicioAplicacao SET descricao = ?, dataModificacao = ? WHERE id = ?";
                try {
                    try (Connection conn = SQLConnection.getConnection()) {
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setString(1, exercicioAplicacao.getDescricao());
                        stmt.setDate(2, Date.valueOf(exercicioAplicacao.getDataModificacao()));
                        stmt.setInt(3, exercicioAplicacao.getId());
                        stmt.executeUpdate();
                        exerciciosAplicacao.clear();
                        recuperarDadosExercicioAplicacao();
                    }
                } catch (SQLException e) {
                    System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
                }
                break;
            }
        }
    }

    public void removerExercicioAplicacao(int id) {
        exerciciosAplicacao.removeIf(exercicioAplicacao -> exercicioAplicacao.getId() == id);

        String sql = "DELETE FROM ExercicioAplicacao WHERE id = ?";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.executeUpdate();
                exerciciosAplicacao.clear();
                recuperarDadosExercicioAplicacao();
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public ExercicioAplicacao buscarExercicioAplicacao(int id) {
        for (ExercicioAplicacao exercicioAplicacao : exerciciosAplicacao) {
            if (exercicioAplicacao.getId() == id) {
                return exercicioAplicacao;
            }
        }
        return null;
    }

    public ArrayList<ExercicioAplicacao> mostrarExerciciosAplicacao() {
        return new ArrayList<>(exerciciosAplicacao);
    }
}
