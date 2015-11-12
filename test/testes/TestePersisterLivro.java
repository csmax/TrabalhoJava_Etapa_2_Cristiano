/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import br.edu.ifsul.modelo.Livro;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class TestePersisterLivro {
    EntityManagerFactory emf;
    EntityManager em;
    public TestePersisterLivro() {
    }
    
   
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TrabalhoJava_Etapa_2_CristianoPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
    em.close();
        emf.close();
        
    }

    @Test
    public void teste(){
        boolean exception = false;
        try {
            Livro e = new Livro();
          
            e.setAutor("Cristiano FOntana");
            e.setTitulo("ArdHouse controle de cargas e mensuramento de corrente");
            e.setDisopnibilidade(true);
            e.setQuantidade(20);
            e.setValor(22.00);
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        } catch (Exception e){
            exception = true;
            e.printStackTrace();
        }
        // verificar se o resultado foi o esperado
        Assert.assertEquals(false, exception);
        
    }   
}


