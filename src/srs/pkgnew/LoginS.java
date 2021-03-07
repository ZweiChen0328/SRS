package srs.pkgnew;

import java.sql.SQLException;
import javafx.scene.Node;

public class LoginS extends LoginFX {

    public void newWindow() throws SQLException {
        title.setText("Student Login");
        btn.setOnAction(e -> {
            Student stu = new Student();
            try {
                String id = account.getText().trim();
                String password = pass.getText().trim();
                boolean judge = stu.studentLogin(id, password);
                if (judge) {
                    text.setText("Login Successful!");
                    ((Node) (e.getSource())).getScene().getWindow().hide();
                    MenuStudent a = new MenuStudent();
                    a.newWindow(id);
                } else {
                    text.setText("The ID or Password is wrong!");
                }
            } catch (java.sql.SQLException b) {
            }
        });
    }
}
