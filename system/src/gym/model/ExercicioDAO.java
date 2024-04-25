package gym.model;

import java.time.LocalDate;

public class ExercicioDAO {

    private Exercicio[] exercicios;
    private int tamanho;

    public ExercicioDAO() {
        this.exercicios = new Exercicio[10];
        this.tamanho = 0;
    }

    public void adicionarExercicioExemplos() {
        Exercicio exercicio1 = new Exercicio(1, "Supino", "Exercício para peitoral", LocalDate.now(), LocalDate.now());
        Exercicio exercicio2 = new Exercicio(2, "Agachamento", "Exercício para pernas", LocalDate.now(), LocalDate.now());
        Exercicio exercicio3 = new Exercicio(3, "Rosca Direta", "Exercício para bíceps", LocalDate.now(), LocalDate.now());

        adicionarExercicio(exercicio1);
        adicionarExercicio(exercicio2);
        adicionarExercicio(exercicio3);
    }

    public void adicionarExercicio(Exercicio exercicio) {
        if (tamanho == exercicios.length) {
            aumentarCapacidade();
        }
        int id = tamanho + 1;
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
