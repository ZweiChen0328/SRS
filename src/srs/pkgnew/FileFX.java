package srs.pkgnew;

import java.sql.SQLException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public abstract class FileFX {

    Label label = new Label("帳號:");
    Text id = new Text();
    Label label2 = new Label("姓名:");
    Text name = new Text();
    Label label3 = new Label("系級:");
    Text department = new Text();
    Button back = new Button("back");
    GridPane grid = new GridPane();

    public FileFX() {

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        Scene scene = new Scene(grid, 300, 275);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        grid.add(label, 0, 1);
        grid.add(id, 1, 1);
        grid.add(label2, 0, 2);
        grid.add(name, 1, 2);
        grid.add(label3, 0, 3);
        grid.add(department, 1, 3);
        primaryStage.setTitle("FileFX");
        primaryStage.show();
    }

    public abstract void show(String ID) throws SQLException;
}
