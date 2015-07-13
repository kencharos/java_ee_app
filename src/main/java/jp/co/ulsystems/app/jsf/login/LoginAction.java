/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ulsystems.app.jsf.login;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * ログインバッキングBean
 */
@RequestScoped
@Named
public class LoginAction {

    @NotNull
    @Size(min = 1)
    private String id;
    
    @NotNull
    @Size(min = 1)
    private String password;
    
    @Inject
    private HttpServletRequest req;
    
    @Inject
    private User user;
    
    
    
    public String login() {
        
        try {
            req.login(id, password);
            
            user.setPrincipal(req.getUserPrincipal());
            user.setId(req.getUserPrincipal().getName());
            
            return "/views/products.xhtml?faces-redirect=true";
        } catch (ServletException e) {
            
            if (req.getUserPrincipal() != null) {
                return "/views/products.xhtml?faces-redirect=true";
            }
            
            FacesContext.getCurrentInstance().addMessage("error", 
                    new FacesMessage("Invalid id or password."));
            // 自画面再表示は null リターン。
            return null;
        }
    }
    
    public String logout() {
        
        try {
            req.logout();
        } catch (ServletException ex) {
            throw new RuntimeException(ex);
        }
        user.setPrincipal(null);
        user.setId(null);
        req.getSession().invalidate();
        return "/views/login.xhtml?faces-redirect=true";
        
    }
    
    
    // accsessor
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
