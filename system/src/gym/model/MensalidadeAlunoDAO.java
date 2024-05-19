package gym.model;

import java.time.LocalDate;

public class MensalidadeAlunoDAO {

    private MensalidadeAluno[] mensalidadesAluno;
    private int tamanho;
    private int geradorId;

    public MensalidadeAlunoDAO() {
        this.mensalidadesAluno = new MensalidadeAluno[10];
        this.tamanho = 0;
        this.geradorId = 0;
    }

    public void adicionarMensalidadeAluno(MensalidadeAluno mensalidadeAluno, LocalDate dataAtual) {
        geradorId++;
        if (tamanho == mensalidadesAluno.length) {
            aumentarCapacidade();
        }
        int id = geradorId;
        mensalidadeAluno.setId(id);
        mensalidadeAluno.setDataCriacao(dataAtual);
        mensalidadeAluno.setDataModificacao(dataAtual);
        mensalidadesAluno[tamanho++] = mensalidadeAluno;
    }

    private void aumentarCapacidade() {
        int novaCapacidade = mensalidadesAluno.length * 2;
        MensalidadeAluno[] novoArray = new MensalidadeAluno[novaCapacidade];
        System.arraycopy(mensalidadesAluno, 0, novoArray, 0, tamanho);
        mensalidadesAluno = novoArray;
    }

    public void alterarMensalidadeAluno(int id, MensalidadeAluno novaMensalidadeAluno, LocalDate dataAtual) {
        for (int i = 0; i < tamanho; i++) {
            if (mensalidadesAluno[i].getId() == id) {
                mensalidadesAluno[i].setIdAluno(novaMensalidadeAluno.getIdAluno());
                mensalidadesAluno[i].setIdMensalidade(novaMensalidadeAluno.getIdMensalidade());
                mensalidadesAluno[i].setDataModificacao(dataAtual);
                break;
            }
        }
    }

    public void removerMensalidadeAluno(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (mensalidadesAluno[i].getId() == id) {
                for (int j = i; j < tamanho - 1; j++) {
                    mensalidadesAluno[j] = mensalidadesAluno[j + 1];
                }
                tamanho--;
                break;
            }
        }
    }

    public MensalidadeAluno buscarMensalidadeAluno(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (mensalidadesAluno[i].getId() == id) {
                return mensalidadesAluno[i];
            }
        }
        return null;
    }

    public MensalidadeAluno[] mostrarMensalidadesAluno() {
        MensalidadeAluno[] mensalidadesExistentes = new MensalidadeAluno[tamanho];
        System.arraycopy(mensalidadesAluno, 0, mensalidadesExistentes, 0, tamanho);
        return mensalidadesExistentes;
    }
    
    public LocalDate ajustarDataVencimento(LocalDate dataPagamento, LocalDate dataMensalidade){
        LocalDate dataAtual = LocalDate.now();
        int diferencaMeses = dataMensalidade.getMonthValue() - dataPagamento.getMonthValue();
        LocalDate dataVencimento = dataAtual.plusMonths(diferencaMeses);
        return dataVencimento;
    }
}
