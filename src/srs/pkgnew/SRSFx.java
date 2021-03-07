package srs.pkgnew;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SRSFx extends Application {

    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        
        Text title = new Text(" SRS (身分選擇)");
        title.setFont(Font.font("Serif", FontWeight.NORMAL, 20));
        grid.add(title, 0, 0, 2, 1);

        Button btnM = new Button("Manager");
        HBox Mbtn = new HBox(btnM);
        Mbtn.setAlignment(Pos.BOTTOM_LEFT);
        grid.add(Mbtn, 0, 1);

        Button btnS = new Button("Student");
        HBox Sbtn = new HBox(btnS);
        Sbtn.setAlignment(Pos.BOTTOM_RIGHT);
        grid.add(Sbtn, 1, 1);
        
        btnM.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
             LoginM stageM = new LoginM();
                try {
                    stageM.newWindow();
                } catch (SQLException ex) {
                    Logger.getLogger(SRSFx.class.getName()).log(Level.SEVERE, null, ex);
                }
                ((Node) (event.getSource())).getScene().getWindow().hide();
            }
        });
        
        btnS.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoginS stageS = new LoginS();
                try {
                    stageS.newWindow();
                } catch (SQLException ex) {
                    Logger.getLogger(SRSFx.class.getName()).log(Level.SEVERE, null, ex);
                }
                ((Node) (event.getSource())).getScene().getWindow().hide();
            }
        });
        primaryStage.setTitle("SRSFx");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
