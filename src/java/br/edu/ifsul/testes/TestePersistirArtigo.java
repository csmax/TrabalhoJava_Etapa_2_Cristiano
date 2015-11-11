package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Artigo;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public class TestePersistirArtigo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("TrabalhoJava_Etapa_2_CristianoPU");
            em = emf.createEntityManager();
            Artigo e = new Artigo();
            e.setTitulo("ArdHouse");
            e.setAutor("Cristiano Fontana");
            e.setAnoPublicacao(Calendar.getInstance());
            e.setQualis("B1");
            e.setAssunto("Automação Residencial");
          
            // chamando a validação
            Validator validador
                    = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Artigo>> erros = validador.validate(e);
            if (erros.size() > 0) {
                for (ConstraintViolation<Artigo> erro : erros){
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
