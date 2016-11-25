package ModeloTabela;

import Modelo.Funcionario;
import Modelo.ItemDeProduto;
import Modelo.Produto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ItemDeProdutoTabelaModelo extends AbstractTableModel{
    private List<ItemDeProduto> listaProdutos;

    public ItemDeProdutoTabelaModelo(List<ItemDeProduto> listaProduto) {
        this.listaProdutos = listaProduto;
    }
     
    @Override
    public int getRowCount() {
        return listaProdutos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
       ItemDeProduto deProduto = listaProdutos.get(linha);
       switch(coluna){
           case 0: return deProduto.getProduto().getNome();
           case 1: return deProduto.getProduto().getCategoria().getNome();
           case 2: return deProduto.getQuantidade();
           case 3: return deProduto.getTotalParcial();
        }
        return null;
    }
    public String getColumnName(int coluna) {
        switch(coluna){
            case 0: return "Produto";
            case 1: return "Categoria";
            case 2: return "Quantidade";
            case 3: return "Valor Parcial";
        }
        return null;
    }
}
