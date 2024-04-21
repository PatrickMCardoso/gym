/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym.model;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author ruanemanuell
 */
public class AcademiaDAO {
    private List<Academia> academias;

    public AcademiaDAO() {
        this.academias = new ArrayList<>();
    }
    
    public void adicionarAcademia(Academia academia){
        int id = academias.size()+1;
        academia.setId(id);
        LocalDate dataAtual = LocalDate.now();
        academia.setDataCriacao(dataAtual);
        academia.setDataModificacao(dataAtual);
        academias.add(academia);
    }
    
    public List<Academia> mostrarAcademias(){
        return academias;
    }
}
