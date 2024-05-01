package gym.model;

import java.time.LocalDate;

public class ExercicioAplicacaoDAO {

    private ExercicioAplicacao[] exerciciosAplicacao;
    private int tamanho;

    public ExercicioAplicacaoDAO() {
        this.exerciciosAplicacao = new ExercicioAplicacao[10];
        this.tamanho = 0;
    }

    public void adicionarExercicioAplicacao(ExercicioDAO exercicioDAO, int idExercicio, String descricao) {
        Exercicio exercicio = exercicioDAO.buscarExercicio(idExercicio);
        if (exercicio != null) {
            if (tamanho == exerciciosAplicacao.length) {
                aumentarCapacidade();
            }
            int id = tamanho + 1;
            LocalDate dataAtual = LocalDate.now();
            ExercicioAplicacao exercicioAplicacao = new ExercicioAplicacao(id, descricao, dataAtual, dataAtual);
            exerciciosAplicacao[tamanho++] = exercicioAplicacao;
        } else {
            System.out.println("Exercício não encontrado.");
        }
    }

    private void aumentarCapacidade() {
        int novaCapacidade = exerciciosAplicacao.length * 2;
        ExercicioAplicacao[] novoArray = new ExercicioAplicacao[novaCapacidade];
        System.arraycopy(exerciciosAplicacao, 0, novoArray, 0, tamanho);
        exerciciosAplicacao = novoArray;
    }

    public void alterarExercicioAplicacao(int id, ExercicioAplicacao novoExercicioAplicacao) {
        for (int i = 0; i < tamanho; i++) {
            if (exerciciosAplicacao[i].getId() == id) {
                exerciciosAplicacao[i].setDescricao(novoExercicioAplicacao.getDescricao());
                exerciciosAplicacao[i].setDataModificacao(LocalDate.now());
                break;
            }
        }
    }

    public void removerExercicioAplicacao(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (exerciciosAplicacao[i].getId() == id) {
                for (int j = i; j < tamanho - 1; j++) {
                    exerciciosAplicacao[j] = exerciciosAplicacao[j + 1];
                }
                tamanho--;
                break;
            }
        }

        for (int i = 0; i < tamanho; i++) {
            exerciciosAplicacao[i].setId(i + 1);
        }
    }

    public ExercicioAplicacao buscarExercicioAplicacao(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (exerciciosAplicacao[i].getId() == id) {
                return exerciciosAplicacao[i];
            }
        }
        return null;
    }

    public ExercicioAplicacao[] mostrarExerciciosAplicacao() {
        ExercicioAplicacao[] exerciciosAplicacaoExistentes = new ExercicioAplicacao[tamanho];
        System.arraycopy(exerciciosAplicacao, 0, exerciciosAplicacaoExistentes, 0, tamanho);
        return exerciciosAplicacaoExistentes;
    }
}
