package srs.pkgnew;

import java.sql.Connection;
import java.sql.SQLException;
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

public class password {

    private static Connection conn = connect.getConnection();//連接數據庫

    public password(String ID,String work) throws SQLException {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        Scene scene = new Scene(grid, 300, 275);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);

        Label label = new Label("新密碼:");
        TextField pass = new TextField();
        Button btn = new Button("修改");
        HBox hbBtn = new HBox(btn);
        Button back = new Button("back");
        hbBtn.getChildren().add(back);
        hbBtn.setAlignment(Pos.BOTTOM_LEFT);
        Text text = new Text();

        grid.add(hbBtn, 1, 4);
        grid.add(label, 0, 1);
        grid.add(pass, 1, 1);
        grid.add(text, 1, 2);
        btn.setOnAction(e -> {
            try {
                String password = pass.getText().trim();
                Student student = new Student();
                boolean change = student.changePassword(ID, password);
                if (change) {
                    text.setText("修改成功");
                } else {
                    text.setText("修改失敗");
                }
            } catch (java.sql.SQLException b) {
            }
        });
        back.setOnAction(e -> {
            try {
                if(work.equals("Student")){
                    ((Node) (e.getSource())).getScene().getWindow().hide();
                    MenuStudent a = new MenuStudent();
                    a.newWindow(ID);
                }else if(work.equals("Manager")){
                    ((Node) (e.getSource())).getScene().getWindow().hide();
                    MenuManager a = new MenuManager();
                    a.newWindow(ID);
                }
            } catch (java.sql.SQLException b) {
            }
        });
        primaryStage.setTitle("LoginFX");
        primaryStage.show();
    }
}
