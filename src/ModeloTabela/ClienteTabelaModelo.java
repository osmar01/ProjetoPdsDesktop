
package ModeloTabela;

import Modelo.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ClienteTabelaModelo extends AbstractTableModel{
    private List<Cliente> listaCliente;

    public ClienteTabelaModelo(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }
    
    
    @Override
    public int getRowCount() {
        return listaCliente.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Cliente cliente = listaCliente.get(linha);
       switch(coluna){
           case 0: return cliente.getNome();
           case 1: return cliente.getEndereco();
           case 2: return cliente.getTelefone();
           case 3: return cliente.getCNH();
        }
        return null;
    }
    public String getColumnName(int coluna) {
        switch(coluna){
            case 0: return "Nome";
            case 1: return "Endereço";
            case 2: return "Telefone";
            case 3: return "CNH";
        }
        return null;
    }
    
}
