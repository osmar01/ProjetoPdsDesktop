package ModeloTabela;

import Modelo.Aluguel;
import Modelo.ItemDeProduto;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class DevolucaoTabelaModelo extends AbstractTableModel {

    private List<ItemDeProduto> listaItensProduto;

    public DevolucaoTabelaModelo(List<ItemDeProduto> listaItensProduto) {
        this.listaItensProduto = listaItensProduto;
    }

    @Override
    public int getRowCount() {
        return listaItensProduto.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        ItemDeProduto itemProduto = listaItensProduto.get(linha);
        switch (coluna) {
            case 0:
                return itemProduto.getProduto().getNome();
            case 1:
                DateFormat formatoHora = new SimpleDateFormat("HH:mm");
                String horaInicioFormatada = formatoHora.format(itemProduto.getAluguel().getHoraInicio());
                return horaInicioFormatada;
            case 2:
                Calendar calendar = itemProduto.getAluguel().getHoraPrevista();
                Date date = calendar.getTime();
                DateFormat hora = DateFormat.getTimeInstance();
                String horaPrevistaFormatada = hora.format(date);
                return horaPrevistaFormatada;
            case 3:
                return itemProduto.getAluguel().getHoraDevolvida();
            case 4:
                return itemProduto.getProduto().getPreco();
            case 5:
                return Double.toString(itemProduto.getTotalParcial());
        }
        return null;
    }

    public String getColumnName(int coluna) {
        switch (coluna) {
            case 0:
                return "Produto";
            case 1:
                return "Inicio do Aluguel";
            case 2:
                return "Termino Previsto";
            case 3:
                return "Horario Devolvido";
            case 4:
                return "Valor por 30min";
            case 5:
                return "Valor Total";
        }
        return null;
    }

}
