package gym.model;

import gym.controller.SQLConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TreinoDAO {

    private ArrayList<Treino> treinos;
    private PessoaDAO pessoaDAO;
    private DivisaoTreinoDAO divisaoTreinoDAO;

    public TreinoDAO(PessoaDAO pessoaDAO, DivisaoTreinoDAO divisaoTreinoDAO) {
        this.treinos = new ArrayList<>();
        this.pessoaDAO = pessoaDAO;
        this.divisaoTreinoDAO = divisaoTreinoDAO;
    }

    public void recuperarDadosTreino() {
        String sql = "SELECT * FROM Treino";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    int pessoaId = rs.getInt("pessoaId");
                    String objetivo = rs.getString("objetivo");
                    LocalDate dataInicio = rs.getDate("dataInicio").toLocalDate();
                    LocalDate dataTermino = rs.getDate("dataTermino").toLocalDate();
                    int divisaoTreinoId = rs.getInt("divisaoTreinoId");
                    LocalDate dataCriacao = rs.getDate("dataCriacao").toLocalDate();
                    LocalDate dataModificacao = rs.getDate("dataModificacao").toLocalDate();

                    Pessoa pessoa = pessoaDAO.buscarPessoa(pessoaId);
                    DivisaoTreino divisao = divisaoTreinoDAO.buscarDivisaoTreino(divisaoTreinoId);

                    Treino treino = new Treino(id, pessoa, objetivo, dataInicio, dataTermino, divisao, dataCriacao, dataModificacao);
                    treinos.add(treino);
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public boolean checarTreinoExisteBanco(int id) {
        String sql = "SELECT * FROM Treino WHERE id = ?";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                return rs.next();
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }

        return false;
    }

    public void adicionarTreinoExemplos() {
        if (!checarTreinoExisteBanco(1)) {
            LocalDate dataAtual = LocalDate.now();
            String[] objetivos = {"Definir abdômen", "Ganho de Massa Muscular", "Fortalecimento da Coluna", "Fortalecimento do Joelho"};

            Pessoa pessoa2 = pessoaDAO.buscarPessoa(2);
            Pessoa pessoa3 = pessoaDAO.buscarPessoa(3);
            DivisaoTreino divisao1 = divisaoTreinoDAO.buscarDivisaoTreino(1);
            DivisaoTreino divisao2 = divisaoTreinoDAO.buscarDivisaoTreino(2);

            if (pessoa2 != null && divisao1 != null) {
                Treino treino1 = new Treino(1, pessoa2, objetivos[0], LocalDate.now().minusDays(62), LocalDate.now().minusDays(32), divisao1, dataAtual, dataAtual);
                Treino treino2 = new Treino(2, pessoa3, objetivos[1], LocalDate.now().minusDays(32), LocalDate.now().minusDays(2), divisao2, dataAtual, dataAtual);
                adicionarTreino(treino1, dataAtual);
                adicionarTreino(treino2, dataAtual);
            }

            if (pessoa3 != null && divisao2 != null) {
                Treino treino3 = new Treino(3, pessoa3, objetivos[2], LocalDate.now().minusDays(62), LocalDate.now().minusDays(32), divisao2, dataAtual, dataAtual);
                Treino treino4 = new Treino(4, pessoa3, objetivos[3], LocalDate.now().minusDays(32), LocalDate.now().minusDays(2), divisao2, dataAtual, dataAtual);
                adicionarTreino(treino3, dataAtual);
                adicionarTreino(treino4, dataAtual);
            }
        }
    }

    public void adicionarTreino(Treino treino, LocalDate dataAtual) {
        String sql = "INSERT INTO Treino (pessoaId, objetivo, dataInicio, dataTermino, divisaoTreinoId, dataCriacao, dataModificacao) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, treino.getPessoa().getId());
                stmt.setString(2, treino.getObjetivo());
                stmt.setDate(3, Date.valueOf(treino.getDataInicio()));
                stmt.setDate(4, Date.valueOf(treino.getDataTermino()));
                stmt.setInt(5, treino.getDivisaoTreino().getId());
                stmt.setDate(6, Date.valueOf(dataAtual));
                stmt.setDate(7, Date.valueOf(dataAtual));

                stmt.executeUpdate();

                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        treino.setId(generatedKeys.getInt(1));
                    }
                }

                treinos.add(treino);
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public void alterarTreino(int id, Treino novoTreino, LocalDate dataAtual) {
        for (Treino treino : treinos) {
            if (treino.getId() == id) {
                treino.setPessoa(novoTreino.getPessoa());
                treino.setObjetivo(novoTreino.getObjetivo());
                treino.setDataInicio(novoTreino.getDataInicio());
                treino.setDataTermino(novoTreino.getDataTermino());
                treino.setDivisaoTreino(novoTreino.getDivisaoTreino());
                treino.setDataModificacao(dataAtual);

                String sql = "UPDATE Treino SET pessoaId = ?, objetivo = ?, dataInicio = ?, dataTermino = ?, divisaoTreinoId = ?, dataModificacao = ? WHERE id = ?";
                try {
                    try (Connection conn = SQLConnection.getConnection()) {
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setInt(1, treino.getPessoa().getId());
                        stmt.setString(2, treino.getObjetivo());
                        stmt.setDate(3, Date.valueOf(treino.getDataInicio()));
                        stmt.setDate(4, Date.valueOf(treino.getDataTermino()));
                        stmt.setInt(5, treino.getDivisaoTreino().getId());
                        stmt.setDate(6, Date.valueOf(dataAtual));
                        stmt.setInt(7, treino.getId());

                        stmt.executeUpdate();
                        treinos.clear();
                        recuperarDadosTreino();
                    }
                } catch (SQLException e) {
                    System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
                }
                break;
            }
        }
    }

    public void removerTreino(int id) {
        treinos.removeIf(treino -> treino.getId() == id);

        String sql = "DELETE FROM Treino WHERE id = ?";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.executeUpdate();
                treinos.clear();
                recuperarDadosTreino();
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public Treino buscarTreino(int id) {
        for (Treino treino : treinos) {
            if (treino.getId() == id) {
                return treino;
            }
        }
        return null;
    }

    public ArrayList<Treino> mostrarTodosTreinos() {
        return new ArrayList<>(treinos);
    }
    
    public ArrayList<Treino> mostrarTreinos() {
        return new ArrayList<>(treinos); 
    }
}
