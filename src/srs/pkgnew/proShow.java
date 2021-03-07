package srs.pkgnew;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.Node;

public class proShow extends FileFX {

    private static Connection conn = connect.getConnection();

    public void show(String ID) throws SQLException {
        grid.add(back, 0, 4);
        back.setOnAction(e -> {
            try {
                ((Node) (e.getSource())).getScene().getWindow().hide();
                MenuManager a = new MenuManager();
                a.newWindow(ID);
            } catch (java.sql.SQLException b) {
            }
        });
        Statement stat3;
        ResultSet rs3;
        try {
            stat3 = conn.createStatement();
            rs3 = stat3.executeQuery("select * from professorFile ");
            while (rs3.next()) {
                String proID = rs3.getString("ID");
                if (ID.equals(proID)) {
                    String pro = rs3.getString("professorName");
                    String dep = rs3.getString("department");
                    id.setText(ID);
                    name.setText(pro);
                    department.setText(dep);
                    break;
                }
            }
        } catch (java.sql.SQLException b) {
        }
    }
}
