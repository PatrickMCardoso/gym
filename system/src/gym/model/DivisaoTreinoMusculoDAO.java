package gym.model;

import gym.controller.SQLConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DivisaoTreinoMusculoDAO {

    private ArrayList<DivisaoTreinoMusculo> divisoes;
    private DivisaoTreinoDAO divisaoTreinoDAO;

    public DivisaoTreinoMusculoDAO(DivisaoTreinoDAO divisaoTreinoDAO) {
        this.divisoes = new ArrayList<>();
        this.divisaoTreinoDAO = divisaoTreinoDAO;
    }

    public void recuperarDadosDivisaoTreinoMusculo() {
        String sql = "SELECT * FROM DivisaoTreinoMusculo";
        try (Connection conn = SQLConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int alunoId = rs.getInt("alunoId");
                int divisaoTreinoId = rs.getInt("divisaoTreinoId");
                String tiposExercicios = rs.getString("tiposExercicios");
                LocalDate dataCriacao = rs.getDate("dataCriacao").toLocalDate();
                LocalDate dataModificacao = rs.getDate("dataModificacao").toLocalDate();

                DivisaoTreino divisaoTreino = divisaoTreinoDAO.buscarDivisaoTreino(divisaoTreinoId);
                if (divisaoTreino != null) {
                    DivisaoTreinoMusculo divisao = new DivisaoTreinoMusculo(id, alunoId, divisaoTreino, dataCriacao, dataModificacao, tiposExercicios.split(","));
                    divisoes.add(divisao);
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public void adicionarDivisaoTreinoMusculo(DivisaoTreinoMusculo divisaoTreinoMusculo, LocalDate dataAtual) {
        String sql = "INSERT INTO DivisaoTreinoMusculo (alunoId, divisaoTreinoId, tiposExercicios, dataCriacao, dataModificacao) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = SQLConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, divisaoTreinoMusculo.getAlunoId());
            stmt.setInt(2, divisaoTreinoMusculo.getDivisaoTreino().getId());
            stmt.setString(3, String.join(",", divisaoTreinoMusculo.getTiposExercicios()));
            stmt.setDate(4, Date.valueOf(dataAtual));
            stmt.setDate(5, Date.valueOf(dataAtual));
            stmt.executeUpdate();

            divisoes.clear();
            recuperarDadosDivisaoTreinoMusculo();
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public DivisaoTreinoMusculo buscarDivisaoTreinoMusculo(int id) {
        for (DivisaoTreinoMusculo divisao : divisoes) {
            if (divisao.getId() == id) {
                return divisao;
            }
        }
        return null;
    }

    public ArrayList<DivisaoTreinoMusculo> mostrarDivisoesTreinoMusculo() {
        return new ArrayList<>(divisoes);
    }

    public void alterarDivisaoTreinoMusculo(int id, DivisaoTreinoMusculo novaDivisaoTreinoMusculo, LocalDate dataAtual) {
        String sql = "UPDATE DivisaoTreinoMusculo SET alunoId = ?, divisaoTreinoId = ?, tiposExercicios = ?, dataModificacao = ? WHERE id = ?";
        try (Connection conn = SQLConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, novaDivisaoTreinoMusculo.getAlunoId());
            stmt.setInt(2, novaDivisaoTreinoMusculo.getDivisaoTreino().getId());
            stmt.setString(3, String.join(",", novaDivisaoTreinoMusculo.getTiposExercicios()));
            stmt.setDate(4, Date.valueOf(dataAtual));
            stmt.setInt(5, id);
            stmt.executeUpdate();

            divisoes.clear();
            recuperarDadosDivisaoTreinoMusculo();
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public void removerDivisaoTreinoMusculo(int id) {
        divisoes.removeIf(divisao -> divisao.getId() == id);

        String sql = "DELETE FROM DivisaoTreinoMusculo WHERE id = ?";
        try (Connection conn = SQLConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            divisoes.clear();
            recuperarDadosDivisaoTreinoMusculo();
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public ArrayList<DivisaoTreinoMusculo> buscarDivisoesTreinoMusculoPorAluno(int alunoId) {
        ArrayList<DivisaoTreinoMusculo> resultado = new ArrayList<>();
        for (DivisaoTreinoMusculo divisao : divisoes) {
            if (divisao.getAlunoId() == alunoId) {
                resultado.add(divisao);
            }
        }
        return resultado;
    }

    public DivisaoTreinoMusculo buscarPrimeiraDivisaoTreinoMusculoPorAluno(int alunoId) {
        for (DivisaoTreinoMusculo divisao : divisoes) {
            if (divisao.getAlunoId() == alunoId) {
                return divisao;
            }
        }
        return null;
    }

    public DivisaoTreinoMusculo buscarDivisaoTreinoMusculoPorTreinoAplicacaoId(int treinoAplicacaoId) {
        for (DivisaoTreinoMusculo divisao : divisoes) {
            if (divisao.getTreinoAplicacaoId() == treinoAplicacaoId) {
                return divisao;
            }
        }
        return null;
    }
}
