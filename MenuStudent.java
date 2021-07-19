package srs.pkgnew;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

public class MenuStudent extends MenuFX {
    
    public void newWindow(String id) throws SQLException {
        b1.setText("Change password");
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    new password(id,"Student");
                } catch (java.sql.SQLException b) {
                }
                ((Node) (event.getSource())).getScene().getWindow().hide();
            }
        });
        b2.setText("Choose course");
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    new CourseFX(id);
                } catch (java.sql.SQLException b) {
                }
                ((Node) (event.getSource())).getScene().getWindow().hide();
            }
        });
        b3.setText("Get course list");
        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    new myList(id);
                } catch (java.sql.SQLException b) {
                }
                ((Node) (event.getSource())).getScene().getWindow().hide();
            }
        });
        b4.setText("查看個人資料");
        b4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stuShow a = new stuShow();
                try {
                    a.show(id);
                } catch (java.sql.SQLException b) {
                }
                ((Node) (event.getSource())).getScene().getWindow().hide();
            }
        }
        );
        b5.setOnAction(new EventHandler<ActionEvent>() {
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
    }
}
