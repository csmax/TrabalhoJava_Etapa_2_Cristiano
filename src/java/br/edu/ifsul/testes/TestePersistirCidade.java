package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public class TestePersistirCidade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("TrabalhoJava_Etapa_2_CristianoPU");
            em = emf.createEntityManager();
            Cidade e = new Cidade();
            e.setNome("Santa Catarina");
          
            // chamando a validação
            Validator validador
                    = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Cidade>> erros = validador.validate(e);
            if (erros.size() > 0) {
                for (ConstraintViolation<Cidade> erro : erros){
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
