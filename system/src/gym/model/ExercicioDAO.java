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
            new Exercicio(1, "Supino Reto (PEITO)", "Deitado em um banco, empurre uma barra para cima, trabalhando o peitoral maior.", LocalDate.now(), LocalDate.now()),
            new Exercicio(2, "Crucifixo com Halteres (PEITO)", "Deitado em um banco, abra os braços com halteres, estimulando os músculos do peito.", LocalDate.now(), LocalDate.now()),
            new Exercicio(3, "Flexões (PEITO)", "No chão, empurre o corpo para cima, fortalecendo o peito e os tríceps.", LocalDate.now(), LocalDate.now()),
            new Exercicio(4, "Cross Over (PEITO)", "Na máquina, puxe as alças cruzadas para frente do peito.", LocalDate.now(), LocalDate.now()),
            // COSTAS / LOMBAR
            new Exercicio(5, "Barra Fixa (COSTAS/LOMBAR)", "Pendurado em uma barra, puxe o corpo para cima, fortalecendo as costas e os braços.", LocalDate.now(), LocalDate.now()),
            new Exercicio(6, "Remada Curvada (COSTAS/LOMBAR)", "Com halteres ou barra, incline o tronco para frente e puxe os pesos em direção ao abdômen.", LocalDate.now(), LocalDate.now()),
            new Exercicio(7, "Hiperextensão (COSTAS/LOMBAR)", "Deitado de bruços em um banco inclinado, levante o tronco, fortalecendo a região lombar.", LocalDate.now(), LocalDate.now()),
            new Exercicio(8, "Pulldown (COSTAS/LOMBAR)", "Sentado em uma máquina, puxe a barra para baixo em direção ao peito, trabalhando as costas e os braços.", LocalDate.now(), LocalDate.now()),
            // OMBRO / TRAPÉZIO
            new Exercicio(9, "Desenvolvimento com Halteres (OMBRO/TRAPÉZIO)", "Em pé ou sentado, levante halteres sobre a cabeça, fortalecendo os ombros.", LocalDate.now(), LocalDate.now()),
            new Exercicio(10, "Elevação Lateral (OMBRO/TRAPÉZIO)", "Com halteres, levante os braços para os lados, trabalhando os deltoides.", LocalDate.now(), LocalDate.now()),
            new Exercicio(11, "Encolhimento de Ombros (OMBRO/TRAPÉZIO)", "Com halteres ou barra, eleve os ombros, fortalecendo os trapézios.", LocalDate.now(), LocalDate.now()),
            new Exercicio(12, "Elevação Frontal (OMBRO/TRAPÉZIO)", "Com halteres ou barra, levante os braços à frente, estimulando os deltoides anteriores.", LocalDate.now(), LocalDate.now()),
            // BÍCEPS / ANTEBRAÇO
            new Exercicio(13, "Rosca Direta (BÍCEPS/ANTEBRAÇO)", "Com halteres ou barra, dobre os braços para levantar o peso, trabalhando os bíceps.", LocalDate.now(), LocalDate.now()),
            new Exercicio(14, "Rosca Martelo (BÍCEPS/ANTEBRAÇO)", "Com halteres, levante os pesos mantendo os punhos neutros, estimulando os bíceps e antebraços.", LocalDate.now(), LocalDate.now()),
            new Exercicio(15, "Rosca Concentrada (BÍCEPS/ANTEBRAÇO)", "Sentado, dobre o braço em um banco e levante o peso, isolando o bíceps.", LocalDate.now(), LocalDate.now()),
            new Exercicio(16, "Flexão de Punhos (BÍCEPS/ANTEBRAÇO)", "Com halteres, flexione os pulsos para cima e para baixo, fortalecendo os antebraços.", LocalDate.now(), LocalDate.now()),
            // TRÍCEPS
            new Exercicio(17, "Tríceps Pulley (TRÍCEPS)", "Em uma máquina, puxe uma corda para baixo, estendendo os braços e trabalhando os tríceps.", LocalDate.now(), LocalDate.now()),
            new Exercicio(18, "Tríceps Francês (TRÍCEPS)", "Com halteres ou barra, abaixe o peso atrás da cabeça, estendendo os braços para cima.", LocalDate.now(), LocalDate.now()),
            new Exercicio(19, "Fundos (TRÍCEPS)", "Com as mãos em um banco e os pés no chão, abaixe o corpo flexionando os braços, trabalhando os tríceps.", LocalDate.now(), LocalDate.now()),
            new Exercicio(20, "Extensão de Tríceps (TRÍCEPS)", "Com halteres, estenda os braços para cima e para trás, focando nos tríceps.", LocalDate.now(), LocalDate.now()),
            // PANTURRILHA          
            new Exercicio(21, "Elevação de Panturrilha em Pé (PANTURRILHA)", "Em pé, levante o corpo sobre os dedos dos pés, trabalhando as panturrilhas.", LocalDate.now(), LocalDate.now()),
            new Exercicio(22, "Elevação de Panturrilha Sentado (PANTURRILHA)", "Sentado em uma máquina, levante os calcanhares, fortalecendo as panturrilhas.", LocalDate.now(), LocalDate.now()),
            new Exercicio(23, "Elevação de Panturrilha Unilateral (PANTURRILHA)", "Em pé, levante uma perna e eleve o calcanhar, trabalhando uma panturrilha de cada vez.", LocalDate.now(), LocalDate.now()),
            new Exercicio(24, "Salto na Panturrilha (PANTURRILHA)", "Pule e levante os calcanhares ao mesmo tempo, fortalecendo as panturrilhas com o impacto.", LocalDate.now(), LocalDate.now()),
            // GLÚTEO
            new Exercicio(25, "Agachamento (GLÚTEO)", "Com ou sem pesos, flexione os joelhos como se fosse sentar, trabalhando os glúteos e pernas.", LocalDate.now(), LocalDate.now()),
            new Exercicio(26, "Elevação Pélvica (GLÚTEO)", "Deitado no chão, levante os quadris, contraindo os glúteos.", LocalDate.now(), LocalDate.now()),
            new Exercicio(27, "Afundo (GLÚTEO)", "Dê passos largos para frente e flexione os joelhos, alternando as pernas para trabalhar os glúteos.", LocalDate.now(), LocalDate.now()),
            new Exercicio(28, "Glúteo Kickback (GLÚTEO)", "Com uma perna para trás, levante-a para trás, contraindo os glúteos.", LocalDate.now(), LocalDate.now()),
            // COXA
            new Exercicio(29, "Agachamento Livre (COXA)", "Com barra ou apenas com o peso do corpo, flexione os joelhos, trabalhando as coxas.", LocalDate.now(), LocalDate.now()),
            new Exercicio(30, "Leg Press (COXA)", "Sentado em uma máquina, empurre os pesos com as pernas, fortalecendo as coxas.", LocalDate.now(), LocalDate.now()),
            new Exercicio(31, "Cadeira Extensora (COXA)", "Sentado em uma máquina, estenda as pernas, trabalhando os quadríceps.", LocalDate.now(), LocalDate.now()),
            new Exercicio(32, "Stiff (COXA)", "Com halteres ou barra, incline o tronco para frente e levante o peso, estimulando os músculos das coxas e glúteos.", LocalDate.now(), LocalDate.now()),
            // ABDÔMEN
            new Exercicio(33, "Prancha (ABDÔMEN)", "Com os antebraços e ponta dos pés no chão, mantenha o corpo reto, fortalecendo o core.", LocalDate.now(), LocalDate.now()),
            new Exercicio(34, "Crunch (ABDÔMEN)", "Deitado no chão, levante o tronco em direção aos joelhos, trabalhando os músculos abdominais.", LocalDate.now(), LocalDate.now()),
            new Exercicio(35, "Russian Twist (ABDÔMEN)", "Sentado no chão, gire o tronco de um lado para o outro, fortalecendo os oblíquos.", LocalDate.now(), LocalDate.now()),
            new Exercicio(36, "Prancha Lateral (ABDÔMEN)", "Apoiado no antebraço e lateral dos pés, mantenha o corpo reto de lado, fortalecendo os oblíquos.", LocalDate.now(), LocalDate.now())
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

        for (int i = 0; i < tamanho; i++) {
            exercicios[i].setId(i + 1);
        }
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
