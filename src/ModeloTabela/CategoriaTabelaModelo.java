package ModeloTabela;

import Modelo.Categoria;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class CategoriaTabelaModelo extends AbstractTableModel{
    List<Categoria> listaCategorias;

    public CategoriaTabelaModelo(List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }
    
    @Override
    public int getRowCount() {
        return listaCategorias.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Categoria cat = listaCategorias.get(linha);
       switch(coluna){
           case 0: return cat.getNome();
        }
        return null;
    }
    
    public String getColumnName(int coluna) {
        switch(coluna){
            case 0: return "Categorias";
        }
        return null;
    }
}
