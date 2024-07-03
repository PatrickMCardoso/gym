package gym.model;

import gym.controller.SQLConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ExercicioDAO {

    private ArrayList<Exercicio> exercicios;

    public ExercicioDAO() {
        this.exercicios = new ArrayList<>();
    }

    public void recuperarDadosExercicio() {
        String sql = "SELECT * FROM Exercicio";
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
                    Exercicio exercicio = new Exercicio(id, nome, descricao, dataCriacao, dataModificacao);
                    exercicios.add(exercicio);
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public boolean checarExercicioExisteBanco(int id) {
        String sql = "SELECT * FROM Exercicio WHERE id = ?";
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

    public void adicionarExercicioExemplos() {
        if (!checarExercicioExisteBanco(1)) {
            LocalDate dataAtual = LocalDate.now();

            Exercicio[] exerciciosExemplo = {
                // PEITO
                new Exercicio(1, "Supino Reto", "Deitado em um banco, empurre uma barra para cima, trabalhando o peitoral maior.", dataAtual, dataAtual),
                new Exercicio(2, "Crucifixo com Halteres", "Deitado em um banco, abra os bracos com halteres, estimulando os musculos do peito.", dataAtual, dataAtual),
                new Exercicio(3, "Flexoes", "No chao, empurre o corpo para cima, fortalecendo o peito e os triceps.", dataAtual, dataAtual),
                new Exercicio(4, "Cross Over", "Na maquina, puxe as alcas cruzadas para frente do peito.", dataAtual, dataAtual),
                // COSTAS / LOMBAR
                new Exercicio(5, "Barra Fixa", "Pendurado em uma barra, puxe o corpo para cima, fortalecendo as costas e os bracos.", dataAtual, dataAtual),
                new Exercicio(6, "Remada Curvada", "Com halteres ou barra, incline o tronco para frente e puxe os pesos em direcao ao abdomen.", dataAtual, dataAtual),
                new Exercicio(7, "Hiperextensao", "Deitado de brucos em um banco inclinado, levante o tronco, fortalecendo a regiao lombar.", dataAtual, dataAtual),
                new Exercicio(8, "Pulldown", "Sentado em uma maquina, puxe a barra para baixo em direcao ao peito, trabalhando as costas e os bracos.", dataAtual, dataAtual),
                // OMBRO / TRAPEZIO
                new Exercicio(9, "Desenvolvimento Arnold", "Sentado, com halteres, comece com as palmas voltadas para voce. A medida que voce levanta os halteres, gire os pulsos para que as palmas fiquem voltadas para a frente no final do movimento.", dataAtual, dataAtual),
                new Exercicio(10, "Elevacao Lateral", "Com halteres, levante os bracos para os lados, trabalhando os deltoides.", dataAtual, dataAtual),
                new Exercicio(11, "Encolhimento de Ombros", "Com halteres ou barra, eleve os ombros, fortalecendo os trapezios.", dataAtual, dataAtual),
                new Exercicio(12, "Elevacao Frontal", "Com halteres ou barra, levante os bracos a frente, estimulando os deltoides anteriores.", dataAtual, dataAtual),
                // BICEPS / ANTEBRACO
                new Exercicio(13, "Rosca Direta", "Com halteres ou barra, dobre os bracos para levantar o peso, trabalhando os biceps.", dataAtual, dataAtual),
                new Exercicio(14, "Rosca Martelo", "Com halteres, levante os pesos mantendo os punhos neutros, estimulando os biceps e antebracos.", dataAtual, dataAtual),
                new Exercicio(15, "Rosca Concentrada", "Sentado, dobre o braco em um banco e levante o peso, isolando o biceps.", dataAtual, dataAtual),
                new Exercicio(16, "Flexao de Punhos", "Com halteres, flexione os pulsos para cima e para baixo, fortalecendo os antebracos.", dataAtual, dataAtual),
                // TRICEPS
                new Exercicio(17, "Triceps Pulley", "Em uma maquina, puxe uma corda para baixo, estendendo os bracos e trabalhando os triceps.", dataAtual, dataAtual),
                new Exercicio(18, "Triceps Frances", "Com halteres ou barra, abaixe o peso atras da cabeca, estendendo os bracos para cima.", dataAtual, dataAtual),
                new Exercicio(19, "Fundos", "Com as maos em um banco e os pes no chao, abaixe o corpo flexionando os bracos, trabalhando os triceps.", dataAtual, dataAtual),
                new Exercicio(20, "Extensao de Triceps", "Com halteres, estenda os bracos para cima e para tras, focando nos triceps.", dataAtual, dataAtual),
                // PANTURRILHA          
                new Exercicio(21, "Elevacao de Panturrilha em Pe", "Em pe, levante o corpo sobre os dedos dos pes, trabalhando as panturrilhas.", dataAtual, dataAtual),
                new Exercicio(22, "Elevacao de Panturrilha Sentado", "Sentado em uma maquina, levante os calcanhares, fortalecendo as panturrilhas.", dataAtual, dataAtual),
                new Exercicio(23, "Elevacao de Panturrilha Unilateral", "Em pe, levante uma perna e eleve o calcanhar, trabalhando uma panturrilha de cada vez.", dataAtual, dataAtual),
                new Exercicio(24, "Salto na Panturrilha", "Pule e levante os calcanhares ao mesmo tempo, fortalecendo as panturrilhas com o impacto.", dataAtual, dataAtual),
                // GLUTEO
                new Exercicio(25, "Agachamento", "Com ou sem pesos, flexione os joelhos como se fosse sentar, trabalhando os gluteos e pernas.", dataAtual, dataAtual),
                new Exercicio(26, "Elevacao Pelvica", "Deitado no chao, levante os quadris, contraindo os gluteos.", dataAtual, dataAtual),
                new Exercicio(27, "Afundo", "De passos largos para frente e flexione os joelhos, alternando as pernas para trabalhar os gluteos.", dataAtual, dataAtual),
                new Exercicio(28, "Gluteo Kickback", "Com uma perna para tras, levante-a para tras, contraindo os gluteos.", dataAtual, dataAtual),
                // COXA
                new Exercicio(29, "Agachamento Livre", "Com barra ou apenas com o peso do corpo, flexione os joelhos, trabalhando as coxas.", dataAtual, dataAtual),
                new Exercicio(30, "Leg Press", "Sentado em uma maquina, empurre os pesos com as pernas, fortalecendo as coxas.", dataAtual, dataAtual),
                new Exercicio(31, "Cadeira Extensora", "Sentado em uma maquina, estenda as pernas, trabalhando os quadriceps.", dataAtual, dataAtual),
                new Exercicio(32, "Stiff", "Com halteres ou barra, incline o tronco para frente e levante o peso, estimulando os musculos das coxas e gluteos.", dataAtual, dataAtual),
                // ABDOMEN
                new Exercicio(33, "Prancha", "Com os antebracos e ponta dos pes no chao, mantenha o corpo reto, fortalecendo o core.", dataAtual, dataAtual),
                new Exercicio(34, "Crunch", "Deitado no chao, levante o tronco em direcao aos joelhos, trabalhando os musculos abdominais.", dataAtual, dataAtual),
                new Exercicio(35, "Russian Twist", "Sentado no chao, gire o tronco de um lado para o outro, estimulando os obliquos.", dataAtual, dataAtual),
                new Exercicio(36, "Abdominal Inferior", "Deitado, levante as pernas para cima e para baixo, focando na parte inferior do abdomen.", dataAtual, dataAtual)
            };

            for (Exercicio exercicio : exerciciosExemplo) {
                adicionarExercicio(exercicio, dataAtual);
            }
        }
    }

    public void adicionarExercicio(Exercicio exercicio, LocalDate dataAtual) {
        String sql = "INSERT INTO Exercicio (nome, descricao, dataCriacao, dataModificacao) VALUES (?, ?, ?, ?)";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, exercicio.getNome());
                stmt.setString(2, exercicio.getDescricao());
                stmt.setDate(3, Date.valueOf(exercicio.getDataCriacao()));
                stmt.setDate(4, Date.valueOf(exercicio.getDataModificacao()));

                int id = exercicio.getId();

                if (!checarExercicioExisteBanco(id)) {
                    stmt.executeUpdate();
                    exercicios.clear();
                    recuperarDadosExercicio();
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public void alterarExercicio(int id, Exercicio novoExercicio, LocalDate dataAtual) {
        for (Exercicio exercicio : exercicios) {
            if (exercicio.getId() == id) {
                exercicio.setNome(novoExercicio.getNome());
                exercicio.setDescricao(novoExercicio.getDescricao());
                exercicio.setDataModificacao(dataAtual);

                String sql = "UPDATE Exercicio SET nome = ?, descricao = ?, dataModificacao = ? WHERE id = ?";
                try {
                    try (Connection conn = SQLConnection.getConnection()) {
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setString(1, exercicio.getNome());
                        stmt.setString(2, exercicio.getDescricao());
                        stmt.setDate(3, Date.valueOf(exercicio.getDataModificacao()));
                        stmt.setInt(4, exercicio.getId());
                        stmt.executeUpdate();
                        exercicios.clear();
                        recuperarDadosExercicio();
                    }
                } catch (SQLException e) {
                    System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
                }
                break;
            }
        }
    }

    public void removerExercicio(int id) {
        exercicios.removeIf(exercicio -> exercicio.getId() == id);

        String sql = "DELETE FROM Exercicio WHERE id = ?";
        try {
            try (Connection conn = SQLConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.executeUpdate();
                exercicios.clear();
                recuperarDadosExercicio();
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao executar a funcao SQL: " + e.getMessage());
        }
    }

    public Exercicio buscarExercicio(int id) {
        for (Exercicio exercicio : exercicios) {
            if (exercicio.getId() == id) {
                return exercicio;
            }
        }
        return null;
    }

    public ArrayList<Exercicio> mostrarExercicios() {
        return new ArrayList<>(exercicios);
    }
    
    public Exercicio buscarExercicioPorNome(String nome) {
        String sql = "SELECT * FROM Exercicio WHERE nome = ?";
        try (Connection conn = SQLConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                LocalDate dataCriacao = rs.getDate("dataCriacao").toLocalDate();
                LocalDate dataModificacao = rs.getDate("dataModificacao").toLocalDate();

                return new Exercicio(id, nome, descricao, dataCriacao, dataModificacao);
            }
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao buscar o exercicio por nome: " + e.getMessage());
        }
        return null;
    }
}
