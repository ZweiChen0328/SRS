package srs.pkgnew;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Option {

    GridPane grid = new GridPane();
    Scene scene = new Scene(grid, 300, 275);
    Stage primaryStage = new Stage();
    Label label = new Label();
    TextField account = new TextField();
    Label label2 = new Label("所屬系籍:");
    TextField department = new TextField();
    Label label3 = new Label("新學生:");
    TextField name = new TextField();
    Button btn = new Button("寫入檔案");
    Text title = new Text();
    Text text = new Text();
    HBox hbBtn = new HBox(btn);

    public Option() {
        title.setFont(Font.font("Serif", FontWeight.NORMAL, 20));
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.add(title, 0, 0, 2, 1);
        grid.add(hbBtn, 0, 5);
        grid.add(label, 0, 1);
        grid.add(account, 1, 1);
        grid.add(label2, 0, 2);
        grid.add(department, 1, 2);
        grid.add(label3, 0, 3);
        grid.add(name, 1, 3);
        grid.add(text, 1, 4);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
