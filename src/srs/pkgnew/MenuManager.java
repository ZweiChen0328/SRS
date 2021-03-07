package srs.pkgnew;

import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Node;

public class MenuManager extends MenuFX {

    public void newWindow(String id) throws SQLException {
        b1.setText("Change password");
        b1.setOnAction(e -> {
            try {
                new password(id);
            } catch (java.sql.SQLException b) {
            }
            ((Node) (e.getSource())).getScene().getWindow().hide();
        });
        b2.setText("Student file");
        b2.setOnAction(e -> {
            OptionFX stageO = new OptionFX();
            try {
                stageO.newWindow(id);
            } catch (java.sql.SQLException b) {
            }
            ((Node) (e.getSource())).getScene().getWindow().hide();
        });
        b3.setText("查看選課學生名單");
        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkCourseFX check = new checkCourseFX();
                try {
                    check.newWindow(id);
                } catch (java.sql.SQLException b) {
                }
                ((Node) (event.getSource())).getScene().getWindow().hide();
            }
        });
        b4.setText("查看個人資料");
        b4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                proShow a = new proShow();
                try {
                    a.show(id);
                } catch (java.sql.SQLException b) {
                }
                ((Node) (event.getSource())).getScene().getWindow().hide();
            }
        }
        );
        b5.setOnAction(
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event
            ) {
                ((Node) (event.getSource())).getScene().getWindow().hide();
            }
        }
        );
    }
}
