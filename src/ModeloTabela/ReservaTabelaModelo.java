package ModeloTabela;

import Modelo.Funcionario;
import Modelo.ItemDeProduto;
import Modelo.Produto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ReservaTabelaModelo extends AbstractTableModel{
    private List<ItemDeProduto> listaReservas;

    public ReservaTabelaModelo(List<ItemDeProduto> listaReservas) {
        this.listaReservas = listaReservas;
    }
     
    @Override
    public int getRowCount() {
        return listaReservas.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
       ItemDeProduto deProduto = listaReservas.get(linha);
       switch(coluna){
           case 0: return deProduto.getCliente().getNome();
           case 1: return deProduto.getCliente().getCpf();
           case 2: return deProduto.getStatus();
           case 3: return deProduto.getTotal();
        }
        return null;
    }
    public String getColumnName(int coluna) {
        switch(coluna){
            case 0: return "Nome";
            case 1: return "CPF";
            case 2: return "Status";
            case 3: return "Valor Total";
        }
        return null;
    }
}
