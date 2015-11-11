
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Artigo;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class ArtigoDAO implements Serializable {

    @PersistenceContext(unitName = "TrabalhoJava_Etapa_2_CristianoPU")
    private EntityManager em;
    private List<Artigo> listarTodos;

    public ArtigoDAO(){
        
    }
    
    public void persist(Artigo obj) throws Exception {
        em.persist(obj);
    }
    
    public void merge(Artigo obj) throws Exception {
        em.merge(obj);
    }    
    
    public void remove(Artigo obj) throws Exception {
        obj = em.merge(obj);
        em.remove(obj);
    }
    
    public Artigo getObjectById(Integer id) throws Exception {
        return (Artigo) em.find(Artigo.class, id);
    }    
    
    public List<Artigo> getListarTodos() {
        return em.createQuery("from Artigo").getResultList();
    
    }
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }



    public void setListarTodos(List<Artigo> listarTodos) {
        this.listarTodos = listarTodos;
    }
}
