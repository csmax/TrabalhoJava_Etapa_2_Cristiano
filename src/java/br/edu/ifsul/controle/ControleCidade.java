package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CidadeDAO;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.uteis.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "controleCidade")
@SessionScoped
public class ControleCidade implements Serializable {
    
    @EJB
    private CidadeDAO dao;
    private Cidade objeto;
       
    public ControleCidade() {
        
    }
    
    public String listar() {
        return "/privado/cidade/listar?faces-redirect=true";
    }
    
    public String novo() {
        objeto = new Cidade();
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
    
    
    public CidadeDAO getDao() {
        return dao;
    }
    
    public void setDao(CidadeDAO dao) {
        this.dao = dao;
    }
    
    public Cidade getObjeto() {
        return objeto;
    }
    
    public void setObjeto(Cidade objeto) {
        this.objeto = objeto;
    }


  
}
