package srs.pkgnew;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuFX {

    Button b1 = new Button();
    Button b2 = new Button();
    Button b3 = new Button();
    Button b4 = new Button();
    Button b5 = new Button("back");

    public MenuFX() {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        Scene scene = new Scene(grid, 300, 275);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);

        StackPane p = new StackPane();
        Text title = new Text("---------option-----------");
        p.getChildren().add(title);
        StackPane.setAlignment(title, Pos.TOP_CENTER);

        VBox v = new VBox();
        v.setPadding(new Insets(10, 10, 10, 10));
        v.setSpacing(10);
        v.getChildren().addAll(b1, b2, b3, b4,b5);
        v.setAlignment(Pos.BOTTOM_LEFT);
        grid.add(p, 0, 0);
        grid.add(v, 0, 1);
        primaryStage.setTitle("Function");
        primaryStage.show();
    }
}
