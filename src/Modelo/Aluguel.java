package Modelo;

import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import static org.hibernate.Hibernate.entity;
import static org.hibernate.Hibernate.entity;

/**
 *
 * @author Aluno
 */


@Entity
public class Aluguel {
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String status;
    
    private Date horaInicio;
    
    private GregorianCalendar horaPrevista;
    
    private String horaDevolvida;
    
    private Double valorTotal;
    
    private Date dataAluguel;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Funcionario funcionario;
      
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cliente clienteAluguel;

    public Aluguel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public GregorianCalendar getHoraPrevista() {
        return horaPrevista;
    }

    public void setHoraPrevista(GregorianCalendar horaPrevista) {
        this.horaPrevista = horaPrevista;
    }


    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(Date dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public Cliente getClienteAluguel() {
        return clienteAluguel;
    }

    public void setClienteAluguel(Cliente clienteAluguel) {
        this.clienteAluguel = clienteAluguel;
    }

    public String getHoraDevolvida() {
        return horaDevolvida;
    }

    public void setHoraDevolvida(String horaDevolvida) {
        this.horaDevolvida = horaDevolvida;
    }
    
    

    
}
