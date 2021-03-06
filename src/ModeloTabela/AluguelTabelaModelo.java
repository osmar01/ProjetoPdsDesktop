
package ModeloTabela;

import Modelo.Aluguel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AluguelTabelaModelo extends AbstractTableModel{
    private List<Aluguel> listaAluguel;

    public AluguelTabelaModelo(List<Aluguel> listaAluguel) {
        this.listaAluguel = listaAluguel;
    }
    
    
    @Override
    public int getRowCount() {
        return listaAluguel.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Aluguel aluguel = listaAluguel.get(linha);
       switch(coluna){
           case 0: return aluguel.getClienteAluguel().getCpf();
           case 1: 
                DateFormat formatoHora = new SimpleDateFormat("HH:mm");
                String horaFormatada = formatoHora.format(aluguel.getHoraInicio());
                return horaFormatada;
           case 2: return aluguel.getStatus();
           case 3: return aluguel.getValorTotal();
        }
        return null;
    }
    public String getColumnName(int coluna) {
        switch(coluna){
            case 0: return "CPF";
            case 1: return "Hora Inicio";
            case 2: return "Status";
            case 3: return "Valor Total";
        }
        return null;
    }
    
}
