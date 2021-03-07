package srs.pkgnew;

import java.sql.SQLException;
import javafx.scene.Node;

public class LoginM extends LoginFX {

    public void newWindow() throws SQLException {
        title.setText("Manager Login");
        btn.setOnAction(e -> {
            Manager pro = new Manager();
            try {
                String id = account.getText().trim();
                String password = pass.getText().trim();
                boolean judge = pro.professorLogin(id, password);
                if (judge) {
                    text.setText("Login Successful!");
                    ((Node) (e.getSource())).getScene().getWindow().hide();
                    MenuManager a = new MenuManager();
                    a.newWindow(id);
                } else {
                    text.setText("The ID or Password is wrong!");
                }
            } catch (java.sql.SQLException b) {
            }
        });
    }
}
