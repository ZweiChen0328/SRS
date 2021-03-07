package srs.pkgnew;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class checkCourseFX {

    private static Connection conn = connect.getConnection();//連接數據庫

    public void newWindow(String ID) throws SQLException {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        Scene scene = new Scene(grid, 300, 275);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);

        Label label = new Label("課程代碼:");
        TextField pass = new TextField();
        Button btn = new Button("查看課程");
        HBox hbBtn = new HBox(btn);
        Button back = new Button("back");
        hbBtn.getChildren().add(back);
        hbBtn.setAlignment(Pos.BOTTOM_LEFT);
        Text text = new Text();

        grid.add(hbBtn, 1, 4);
        grid.add(label, 0, 1);
        grid.add(pass, 1, 1);
        grid.add(text, 1, 2);
        back.setOnAction(e -> {
            try {
                ((Node) (e.getSource())).getScene().getWindow().hide();
                MenuManager a = new MenuManager();
                a.newWindow(ID);
            } catch (java.sql.SQLException b) {
            }
        });
        btn.setOnAction(e -> {
            int code = Integer.parseInt(pass.getText().trim());
            try {
                new StudentList(code);
            } catch (java.sql.SQLException b) {
            }
        });
        primaryStage.setTitle("LoginFX");
        primaryStage.show();
    }

    public boolean changePassword(String ID, String pass) throws SQLException {
        Statement stat;
        ResultSet rs;
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from studentfile");
            while (rs.next()) {
                String student = rs.getString("ID");//將數據庫的資料，存入變數中
                if (ID.equals(student)) {//判斷是否有登入資料
                    stat.executeUpdate("UPDATE studentfile SET Password ='" + pass + "' WHERE ID='" + ID + "'");
                    return true;
                }
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }
}
