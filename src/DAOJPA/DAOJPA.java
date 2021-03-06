/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOJPA;

import Modelo.Aluguel;
import Modelo.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Junnio
 */
public class DAOJPA<Tipo> {
    private EntityManager em;
    private Class<Tipo> classe;
    
    public DAOJPA(EntityManager em, Class<Tipo> classe){
        this.em=em;
        this.classe = classe;
    }
    
    public void Inserir(Tipo o){   
        em.persist(o);
    }
    
    public void Remover(Tipo o){
        em.remove(o);
        
    }
    public Tipo Consultar(Long id){
        return em.find(classe, id);
    }
    
    public List<Tipo> listar(String nome){
        Query consulta = em.createQuery("select o from "+classe.getName()+" o where o.nome like '%"+nome+"%'"); 
        return consulta.getResultList();
    }
    public List<Tipo> listarDescricao(String descricao){
        Query consulta = em.createQuery("select o from "+classe.getName()+" o where o.Descricao like '%"+descricao+"%'"); 
        return consulta.getResultList();
    }
    
    public List<Tipo> listarCPF(String cpf){
        Query consulta = em.createQuery("select o from "+classe.getName()+" o where o.cpf like '%"+cpf+"%'"); 
        return consulta.getResultList();
    }
    
    public List<Tipo> listarStatus(String status){
        Query consulta = em.createQuery("select o from "+classe.getName()+" o where o.status = '"+status+"' group by o.clienteAluguel"); 
        return consulta.getResultList();
    }
    
    public List<Tipo> listarLogin(String login){
        Query consulta = em.createQuery("select o from "+classe.getName()+" o where o.login = '"+login+"'"); 
        return consulta.getResultList();
    }
    
    public List<Tipo> listarItemProdutoId(Cliente cliente){
        Query consulta = em.createQuery("select o from "+classe.getName()+" o where o.aluguel.clienteAluguel = '"+cliente.getId()+"'"); 
        return consulta.getResultList();
    }
    
    public List<Tipo> listarItemProdutoIdStatusAndamento(Cliente cliente){
        Query consulta = em.createQuery("select o from "+classe.getName()+" o where o.aluguel.clienteAluguel = '"+cliente.getId()+"' and o.aluguel.status = 'Em andamento'"); 
        return consulta.getResultList();
    }
    public List<Tipo> listarItemProdutoIdStatusPendente(Cliente cliente){
        Query consulta = em.createQuery("select o from "+classe.getName()+" o where o.aluguel.clienteAluguel = '"+cliente.getId()+"' and o.aluguel.status = 'Pendente'"); 
        return consulta.getResultList();
    }
    
    public List<Tipo> listarAluguelId(Cliente cliente){
        Query consulta = em.createQuery("select o from "+classe.getName()+" o where o.aluguel.clienteAluguel = '"+cliente.getId()+"'"); 
        return consulta.getResultList();
    }
}
