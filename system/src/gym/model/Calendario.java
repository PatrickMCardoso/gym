package gym.model;

import java.time.LocalDate;

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
    public int[] checarAlunosVencidos(MensalidadeAluno[] mensalidadesAlunos) {
        int[] idsAlunosVencidos = new int[mensalidadesAlunos.length];
        int quantidadeMensalidadeVencida = 0;
        for (int i = 0; i < mensalidadesAlunos.length; i++) {
            if (this.getDataAtual().isAfter(mensalidadesAlunos[i].getDataVencimento())) {
                idsAlunosVencidos[quantidadeMensalidadeVencida] = mensalidadesAlunos[i].getIdAluno();
                quantidadeMensalidadeVencida++;
            }
        }

        return idsAlunosVencidos;
    }
    
    //PEGAR A LISTA IDS DE ALUNOS ADIMPLENTES
    public int[] checarAlunosAdimplentes(MensalidadeAluno[] mensalidadesAlunos) {
        int[] idsAlunosAdimplentes = new int[mensalidadesAlunos.length];
        int quantidadeMensalidadeAdimplente = 0;
        for (int i = 0; i < mensalidadesAlunos.length; i++) {
            if (this.getDataAtual().isBefore(mensalidadesAlunos[i].getDataVencimento())) {
                idsAlunosAdimplentes[quantidadeMensalidadeAdimplente] = mensalidadesAlunos[i].getIdAluno();
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
