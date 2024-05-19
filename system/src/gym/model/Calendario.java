package gym.model;

import java.time.LocalDate;

public class Calendario {

    private LocalDate dataAtual;
    private boolean diaDePagamento = false;

    public Calendario(LocalDate dataAtual) {
        this.dataAtual = dataAtual;
    }

    public LocalDate getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(LocalDate dataAtual) {
        this.dataAtual = dataAtual;
    }
    
    public boolean isDiaDePagamento() {
        return diaDePagamento;
    }

    public void setDiaDePagamento(boolean diaDePagamento) {
        this.diaDePagamento = diaDePagamento;
    }

    public void avancarDia() {
        setDataAtual(this.dataAtual.plusDays(1));
    }

    public void diminuirDia() {
        setDataAtual(this.dataAtual.minusDays(1));
    }
    

    public int[] checarVencimentos(MensalidadeAluno[] mensalidadesAlunos) {
        int[] idsAlunosMensalidadesVencidas = new int[mensalidadesAlunos.length];
        int quantidadeMensalidadeVencida = 0;
        for (int i = 0; i < mensalidadesAlunos.length; i++) {
            if (this.getDataAtual().isAfter(mensalidadesAlunos[i].getDataVencimento())) {
                idsAlunosMensalidadesVencidas[quantidadeMensalidadeVencida] = mensalidadesAlunos[i].getIdAluno();
                quantidadeMensalidadeVencida++;
            }
        }

        return idsAlunosMensalidadesVencidas;
    }
    
    public boolean checarQuintoDiaUtil(){
        if(this.getDataAtual().getDayOfMonth() == 5){
            setDiaDePagamento(true);
        }else{
            setDiaDePagamento(false);
        }
        
        return this.diaDePagamento;
    }

}
