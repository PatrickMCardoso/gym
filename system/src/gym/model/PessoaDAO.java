package gym.model;

import gym.controller.SQLConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PessoaDAO {

    private ArrayList<Pessoa> pessoas;

    public PessoaDAO() {
        this.pessoas = new ArrayList<>();
    }

    public void recuperarDadosPessoa() {
        String sql = "SELECT * FROM Pessoa";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    char sexo = rs.getString("sexo").charAt(0);
                    LocalDate nascimento = rs.getDate("nascimento").toLocalDate();
                    String login = rs.getString("login");
                    String senha = rs.getString("senha");
                    String tipoUsuario = rs.getString("tipoUsuario");
                    LocalDate dataCriacao = rs.getDate("dataCriacao").toLocalDate();
                    LocalDate dataModificacao = rs.getDate("dataModificacao").toLocalDate();
                    Pessoa pessoa = new Pessoa(id, nome, sexo, nascimento, login, senha, tipoUsuario, dataCriacao, dataModificacao);
                    pessoas.add(pessoa);
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public boolean checarPessoaExisteBanco(int id) {
        String sql = "SELECT * FROM Pessoa WHERE id = ?";
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

    public void adicionarPessoasExemplo() {
        if (!checarPessoaExisteBanco(1)) {
            LocalDate dataAtual = LocalDate.now();

            Pessoa pessoa1 = new Pessoa(1, "Eduardo", 'M', LocalDate.of(1990, 5, 15), "eduardo@g.com", "eduardo123", "Admin", dataAtual, dataAtual);
            Pessoa pessoa2 = new Pessoa(2, "Patrick Machado Cardoso", 'M', LocalDate.of(2004, 4, 12), "patrick@g.com", "patrick123", "Professor", dataAtual, dataAtual);
            Pessoa pessoa3 = new Pessoa(3, "Ruan Emanuell", 'M', LocalDate.of(2004, 3, 10), "ruan@g,com", "ruan123", "Aluno", dataAtual, dataAtual);

            adicionarPessoa(pessoa1, dataAtual);
            adicionarPessoa(pessoa2, dataAtual);
            adicionarPessoa(pessoa3, dataAtual);
        }
    }

    public void adicionarPessoa(Pessoa pessoa, LocalDate dataAtual) {
        String sql = "INSERT INTO Pessoa (nome, sexo, nascimento, login, senha, tipoUsuario, dataCriacao, dataModificacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, pessoa.getNome());
                stmt.setString(2, String.valueOf(pessoa.getSexo()));
                stmt.setDate(3, Date.valueOf(pessoa.getNascimento()));
                stmt.setString(4, pessoa.getLogin());
                stmt.setString(5, pessoa.getSenha());
                stmt.setString(6, pessoa.getTipoUsuario());
                stmt.setDate(7, Date.valueOf(pessoa.getDataCriacao()));
                stmt.setDate(8, Date.valueOf(pessoa.getDataModificacao()));

                int id = pessoa.getId();

                if (!checarPessoaExisteBanco(id)) {
                    stmt.executeUpdate();
                    pessoas.clear();
                    recuperarDadosPessoa();
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public void alterarPessoa(int id, Pessoa novaPessoa, LocalDate dataAtual) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId() == id) {
                pessoa.setNome(novaPessoa.getNome());
                pessoa.setSexo(novaPessoa.getSexo());
                pessoa.setNascimento(novaPessoa.getNascimento());
                pessoa.setLogin(novaPessoa.getLogin());
                pessoa.setSenha(novaPessoa.getSenha());
                pessoa.setTipoUsuario(novaPessoa.getTipoUsuario());
                pessoa.setDataModificacao(dataAtual);

                String sql = "UPDATE Pessoa SET nome = ?, sexo = ?, nascimento = ?, login = ?, senha = ?, tipoUsuario = ?, dataModificacao = ? WHERE id = ?";
                try {
                    try (Connection conn = SQLConnection.getConnection()) {
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setString(1, pessoa.getNome());
                        stmt.setString(2, String.valueOf(pessoa.getSexo()));
                        stmt.setDate(3, Date.valueOf(pessoa.getNascimento()));
                        stmt.setString(4, pessoa.getLogin());
                        stmt.setString(5, pessoa.getSenha());
                        stmt.setString(6, pessoa.getTipoUsuario());
                        stmt.setDate(7, Date.valueOf(pessoa.getDataModificacao()));
                        stmt.setInt(8, pessoa.getId());
                        stmt.executeUpdate();
                        pessoas.clear();
                        recuperarDadosPessoa();
                    }
                } catch (SQLException e) {
                    System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
                }
                break;
            }
        }
    }

    public void removerPessoa(int id) {
        pessoas.removeIf(pessoa -> pessoa.getId() == id);

        String sql = "DELETE FROM Pessoa WHERE id = ?";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.executeUpdate();
                pessoas.clear();
                recuperarDadosPessoa();
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public Pessoa buscarPessoa(int id) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }

    public ArrayList<Pessoa> mostrarPessoas() {
        return new ArrayList<>(pessoas);
    }
    
    public ArrayList<Pessoa> buscarPessoasPorTipo(String tipoUsuario) {
        ArrayList<Pessoa> pessoasPorTipo = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getTipoUsuario().equals(tipoUsuario)) {
                pessoasPorTipo.add(pessoa);
            }
        }
        return pessoasPorTipo;
    }
    
    public boolean checarTipoPessoa(String tipoUsuario, Pessoa pessoa) {
        return pessoa.getTipoUsuario().equals(tipoUsuario);
    }
}
