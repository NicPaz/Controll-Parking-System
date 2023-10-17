/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Veiculo;


public class VeiculoTableModel extends AbstractTableModel{
    public static final int COL_MODELO = 0;
    public static final int COL_COR = 1;
    public static final int COL_PLACA = 2;
    public static final int COL_NOME = 3;
    
    public ArrayList<Veiculo> listaVeiculos;
    
    public VeiculoTableModel(ArrayList<Veiculo> alVeiculo){
        this.listaVeiculos = alVeiculo;
    }
    
    @Override
    public Object getValueAt(int linha, int coluna){
        Veiculo v = listaVeiculos.get(linha);
        Object conteudo = "";
        if(coluna == COL_MODELO){conteudo = v.getModelo();}
        if(coluna == COL_COR){conteudo = v.getCor();}
        if(coluna == COL_PLACA){conteudo = v.getPlaca();}
        if(coluna == COL_NOME){conteudo = v.getNome();}
        
        return conteudo;
    }
    
    @Override
    public int getColumnCount(){
        return 4;
    }
    
    @Override
    public int getRowCount(){
        return listaVeiculos.size();
    }
    
    @Override
    public String getColumnName(int coluna){
        String nome = "";
        if(coluna == COL_MODELO){nome = "Modelo";}
        if(coluna == COL_COR){nome = "Cor";}
        if(coluna == COL_PLACA){nome = "Placa";}
        if(coluna == COL_NOME){nome = "Nome";}
        
        return nome;
    }
}

