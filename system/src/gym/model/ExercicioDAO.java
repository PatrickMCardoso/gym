package gym.model;

import java.time.LocalDate;

public class ExercicioDAO {

    private Exercicio[] exercicios;
    private int tamanho;
    private int geradorId;

    public ExercicioDAO() {
        this.exercicios = new Exercicio[10];
        this.tamanho = 0;
        this.geradorId = 0;
    }

    public void adicionarExercicioExemplos() {
        Exercicio[] exercicios = {
            // PEITO
            new Exercicio(1, "Supino Reto", "Deitado em um banco, empurre uma barra para cima, trabalhando o peitoral maior.", LocalDate.now(), LocalDate.now()),
            new Exercicio(2, "Crucifixo com Halteres", "Deitado em um banco, abra os bracos com halteres, estimulando os musculos do peito.", LocalDate.now(), LocalDate.now()),
            new Exercicio(3, "Flexoes", "No chao, empurre o corpo para cima, fortalecendo o peito e os triceps.", LocalDate.now(), LocalDate.now()),
            new Exercicio(4, "Cross Over", "Na maquina, puxe as alcas cruzadas para frente do peito.", LocalDate.now(), LocalDate.now()),
            // COSTAS / LOMBAR
            new Exercicio(5, "Barra Fixa", "Pendurado em uma barra, puxe o corpo para cima, fortalecendo as costas e os bracos.", LocalDate.now(), LocalDate.now()),
            new Exercicio(6, "Remada Curvada", "Com halteres ou barra, incline o tronco para frente e puxe os pesos em direcao ao abdomen.", LocalDate.now(), LocalDate.now()),
            new Exercicio(7, "Hiperextensao", "Deitado de brucos em um banco inclinado, levante o tronco, fortalecendo a regiao lombar.", LocalDate.now(), LocalDate.now()),
            new Exercicio(8, "Pulldown", "Sentado em uma maquina, puxe a barra para baixo em direcao ao peito, trabalhando as costas e os bracos.", LocalDate.now(), LocalDate.now()),
            // OMBRO / TRAPEZIO
            new Exercicio(9, "Desenvolvimento Arnold", "Sentado, com halteres, comece com as palmas voltadas para voce. A medida que voce levanta os halteres, gire os pulsos para que as palmas fiquem voltadas para a frente no final do movimento.", LocalDate.now(), LocalDate.now()),
            new Exercicio(10, "Elevacao Lateral", "Com halteres, levante os bracos para os lados, trabalhando os deltoides.", LocalDate.now(), LocalDate.now()),
            new Exercicio(11, "Encolhimento de Ombros", "Com halteres ou barra, eleve os ombros, fortalecendo os trapezios.", LocalDate.now(), LocalDate.now()),
            new Exercicio(12, "Elevacao Frontal", "Com halteres ou barra, levante os bracos a frente, estimulando os deltoides anteriores.", LocalDate.now(), LocalDate.now()),
            // BICEPS / ANTEBRACO
            new Exercicio(13, "Rosca Direta", "Com halteres ou barra, dobre os bracos para levantar o peso, trabalhando os biceps.", LocalDate.now(), LocalDate.now()),
            new Exercicio(14, "Rosca Martelo", "Com halteres, levante os pesos mantendo os punhos neutros, estimulando os biceps e antebracos.", LocalDate.now(), LocalDate.now()),
            new Exercicio(15, "Rosca Concentrada", "Sentado, dobre o braco em um banco e levante o peso, isolando o biceps.", LocalDate.now(), LocalDate.now()),
            new Exercicio(16, "Flexao de Punhos", "Com halteres, flexione os pulsos para cima e para baixo, fortalecendo os antebracos.", LocalDate.now(), LocalDate.now()),
            // TRICEPS
            new Exercicio(17, "Triceps Pulley", "Em uma maquina, puxe uma corda para baixo, estendendo os bracos e trabalhando os triceps.", LocalDate.now(), LocalDate.now()),
            new Exercicio(18, "Triceps Frances", "Com halteres ou barra, abaixe o peso atras da cabeca, estendendo os bracos para cima.", LocalDate.now(), LocalDate.now()),
            new Exercicio(19, "Fundos", "Com as maos em um banco e os pes no chao, abaixe o corpo flexionando os bracos, trabalhando os triceps.", LocalDate.now(), LocalDate.now()),
            new Exercicio(20, "Extensao de Triceps", "Com halteres, estenda os bracos para cima e para tras, focando nos triceps.", LocalDate.now(), LocalDate.now()),
            // PANTURRILHA          
            new Exercicio(21, "Elevacao de Panturrilha em Pe", "Em pe, levante o corpo sobre os dedos dos pes, trabalhando as panturrilhas.", LocalDate.now(), LocalDate.now()),
            new Exercicio(22, "Elevacao de Panturrilha Sentado", "Sentado em uma maquina, levante os calcanhares, fortalecendo as panturrilhas.", LocalDate.now(), LocalDate.now()),
            new Exercicio(23, "Elevacao de Panturrilha Unilateral", "Em pe, levante uma perna e eleve o calcanhar, trabalhando uma panturrilha de cada vez.", LocalDate.now(), LocalDate.now()),
            new Exercicio(24, "Salto na Panturrilha", "Pule e levante os calcanhares ao mesmo tempo, fortalecendo as panturrilhas com o impacto.", LocalDate.now(), LocalDate.now()),
            // GLUTEO
            new Exercicio(25, "Agachamento", "Com ou sem pesos, flexione os joelhos como se fosse sentar, trabalhando os gluteos e pernas.", LocalDate.now(), LocalDate.now()),
            new Exercicio(26, "Elevacao Pelvica", "Deitado no chao, levante os quadris, contraindo os gluteos.", LocalDate.now(), LocalDate.now()),
            new Exercicio(27, "Afundo", "De passos largos para frente e flexione os joelhos, alternando as pernas para trabalhar os gluteos.", LocalDate.now(), LocalDate.now()),
            new Exercicio(28, "Gluteo Kickback", "Com uma perna para tras, levante-a para tras, contraindo os gluteos.", LocalDate.now(), LocalDate.now()),
            // COXA
            new Exercicio(29, "Agachamento Livre", "Com barra ou apenas com o peso do corpo, flexione os joelhos, trabalhando as coxas.", LocalDate.now(), LocalDate.now()),
            new Exercicio(30, "Leg Press", "Sentado em uma maquina, empurre os pesos com as pernas, fortalecendo as coxas.", LocalDate.now(), LocalDate.now()),
            new Exercicio(31, "Cadeira Extensora", "Sentado em uma maquina, estenda as pernas, trabalhando os quadriceps.", LocalDate.now(), LocalDate.now()),
            new Exercicio(32, "Stiff", "Com halteres ou barra, incline o tronco para frente e levante o peso, estimulando os musculos das coxas e gluteos.", LocalDate.now(), LocalDate.now()),
            // ABDOMEN
            new Exercicio(33, "Prancha", "Com os antebracos e ponta dos pes no chao, mantenha o corpo reto, fortalecendo o core.", LocalDate.now(), LocalDate.now()),
            new Exercicio(34, "Crunch", "Deitado no chao, levante o tronco em direcao aos joelhos, trabalhando os musculos abdominais.", LocalDate.now(), LocalDate.now()),
            new Exercicio(35, "Russian Twist", "Sentado no chao, gire o tronco de um lado para o outro, fortalecendo os obliquos.", LocalDate.now(), LocalDate.now()),
            new Exercicio(36, "Prancha Lateral", "Apoiado no antebraco e lateral dos pes, mantenha o corpo reto de lado, fortalecendo os obliquos.", LocalDate.now(), LocalDate.now())
        };

        for (Exercicio exercicio : exercicios) {
            adicionarExercicio(exercicio);
        }
    }

