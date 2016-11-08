package ModeloTabela;

import Modelo.Funcionario;
import Modelo.Produto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProdutoAluguelTabelaModelo extends AbstractTableModel{
    private List<Produto> listaProduto;

    public ProdutoAluguelTabelaModelo(List<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }
     
    @Override
    public int getRowCount() {
        return listaProduto.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
       Produto cat = listaProduto.get(linha);
       switch(coluna){
           case 0: return cat.getNome();
           case 1: return cat.getPreco().toString();
        }
        return null;
    }
    public String getColumnName(int coluna) {
        switch(coluna){
            case 0: return "Produto";
            case 1: return "Preço";
        }
        return null;
    }
}
