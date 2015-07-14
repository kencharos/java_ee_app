package jp.co.ulsystems.app.jsf.welcome;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * ようこそ画面のアクション
 * 初期処理のみを記述
 * 
 * Viewの初期化処理は、リダイレクト時はリダイレクト対象のViewの初期化イベントを記載する必要がある。
 */
@RequestScoped
@Named
public class WelcomeAction {

    private List<String> notifications;
    
    /**
     * View の初期化処理
     */
    public void init() {
        System.out.println("WelcomeAction init..");
        notifications = new ArrayList<>();
        notifications.add("This is JSF sample");
        notifications.add("note..");
    }

    public List<String> getNotifications() {
        return notifications;
    }
    
    
}
