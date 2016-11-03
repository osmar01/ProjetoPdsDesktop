
package ModeloTabela;

import Modelo.Funcionario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class FuncionarioTabelaModelo extends AbstractTableModel{
    private List<Funcionario> listaFuncionario;

    public FuncionarioTabelaModelo(List<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }
     
    @Override
    public int getRowCount() {
        return listaFuncionario.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
       Funcionario fun = listaFuncionario.get(linha);
       switch(coluna){
           case 0: return fun.getNome();
           case 1: return fun.getEndereco();
           case 2: return fun.getTelefone();
           case 3: return fun.getCpf();
        }
        return null;
    }
    public String getColumnName(int coluna) {
        switch(coluna){
            case 0: return "Nome";
            case 1: return "Endereço";
            case 2: return "Telefone";
            case 3: return "CPF";
        }
        return null;
    }
    
}
