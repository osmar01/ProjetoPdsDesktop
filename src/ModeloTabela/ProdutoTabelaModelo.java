package ModeloTabela;

import Modelo.Funcionario;
import Modelo.Produto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProdutoTabelaModelo extends AbstractTableModel{
    private List<Produto> listaProduto;

    public ProdutoTabelaModelo(List<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }
     
    @Override
    public int getRowCount() {
        return listaProduto.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
       Produto cat = listaProduto.get(linha);
       switch(coluna){
           case 0: return cat.getNome();
           case 1: return cat.getPreco().toString();
           case 2: return cat.getQuantidade();
           case 3: return cat.getCategoria().getNome();
        }
        return null;
    }
    public String getColumnName(int coluna) {
        switch(coluna){
            case 0: return "Nome";
            case 1: return "Preço";
            case 2: return "Quantidade";
            case 3: return "Categoria";
        }
        return null;
    }
}
