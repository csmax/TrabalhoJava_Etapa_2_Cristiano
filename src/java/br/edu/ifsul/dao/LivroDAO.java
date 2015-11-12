
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Livro;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class LivroDAO implements Serializable {

    @PersistenceContext(unitName = "TrabalhoJava_Etapa_2_CristianoPU")
    private EntityManager em;
    private List<Livro> listarTodos;

    public LivroDAO(){
        
    }
    
    public void persist(Livro obj) throws Exception {
        em.persist(obj);
    }
    
    public void merge(Livro obj) throws Exception {
        em.merge(obj);
    }    
    
    public void remove(Livro obj) throws Exception {
        obj = em.merge(obj);
        em.remove(obj);
    }
    
    public Livro getObjectById(Integer id) throws Exception {
        return (Livro) em.find(Livro.class, id);
    }    
    
    public List<Livro> getListarTodos() {
        return em.createQuery("from Livro").getResultList();
    
    }
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }



    public void setListarTodos(List<Livro> listarTodos) {
        this.listarTodos = listarTodos;
    }
}
