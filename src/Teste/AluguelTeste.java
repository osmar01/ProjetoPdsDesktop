package Teste;

import DAOJPA.DAOJPA;
import Modelo.Aluguel;
import Modelo.Funcionario;
import Modelo.Produto;
import Util.JPAUtil;
import javax.persistence.EntityManager;


public class AluguelTeste {
    
     public void lerDados(){
        EntityManager em = JPAUtil.getEntityManager();
        Aluguel aluguel = new Aluguel();
        //aluguel.setHoraFim("4H");
        //aluguel.setHoraInicio("2H");
        
        Funcionario funcionario = em.find(Funcionario.class, 1L);
        aluguel.setFuncionario(funcionario);
        Produto produto = em.find(Produto.class, 1L);
        
        //aluguel.setProduto(produto);
        
        aluguel.setStatus("Finalizado");
        aluguel.setValorTotal(100.00);

        em.getTransaction().begin();
        DAOJPA<Aluguel> dao = new DAOJPA<>(em,Aluguel.class);
        dao.Inserir(aluguel);
        em.getTransaction().commit();
        em.close();   
     }
     public static void main(String[] args){
     AluguelTeste aluguelTeste = new AluguelTeste();
     aluguelTeste.lerDados();
     
     }
}
