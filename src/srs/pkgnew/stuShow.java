package srs.pkgnew;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.Node;

public class stuShow extends FileFX {

    private static Connection conn = connect.getConnection();

    public void show(String ID) throws SQLException {
        grid.add(back, 0, 4);
        back.setOnAction(e -> {
            try {
                ((Node) (e.getSource())).getScene().getWindow().hide();
                MenuStudent a = new MenuStudent();
                a.newWindow(ID);
            } catch (java.sql.SQLException b) {
            }
        });
        Statement stat3;
        ResultSet rs3;
        try {
            stat3 = conn.createStatement();
            rs3 = stat3.executeQuery("select * from studentfile ");
            while (rs3.next()) {
                String stuID = rs3.getString("ID");
                if (ID.equals(stuID)) {
                    String stu = rs3.getString("studentname");
                    String dep = rs3.getString("department");
                    id.setText(stuID);
                    name.setText(stu);
                    department.setText(dep);
                    break;
                }
            }
        } catch (java.sql.SQLException b) {
        }
    }
}
