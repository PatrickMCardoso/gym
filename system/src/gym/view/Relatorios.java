package gym.view;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import gym.model.MensalidadeAluno;
import gym.model.MovimentacaoFinanceira;
import gym.model.Pessoa;
import static gym.view.Menus.formataData;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Relatorios {

    public static void relatorioMovimentacaoFinanceira(ArrayList<MovimentacaoFinanceira> movimentacoes, int mesDesejado, int anoDesejado) throws IOException {
        String fileName = "relatorio_movimentacao.pdf";

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();

            String titulo = "MOVIMENTACAO FINANCEIRA";
            String periodo = "MES/ANO: " + mesDesejado + "/" + anoDesejado;
            
            document.add(new Paragraph("*******************************"));
            document.add(new Paragraph("*  " + titulo));
            document.add(new Paragraph("*     " + periodo + "  *"));
            document.add(new Paragraph("*******************************"));
            document.add(new Paragraph("\n"));

            for (MovimentacaoFinanceira movimentacao : movimentacoes) {
                if (movimentacao.getDataCriacao().getMonthValue() == mesDesejado && movimentacao.getDataCriacao().getYear() == anoDesejado) {
                    document.add(new Paragraph("------------------------"));
                    document.add(new Paragraph("ID: " + movimentacao.getId()));
                    document.add(new Paragraph("Valor: R$ " + movimentacao.getValor()));
                    document.add(new Paragraph("Tipo: " + movimentacao.getTipo()));
                    document.add(new Paragraph("Descricao: " + movimentacao.getDescricao()));
                    document.add(new Paragraph("Data de Criacao: " + formataData(movimentacao.getDataCriacao())));
                    document.add(new Paragraph("Data de Modificacao: " + formataData(movimentacao.getDataModificacao())));
                }
            }

            document.close();
            
            System.out.println("Relatório gerado com sucesso: " + fileName);
            
            File file = new File(fileName);
            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                System.out.println("Arquivo PDF não encontrado e não pode ser aberto.");
            }
        } catch (FileNotFoundException | DocumentException e) {
            System.out.println("Erro ao gerar PDF: " + e.getMessage());
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
