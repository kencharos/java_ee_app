/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ulsystems.app.jsf.login;

import java.io.Serializable;
import java.security.Principal;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 * ログイン済みユーザー
 */
@Named
@SessionScoped
public class User implements Serializable{

    /** ログイン情報 */
    private Principal principal;
    
    /** id */
    private String id;

    /** ログイン判定 */
    public boolean isLogin() {
        return principal != null;
    }
    
    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
}
