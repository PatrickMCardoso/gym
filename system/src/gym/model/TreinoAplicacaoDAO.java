package gym.model;

import gym.controller.SQLConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TreinoAplicacaoDAO {
    private ArrayList<TreinoAplicacao> treinoAplicacoes;
    private PessoaDAO pessoaDAO;
    private TreinoDAO treinoDAO;
    private ExercicioDAO exercicioDAO;
    private ExercicioAplicacaoDAO exercicioAplicacaoDAO;
    private DivisaoTreinoDAO divisaoTreinoDAO;
    private DivisaoTreinoMusculoDAO divisaoTreinoMusculoDAO;

    public TreinoAplicacaoDAO(PessoaDAO pessoaDAO, TreinoDAO treinoDAO, ExercicioDAO exercicioDAO, ExercicioAplicacaoDAO exercicioAplicacaoDAO, DivisaoTreinoDAO divisaoTreinoDAO, DivisaoTreinoMusculoDAO divisaoTreinoMusculoDAO) {
        this.treinoAplicacoes = new ArrayList<>();
        this.pessoaDAO = pessoaDAO;
        this.treinoDAO = treinoDAO;
        this.exercicioDAO = exercicioDAO;
        this.exercicioAplicacaoDAO = exercicioAplicacaoDAO;
        this.divisaoTreinoDAO = divisaoTreinoDAO;
        this.divisaoTreinoMusculoDAO = divisaoTreinoMusculoDAO;
    }

    public void recuperarDadosTreinoAplicacao() {
        String sql = "SELECT * FROM TreinoAplicacao";
        try (Connection conn = SQLConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                int usuarioId = rs.getInt("usuarioId");
                int treinoId = rs.getInt("treinoId");
                int exercicioId = rs.getInt("exercicioId");
                int exercicioAplicacaoId = rs.getInt("exercicioAplicacaoId");
                int divisaoTreinoId = rs.getInt("divisaoTreinoId");
                int divisaoTreinoMusculoId = rs.getInt("divisaoTreinoMusculoId");
                LocalDate dataCriacao = rs.getDate("dataCriacao").toLocalDate();
                LocalDate dataModificacao = rs.getDate("dataModificacao").toLocalDate();

                Treino treino = treinoDAO.buscarTreino(treinoId);
                Exercicio exercicio = exercicioDAO.buscarExercicio(exercicioId);
                ExercicioAplicacao exercicioAplicacao = exercicioAplicacaoDAO.buscarExercicioAplicacao(exercicioAplicacaoId);
                DivisaoTreino divisaoTreino = divisaoTreinoDAO.buscarDivisaoTreino(divisaoTreinoId);
                DivisaoTreinoMusculo divisaoTreinoMusculo = divisaoTreinoMusculoDAO.buscarDivisaoTreinoMusculo(divisaoTreinoMusculoId);

                TreinoAplicacao treinoAplicacao = new TreinoAplicacao(id, usuarioId, treino, exercicio, exercicioAplicacao, divisaoTreino, divisaoTreinoMusculo, dataCriacao, dataModificacao);
                treinoAplicacoes.add(treinoAplicacao);
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public boolean checarTreinoAplicacaoExisteBanco(int id) {
        String sql = "SELECT * FROM TreinoAplicacao WHERE id = ?";
        try (Connection conn = SQLConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
        return false;
    }

    public void adicionarTreinoAplicacao(TreinoAplicacao treinoAplicacao, LocalDate dataAtual) {
        String sql = "INSERT INTO TreinoAplicacao (usuarioId, treinoId, exercicioId, exercicioAplicacaoId, divisaoTreinoId, divisaoTreinoMusculoId, dataCriacao, dataModificacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = SQLConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, treinoAplicacao.getUsuarioId());
            stmt.setInt(2, treinoAplicacao.getTreino().getId());
            stmt.setInt(3, treinoAplicacao.getExercicio().getId());
            stmt.setInt(4, treinoAplicacao.getExercicioAplicacao().getId());
            stmt.setInt(5, treinoAplicacao.getDivisaoTreino().getId());
            stmt.setInt(6, treinoAplicacao.getDivisaoTreinoMusculo().getId());
            stmt.setDate(7, Date.valueOf(treinoAplicacao.getDataCriacao()));
            stmt.setDate(8, Date.valueOf(treinoAplicacao.getDataModificacao()));

            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    treinoAplicacao.setId(generatedKeys.getInt(1));
                }
            }

            treinoAplicacoes.add(treinoAplicacao);
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public void alterarTreinoAplicacao(int id, TreinoAplicacao novoTreinoAplicacao, LocalDate dataAtual) {
        for (TreinoAplicacao treinoAplicacao : treinoAplicacoes) {
            if (treinoAplicacao.getId() == id) {
                treinoAplicacao.setUsuarioId(novoTreinoAplicacao.getUsuarioId());
                treinoAplicacao.setTreino(novoTreinoAplicacao.getTreino());
                treinoAplicacao.setExercicio(novoTreinoAplicacao.getExercicio());
                treinoAplicacao.setExercicioAplicacao(novoTreinoAplicacao.getExercicioAplicacao());
                treinoAplicacao.setDivisaoTreino(novoTreinoAplicacao.getDivisaoTreino());
                treinoAplicacao.setDivisaoTreinoMusculo(novoTreinoAplicacao.getDivisaoTreinoMusculo());
                treinoAplicacao.setDataModificacao(dataAtual);

                String sql = "UPDATE TreinoAplicacao SET usuarioId = ?, treinoId = ?, exercicioId = ?, exercicioAplicacaoId = ?, divisaoTreinoId = ?, divisaoTreinoMusculoId = ?, dataModificacao = ? WHERE id = ?";
                try (Connection conn = SQLConnection.getConnection()) {
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, treinoAplicacao.getUsuarioId());
                    stmt.setInt(2, treinoAplicacao.getTreino().getId());
                    stmt.setInt(3, treinoAplicacao.getExercicio().getId());
                    stmt.setInt(4, treinoAplicacao.getExercicioAplicacao().getId());
                    stmt.setInt(5, treinoAplicacao.getDivisaoTreino().getId());
                    stmt.setInt(6, treinoAplicacao.getDivisaoTreinoMusculo().getId());
                    stmt.setDate(7, Date.valueOf(dataAtual));
                    stmt.setInt(8, treinoAplicacao.getId());

                    stmt.executeUpdate();
                    treinoAplicacoes.clear();
                    recuperarDadosTreinoAplicacao();
                } catch (SQLException e) {
                    System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
                }
                break;
            }
        }
    }

    public void removerTreinoAplicacao(int id) {
        treinoAplicacoes.removeIf(treinoAplicacao -> treinoAplicacao.getId() == id);

        String sql = "DELETE FROM TreinoAplicacao WHERE id = ?";
        try (Connection conn = SQLConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            treinoAplicacoes.clear();
            recuperarDadosTreinoAplicacao();
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public TreinoAplicacao buscarTreinoAplicacao(int id) {
        for (TreinoAplicacao treinoAplicacao : treinoAplicacoes) {
            if (treinoAplicacao.getId() == id) {
                return treinoAplicacao;
            }
        }
        return null;
    }

    public ArrayList<TreinoAplicacao> listarTodos() {
        return new ArrayList<>(treinoAplicacoes);
    }

    public ArrayList<TreinoAplicacao> listarTodosPorUsuario(int usuarioId) {
        ArrayList<TreinoAplicacao> treinoAplicacoesUsuario = new ArrayList<>();
        for (TreinoAplicacao treinoAplicacao : treinoAplicacoes) {
            if (treinoAplicacao.getUsuarioId() == usuarioId) {
                treinoAplicacoesUsuario.add(treinoAplicacao);
            }
        }
        return treinoAplicacoesUsuario;
    }
}
