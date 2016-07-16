package br.com.apisys.app.bean;

import br.com.apisys.app.entity.User;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class UserBean {
    
    User user = new User();
    
    public void create() {
        System.out.println(user.toString());
        clean();
    }
    
    private void clean() {
        user = new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}