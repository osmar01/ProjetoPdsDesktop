package Modelo;

import java.util.GregorianCalendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ItemDeProduto {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false,  length = 100)
    private int Quantidade;

    private int minuto;
    
    private double totalParcial;
    

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Produto produtoItem;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Aluguel aluguel;
    
    public ItemDeProduto() {
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }


    public Produto getProduto() {
        return produtoItem;
    }

    public void setProduto(Produto produto) {
        this.produtoItem = produto;
    }
    
    public void calcularValorParcial(Produto produto, int quantidade, int hora, int minuto){
        double valorParcial=0;
        int horaParaMiniutos;
        if (hora == 0 && minuto != 0) {
            valorParcial = (produto.getPreco() * minuto) * quantidade;
        }
        if(hora!=0 && minuto != 0){
            horaParaMiniutos = hora*60;
            valorParcial = (produto.getPreco()* (horaParaMiniutos + minuto)) * quantidade;
        }     
        if(hora!=0 && minuto == 0){
            horaParaMiniutos = hora*60;
            valorParcial = (produto.getPreco()   * (horaParaMiniutos + minuto)) * quantidade;
        }
        //this.total = valorParcial;
        
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    public double getTotalParcial() {
        return totalParcial;
    }

    public void setTotalParcial(double totalParcial) {
        this.totalParcial = totalParcial;
    }

    public Produto getProdutoItem() {
        return produtoItem;
    }

    public void setProdutoItem(Produto produtoItem) {
        this.produtoItem = produtoItem;
    }

    
    
    
    
}
