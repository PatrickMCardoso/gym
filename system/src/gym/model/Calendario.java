package gym.model;

import java.time.LocalDate;
import gym.model.MensalidadeAluno;

public class Calendario {

    private LocalDate dataAtual;

    public Calendario(LocalDate dataAtual) {
        this.dataAtual = dataAtual;
    }

    public LocalDate getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(LocalDate dataAtual) {
        this.dataAtual = dataAtual;
    }

    public void aumentarDias(int dias) {
        setDataAtual(this.dataAtual.plusDays(dias));
    }

    public void diminuirDias(int dias) {
        setDataAtual(this.dataAtual.minusDays(dias));
    }

    public int[] checarVencimentos(MensalidadeAluno[] mensalidadesAlunos) {
        int[] idsAlunosMensalidadesVencidas = new int[mensalidadesAlunos.length];
        int quantidadeMensalidadeVencida = 0;
        for (int i = 0; i < mensalidadesAlunos.length; i++) {
            if (this.dataAtual.isAfter(mensalidadesAlunos[i].getDataVencimento())) {
                idsAlunosMensalidadesVencidas[quantidadeMensalidadeVencida] = mensalidadesAlunos[i].getIdAluno();
                quantidadeMensalidadeVencida++;
            }
        }

        return idsAlunosMensalidadesVencidas;
    }

}
