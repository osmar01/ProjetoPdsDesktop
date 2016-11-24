package ModeloTabela;

import Modelo.Aluguel;
import Modelo.ItemDeProduto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ReservaTabelaModelo extends AbstractTableModel{
    private List<Aluguel> listaReservas;

    public ReservaTabelaModelo(List<Aluguel> listaReservas) {
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
       Aluguel aluguel = listaReservas.get(linha);
       switch(coluna){
           case 0: return aluguel.getClienteAluguel().getNome();
           case 1: return aluguel.getClienteAluguel().getCpf();
           case 2: return aluguel.getStatus();
           case 3: return aluguel.getValorTotal();
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