    public void adicionarExercicio(Exercicio exercicio) {
        geradorId++;
        if (tamanho == exercicios.length) {
            aumentarCapacidade();
        }
        int id = geradorId;
        exercicio.setId(id);
        LocalDate dataAtual = LocalDate.now();
        exercicio.setDataCriacao(dataAtual);
        exercicio.setDataModificacao(dataAtual);
        exercicios[tamanho++] = exercicio;
    }

    private void aumentarCapacidade() {
        int novaCapacidade = exercicios.length * 2;
        Exercicio[] novoArray = new Exercicio[novaCapacidade];
        System.arraycopy(exercicios, 0, novoArray, 0, tamanho);
        exercicios = novoArray;
    }

    public void alterarExercicio(int id, Exercicio novoExercicio) {
        for (int i = 0; i < tamanho; i++) {
            if (exercicios[i].getId() == id) {
                exercicios[i].setNome(novoExercicio.getNome());
                exercicios[i].setDescricao(novoExercicio.getDescricao());
                exercicios[i].setDataModificacao(LocalDate.now());
                break;
            }
        }
    }

    public void removerExercicio(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (exercicios[i].getId() == id) {
                for (int j = i; j < tamanho - 1; j++) {
                    exercicios[j] = exercicios[j + 1];
                }
                tamanho--;
                break;
            }
        }
    }
    
    public Exercicio buscarExercicioPorNome(String nome) {
        for (int i = 0; i < tamanho; i++) {
            if (exercicios[i].getNome().equalsIgnoreCase(nome)) {
                return exercicios[i];
            }
        }
        return null; 
    }

    public Exercicio buscarExercicio(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (exercicios[i].getId() == id) {
                return exercicios[i];
            }
        }
        return null;
    }

    public Exercicio[] mostrarExercicios() {
        Exercicio[] exerciciosExistentes = new Exercicio[tamanho];
        System.arraycopy(exercicios, 0, exerciciosExistentes, 0, tamanho);
        return exerciciosExistentes;
    }
}
