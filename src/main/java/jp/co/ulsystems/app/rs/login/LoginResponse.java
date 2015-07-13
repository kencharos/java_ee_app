package jp.co.ulsystems.app.rs.login;

import javax.validation.constraints.Size;

/**
 * ログインリクエスト
 */
public class LoginResponse {

    public String user;
    
    public String next;
    
    public String token;

    public LoginResponse() {
    }

    public LoginResponse(String user, String token, String next) {
        this.user = user;
        this.token = token;
        this.next = next;
    }
}
