package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Livro;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public class TestePersistirLivro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("TrabalhoJava_Etapa_2_CristianoPU");
            em = emf.createEntityManager();
            Livro e = new Livro();
            e.setTitulo("ArdHouse");
            e.setAutor("Cristiano Fontana");
            e.setDisopnibilidade(true);
            e.setQuantidade(12);
            e.setValor(22.12);
          
            // chamando a validação
            Validator validador
                    = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Livro>> erros = validador.validate(e);
            if (erros.size() > 0) {
                for (ConstraintViolation<Livro> erro : erros){
                    System.out.println("Erro: "+erro.getMessage());
                }
            } else {
                em.getTransaction().begin();
                em.persist(e);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }

    }

}
