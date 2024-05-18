package gym.model;

import java.time.LocalDate;
import java.util.Random;


public class ExercicioAplicacaoDAO {

    private ExercicioAplicacao[] exerciciosAplicacao;
    private int tamanho;
    private int geradorId;

    public ExercicioAplicacaoDAO() {
        this.exerciciosAplicacao = new ExercicioAplicacao[10];
        this.tamanho = 0;
        this.geradorId = 0;
    }
    
    public void adicionarExerciciosAplicacaoExemplos() {
        Random random = new Random();
        String[] descricoes = {"4x12", "4x10", "12 reps com rest pause", "5x5 com carga maxima", "4xMAX"};

        for (int i = 1; i <= 36; i++) {           
            int idExercicio = i;
            String descricao = descricoes[random.nextInt(descricoes.length)];            
            
            adicionarExercicioAplicacao(idExercicio, descricao);
        }
    }

    public void adicionarExercicioAplicacao(int idExercicio, String descricao) {
            geradorId++;
            if (tamanho == exerciciosAplicacao.length) {
                aumentarCapacidade();
            }
            int id = geradorId;
            LocalDate dataAtual = LocalDate.now();
            ExercicioAplicacao exercicioAplicacao = new ExercicioAplicacao(id, idExercicio, descricao, dataAtual, dataAtual);
            exerciciosAplicacao[tamanho++] = exercicioAplicacao; 
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
