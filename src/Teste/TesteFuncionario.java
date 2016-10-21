
package Teste;

import DAOJPA.DAOJPA;
import Modelo.Funcionario;
import Util.JPAUtil;
import javax.persistence.EntityManager;

public class TesteFuncionario {
    
    public void lerDados(){
        EntityManager em = JPAUtil.getEntityManager();
        
        Funcionario fun = new Funcionario();
        fun.setNome("Eduardo");
        fun.setEndereco("rua x");
        fun.setCpf("46587987");
        fun.setTelefone("9234 4345");
        
        
        em.getTransaction().begin();
        DAOJPA<Funcionario> dao = new DAOJPA<>(em,Funcionario.class);
        dao.Inserir(fun);
        em.getTransaction().commit();
        em.close();   
    }
    public static void main(String[] args){
        TesteFuncionario tf = new TesteFuncionario();
        tf.lerDados();
    }
}
