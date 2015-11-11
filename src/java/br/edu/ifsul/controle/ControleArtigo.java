package br.edu.ifsul.controle;

import br.edu.ifsul.dao.ArtigoDAO;
import br.edu.ifsul.modelo.Artigo;
import br.edu.ifsul.uteis.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "controleArtigo")
@SessionScoped
public class ControleArtigo implements Serializable {
    
    @EJB
    private ArtigoDAO dao;
    private Artigo objeto;
       
    public ControleArtigo() {
        
    }
    
    public String listar() {
        return "/privado/artigo/listar?faces-redirect=true";
    }
    
    public String novo() {
        objeto = new Artigo();
        return "formulario";
    }
    
    public String salvar() {
        try {
            if (objeto.getId() == null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso");
            return "listar";
        } catch (Exception e){
            Util.mensagemErro("Erro ao persistir objeto: "+e.getMessage());
            return "formulario";
        }
    }
    
    public String cancelar(){
        return "listar";
    }
    
    public String editar(Integer id){
        try {
            objeto = dao.getObjectById(id);
            return "formulario";
        } catch(Exception e){
            Util.mensagemErro("Erro ao recuperar objeto: "+e.getMessage());
            return "listar";
        }
    }
    
    public void remover(Integer id){
        try {
            objeto = dao.getObjectById(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto excluído com sucesso");
        } catch (Exception e){
            Util.mensagemErro("Erro ao remover objeto: "+
                    Util.getMensagemErro(e));
        }        
    }
    
    
    public ArtigoDAO getDao() {
        return dao;
    }
    
    public void setDao(ArtigoDAO dao) {
        this.dao = dao;
    }
    
    public Artigo getObjeto() {
        return objeto;
    }
    
    public void setObjeto(Artigo objeto) {
        this.objeto = objeto;
    }


  
}
