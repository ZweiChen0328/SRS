package srs.pkgnew;

import java.sql.SQLException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DeleteFX {

    public void newWindow() throws SQLException {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        Scene scene = new Scene(grid, 300, 275);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        
        Label label = new Label("學生學號");
        TextField account = new TextField();
        Text text = new Text();
        Button btn = new Button("刪除");
        
        grid.add(label, 0, 1);
        grid.add(account, 1, 1);
        grid.add(text, 0, 2);
        grid.add(btn, 0, 3);
        btn.setOnAction(e -> {
            try {
                String id = account.getText().trim();
                File freshman = new File();
                boolean judge = freshman.deleteFile(id);
                if (judge) {
                    text.setText("Delete Successful!");
                } else {
                    text.setText("Delete Failure!");
                }
            } catch (java.sql.SQLException b) {
            }
        });
        primaryStage.setScene(scene);
        primaryStage.setTitle("CreateFX");
        primaryStage.show();
    }
}
