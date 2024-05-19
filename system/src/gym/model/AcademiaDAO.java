package gym.model;

import java.time.LocalDate;

public class AcademiaDAO {

    private Academia[] academias;
    private int tamanho;
    private int geradorId;

    public AcademiaDAO() {
        this.academias = new Academia[10];
        this.tamanho = 0;
        this.geradorId = 0;
    }

    public void adicionarAcademiasExemplo() {
        Academia academia1 = new Academia(1, "Tasmanian Gym", "R. Píres de Campos, 409", LocalDate.now(), LocalDate.now());
        Academia academia2 = new Academia(2, "BioTech Prime", "Av. Nenê Sabino, 915", LocalDate.now(), LocalDate.now());
        Academia academia3 = new Academia(3, "Smart Fit", "Av. Guilherme Ferreira, 1550", LocalDate.now(), LocalDate.now());

        adicionarAcademia(academia1, LocalDate.now());
        adicionarAcademia(academia2, LocalDate.now());
        adicionarAcademia(academia3, LocalDate.now());
    }

    public void adicionarAcademia(Academia academia, LocalDate dataAtual) {
        geradorId++;
        if (tamanho == academias.length) {
            aumentarCapacidade();
        }
        int id = geradorId;
        academia.setId(id);
        academia.setDataCriacao(dataAtual);
        academia.setDataModificacao(dataAtual);
        academias[tamanho++] = academia;
    }

    private void aumentarCapacidade() {
        int novaCapacidade = academias.length * 2;
        Academia[] novoArray = new Academia[novaCapacidade];
        System.arraycopy(academias, 0, novoArray, 0, tamanho);
        academias = novoArray;
    }

    public void alterarAcademia(int id, Academia novaAcademia, LocalDate dataAtual) {
        for (int i = 0; i < tamanho; i++) {
            if (academias[i].getId() == id) {
                academias[i].setNome(novaAcademia.getNome());
                academias[i].setEndereco(novaAcademia.getEndereco());
                academias[i].setDataModificacao(dataAtual);
                break;
            }
        }
    }

    public void removerAcademia(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (academias[i].getId() == id) {
                for (int j = i; j < tamanho - 1; j++) {
                    academias[j] = academias[j + 1];
                }
                tamanho--;
                break;
            }
        }
    }

    public Academia buscarAcademia(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (academias[i].getId() == id) {
                return academias[i];
            }
        }
        return null;
    }

    public Academia[] mostrarAcademias() {
        Academia[] academiasExistentes = new Academia[tamanho];
        System.arraycopy(academias, 0, academiasExistentes, 0, tamanho);
        return academiasExistentes;
    }
}
