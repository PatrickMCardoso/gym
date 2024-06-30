package gym.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "123123";
    private static final String DATABASE_NAME = "gym";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL + DATABASE_NAME, USER, PASSWORD);
    }

    public static void criarTabelas() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate("USE " + DATABASE_NAME);
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Academia ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "nome VARCHAR(255) NOT NULL,"
                    + "endereco VARCHAR(255) NOT NULL,"
                    + "dataCriacao DATE NOT NULL,"
                    + "dataModificacao DATE NOT NULL)");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Pessoa ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "nome VARCHAR(255) NOT NULL,"
                    + "sexo CHAR(1) NOT NULL,"
                    + "nascimento DATE NOT NULL,"
                    + "login VARCHAR(255) NOT NULL,"
                    + "senha VARCHAR(255) NOT NULL,"
                    + "tipoUsuario VARCHAR(50) NOT NULL,"
                    + "dataCriacao DATE NOT NULL,"
                    + "dataModificacao DATE NOT NULL)");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Exercicio ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "nome VARCHAR(255) NOT NULL,"
                    + "descricao TEXT NOT NULL,"
                    + "dataCriacao DATE NOT NULL,"
                    + "dataModificacao DATE NOT NULL)");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ExercicioAplicacao ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "idExercicio INT NOT NULL,"
                    + "descricao TEXT NOT NULL,"
                    + "dataCriacao DATE NOT NULL,"
                    + "dataModificacao DATE NOT NULL,"
                    + "FOREIGN KEY (idExercicio) REFERENCES Exercicio(id))");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS DivisaoTreino ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "nome VARCHAR(255) NOT NULL,"
                    + "descricao TEXT NOT NULL,"
                    + "dataCriacao DATE NOT NULL,"
                    + "dataModificacao DATE NOT NULL)");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS DivisaoTreinoMusculo ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "alunoId INT NOT NULL,"
                    + "divisaoTreinoId INT NOT NULL,"
                    + "dataCriacao DATE NOT NULL,"
                    + "dataModificacao DATE NOT NULL,"
                    + "tiposExercicios TEXT NOT NULL,"
                    + "treinoAplicacaoId INT NOT NULL DEFAULT -1,"
                    + "FOREIGN KEY (divisaoTreinoId) REFERENCES DivisaoTreino(id))");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Treino ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "pessoaId INT NOT NULL,"
                    + "objetivo VARCHAR(255) NOT NULL,"
                    + "dataInicio DATE NOT NULL,"
                    + "dataTermino DATE NOT NULL,"
                    + "divisaoTreinoId INT NOT NULL,"
                    + "dataCriacao DATE NOT NULL,"
                    + "dataModificacao DATE NOT NULL,"
                    + "FOREIGN KEY (pessoaId) REFERENCES Pessoa(id),"
                    + "FOREIGN KEY (divisaoTreinoId) REFERENCES DivisaoTreino(id))");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Treino ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "pessoaId INT NOT NULL,"
                    + "objetivo VARCHAR(255) NOT NULL,"
                    + "dataInicio DATE NOT NULL,"
                    + "dataTermino DATE NOT NULL,"
                    + "divisaoTreinoId INT NOT NULL,"
                    + "dataCriacao DATE NOT NULL,"
                    + "dataModificacao DATE NOT NULL,"
                    + "FOREIGN KEY (pessoaId) REFERENCES Pessoa(id),"
                    + "FOREIGN KEY (divisaoTreinoId) REFERENCES DivisaoTreino(id))");

            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS TreinoAplicacao ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "usuarioId INT NOT NULL,"
                    + "treinoId INT NOT NULL,"
                    + "exercicioId INT NOT NULL,"
                    + "exercicioAplicacaoId INT NOT NULL,"
                    + "divisaoTreinoId INT NOT NULL,"
                    + "divisaoTreinoMusculoId INT NOT NULL,"
                    + "dataCriacao DATE NOT NULL,"
                    + "dataModificacao DATE NOT NULL,"
                    + "FOREIGN KEY (usuarioId) REFERENCES Pessoa(id),"
                    + "FOREIGN KEY (treinoId) REFERENCES Treino(id),"
                    + "FOREIGN KEY (exercicioId) REFERENCES Exercicio(id),"
                    + "FOREIGN KEY (exercicioAplicacaoId) REFERENCES ExercicioAplicacao(id),"
                    + "FOREIGN KEY (divisaoTreinoId) REFERENCES DivisaoTreino(id),"
                    + "FOREIGN KEY (divisaoTreinoMusculoId) REFERENCES DivisaoTreinoMusculo(id))");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS AvaliacaoFisica ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "pessoaId INT NOT NULL,"
                    + "ultimoTreinoId INT NOT NULL,"
                    + "peso DOUBLE NOT NULL,"
                    + "altura DOUBLE NOT NULL,"
                    + "imc DOUBLE NOT NULL,"
                    + "indiceSatisfacao INT NOT NULL,"
                    + "dataCriacao DATE NOT NULL,"
                    + "dataModificacao DATE NOT NULL,"
                    + "FOREIGN KEY (pessoaId) REFERENCES Pessoa(id),"
                    + "FOREIGN KEY (ultimoTreinoId) REFERENCES Treino(id))");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Mensalidade ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "descricao VARCHAR(255) NOT NULL,"
                    + "valor DOUBLE NOT NULL,"
                    + "dataInicio DATE NOT NULL,"
                    + "dataFim DATE NOT NULL,"
                    + "termino INT NOT NULL,"
                    + "dataCriacao DATE NOT NULL,"
                    + "dataModificacao DATE NOT NULL)");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS MensalidadeAluno ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "idAluno INT NOT NULL,"
                    + "idMensalidade INT NOT NULL,"
                    + "dataVencimento DATE NOT NULL,"
                    + "dataPagamento DATE,"
                    + "valorPago DOUBLE NOT NULL,"
                    + "modalidade VARCHAR(255) NOT NULL,"
                    + "dataCriacao DATE NOT NULL,"
                    + "dataModificacao DATE NOT NULL,"
                    + "FOREIGN KEY (idAluno) REFERENCES Pessoa(id),"
                    + "FOREIGN KEY (idMensalidade) REFERENCES Mensalidade(id))");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS PagamentoRecorrente ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "idPessoa INT NOT NULL,"
                    + "idMensalidadeAluno INT NOT NULL,"
                    + "data DATE NOT NULL,"
                    + "cartaoDeCredito VARCHAR(255) NOT NULL,"
                    + "valor DOUBLE NOT NULL,"
                    + "dataDeInicio DATE NOT NULL,"
                    + "numeroDeMeses INT NOT NULL,"
                    + "dataCriacao DATE NOT NULL,"
                    + "dataModificacao DATE NOT NULL,"
                    + "FOREIGN KEY (idPessoa) REFERENCES Pessoa(id),"
                    + "FOREIGN KEY (idMensalidadeAluno) REFERENCES MensalidadeAluno(id))");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS EntradaAluno ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "data DATE NOT NULL,"
                    + "dataCriacao DATE NOT NULL,"
                    + "dataModificacao DATE NOT NULL)");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS MovimentacaoFinanceira ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "valor DOUBLE NOT NULL,"
                    + "tipo VARCHAR(255) NOT NULL,"
                    + "descricao TEXT,"
                    + "dataCriacao DATE NOT NULL,"
                    + "dataModificacao DATE NOT NULL)");

        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a função SQL: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Ocorreu um erro ao executar a função SQL: " + e.getMessage());
            }
        }
    }
}
