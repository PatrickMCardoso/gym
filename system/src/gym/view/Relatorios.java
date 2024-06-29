package gym.view;

import gym.model.MensalidadeAluno;
import gym.model.MovimentacaoFinanceira;
import gym.model.Pessoa;
import static gym.view.Menus.formataData;
import java.time.LocalDate;
import java.util.ArrayList;

public class Relatorios {

    public static void relatorioMovimentacaoFinanceira(MovimentacaoFinanceira[] movimentacoes, int mesDesejado, int anoDesejado) {
        System.out.println("*******************************");
        System.out.println("*  MOVIMENTACAO FINANCEIRA    *");
        System.out.println("*     MES/ANO: " + mesDesejado + "/" + anoDesejado + "  *");
        System.out.println("*******************************\n");
        System.out.println("------------------------");
        for (MovimentacaoFinanceira movimentacao : movimentacoes) {
            if (movimentacao.getDataCriacao().getMonthValue() == mesDesejado && movimentacao.getDataCriacao().getYear() == anoDesejado) {
                System.out.println("ID: " + movimentacao.getId());
                System.out.println("Valor: R$ " + movimentacao.getValor());
                System.out.println("Tipo: " + movimentacao.getTipo());
                System.out.println("Descricao: " + movimentacao.getDescricao());
                System.out.println("Data de Criacao: " + formataData(movimentacao.getDataCriacao()));
                System.out.println("Data de Modificacao: " + formataData(movimentacao.getDataModificacao()));
                System.out.println("------------------------");
            }
        }
    }

    public static void relatorioAlunosAdimplentes(ArrayList<MensalidadeAluno> mensalidades, ArrayList<Pessoa> alunos, LocalDate dataAtual, int[] idsAlunosAdimplentes) {
        System.out.println("*******************************");
        System.out.println("*  ALUNOS ADIMPLENTES    *");
        System.out.println("*     MES/ANO: " + dataAtual.getMonthValue() + "/" + dataAtual.getYear() + "  *");
        System.out.println("*******************************\n");
        System.out.println("------------------------");
        for (Pessoa pessoa : alunos) {
            for (int id : idsAlunosAdimplentes) {
                if (id == pessoa.getId() && pessoa.getTipoUsuario().equals("Aluno")) {
                    System.out.println("ID: " + pessoa.getId());
                    System.out.println("Nome: " + pessoa.getNome());
                    System.out.println("------------------------");
                }
            }
        }
    }
}
