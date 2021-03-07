package srs.pkgnew;

import java.sql.SQLException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OptionFX {

    public void newWindow(String id) throws SQLException {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        Scene scene = new Scene(grid, 300, 275);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);

        Text title = new Text(" Student file (功能選擇)");
        title.setFont(Font.font("Serif", FontWeight.NORMAL, 20));
        grid.add(title, 0, 0, 2, 1);

        Button btnC = new Button("Create");
        Button btnD = new Button("Delete");
        Button btnM = new Button("Modify");
        Button back = new Button("back");

        VBox v = new VBox();
        v.setPadding(new Insets(10, 10, 10, 10));
        v.setSpacing(10);
        v.getChildren().addAll(btnC, btnD, btnM, back);
        v.setAlignment(Pos.BOTTOM_LEFT);
        grid.add(v, 0, 1);
        btnC.setOnAction(e -> {
            CreateFX stageC = new CreateFX();
            try {
                stageC.newWindow();
                ((Node) (e.getSource())).getScene().getWindow().hide();
            } catch (java.sql.SQLException b) {
            }
        });
        btnD.setOnAction(e -> {
            DeleteFX stageD = new DeleteFX();
            try {
                stageD.newWindow();
                ((Node) (e.getSource())).getScene().getWindow().hide();
            } catch (java.sql.SQLException b) {
            }
        });
        btnM.setOnAction(e -> {
            ModifyFX stageM = new ModifyFX();
            try {
                stageM.newWindow();
                ((Node) (e.getSource())).getScene().getWindow().hide();
            } catch (java.sql.SQLException b) {
            }
        });
        back.setOnAction(e -> {
            try {
                ((Node) (e.getSource())).getScene().getWindow().hide();
                MenuManager a = new MenuManager();
                a.newWindow(id);
            } catch (java.sql.SQLException b) {
            }
        });
        primaryStage.setTitle("OptionFx");
        primaryStage.show();
    }
}
