package br.com.apisys.app.bean;

import br.com.apisys.app.dao.UsuarioDAO;
import br.com.apisys.app.entity.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UsuarioBean {
    
    Usuario user;
    String acao;
    
    public UsuarioBean(){
        if(user==null)
            user = new Usuario();
        
        if(acao==null)
            acao = "Cadastrar";
    }
    
    public String processar(){
        System.out.println("Acao: " + acao);
        if(acao.equals("Cadastrar"))
            return criar();
        else
            return editar();
    }
    
    public String criar() {
        UsuarioDAO dao = new UsuarioDAO();
        dao.save(user);
        clean();
        return "index.jsf";
    }
    
    public String editar(){
        UsuarioDAO dao = new UsuarioDAO();
        System.out.println("User: " + user.getId());
        dao.update(user);
        clean();
        return "index.jsf";
    }
    
    public List<Usuario> listarUsuarios(){
        UsuarioDAO dao =  new UsuarioDAO();
        return dao.list();
    }
    
    public String entrarEditar(Usuario usuario){
        this.user = usuario;
        this.acao = "Editar";
        return "index.jsf";
    }
    
    public String remover(Usuario usuario){
        UsuarioDAO dao = new UsuarioDAO();
        dao.remove(usuario);
        return "index.jsf";
    }
    
    private void clean() {
        user = new Usuario();
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getAcao() {
        return acao;
    }
    
}