package gym.model;

import java.time.LocalDate;
import java.util.ArrayList;

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

    public void avancarDia() {
        setDataAtual(this.dataAtual.plusDays(1));
    }

    public void diminuirDia() {
        setDataAtual(this.dataAtual.minusDays(1));
    }

    //PEGAR A LISTA DE IDS ALUNOS COM MENSALIDADES VENCIDAS
    public int[] checarAlunosVencidos(ArrayList<MensalidadeAluno> mensalidadesAlunos) {
        int[] idsAlunosVencidos = new int[mensalidadesAlunos.size()];
        int quantidadeMensalidadeVencida = 0;
        for (int i = 0; i < mensalidadesAlunos.size(); i++) {
            if (this.getDataAtual().isAfter(mensalidadesAlunos.get(i).getDataVencimento())) {
                idsAlunosVencidos[quantidadeMensalidadeVencida] = mensalidadesAlunos.get(i).getIdAluno();
                quantidadeMensalidadeVencida++;
            }
        }

        return idsAlunosVencidos;
    }

    //PEGAR A LISTA IDS DE ALUNOS ADIMPLENTES
    public int[] checarAlunosAdimplentes(ArrayList<MensalidadeAluno> mensalidadesAlunos) {
        int[] idsAlunosAdimplentes = new int[mensalidadesAlunos.size()];
        int quantidadeMensalidadeAdimplente = 0;
        for (int i = 0; i < mensalidadesAlunos.size(); i++) {
            if (this.getDataAtual().isBefore(mensalidadesAlunos.get(i).getDataVencimento())) {
                idsAlunosAdimplentes[quantidadeMensalidadeAdimplente] = mensalidadesAlunos.get(i).getIdAluno();
                quantidadeMensalidadeAdimplente++;
            }
        }

        return idsAlunosAdimplentes;
    }

    //CHECAR SE É O QUINTO DIA DO MES, USADO PARA VERIFICAR SE É NECESSARIO PAGAR AS DESPESAS MENSAIS
    public boolean checarQuintoDiaUtil() {
        return this.getDataAtual().getDayOfMonth() == 5;
    }

    //CHECAR SE ACABOU O MES, PARA VERIFICAR E POSTERIORMENTE MOSTRAR A LISTA DE ALUNOS ADIMPLENTES
    public boolean checarTerminoMes() {
        return this.getDataAtual().getDayOfMonth() == 1;
    }

}
