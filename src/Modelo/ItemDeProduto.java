package Modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ItemDeProduto {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false,  length = 100)
    private int Quantidade;
    
    private int hora;
    
    private int minuto;
    
    private double total;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Produto produtoItem;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cliente clientesItem;

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

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
        this.total = valorParcial;
        
    }

    public Cliente getCliente() {
        return clientesItem;
    }

    public void setCliente(Cliente cliente) {
        this.clientesItem = cliente;
    }
    
    
}
