package br.edu.ifsul.controle;

import br.edu.ifsul.dao.LivroDAO;
import br.edu.ifsul.modelo.Livro;
import br.edu.ifsul.uteis.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "controleLivro")
@SessionScoped
public class ControleLivro implements Serializable {
    
    @EJB
    private LivroDAO dao;
    private Livro objeto;
       
    public ControleLivro() {
        
    }
    
    public String listar() {
        return "/privado/artigo/listar?faces-redirect=true";
    }
    
    public String novo() {
        objeto = new Livro();
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
    
    
    public LivroDAO getDao() {
        return dao;
    }
    
    public void setDao(LivroDAO dao) {
        this.dao = dao;
    }
    
    public Livro getObjeto() {
        return objeto;
    }
    
    public void setObjeto(Livro objeto) {
        this.objeto = objeto;
    }


  
}
