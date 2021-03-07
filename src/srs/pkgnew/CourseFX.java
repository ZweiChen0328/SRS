package srs.pkgnew;

import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class CourseFX extends tableFX {

    Label label = new Label("請輸入課程代碼:");
    TextField inputCourse = new TextField();
    Button btnAdd = new Button("選入");
    Button btnDel = new Button("退選");
    Button back = new Button("back");
    Text text = new Text();

    public CourseFX(String id) throws SQLException {
        
        TableColumn IDCol = new TableColumn(first);
        TableColumn couCol = new TableColumn(second);
        TableColumn proCol = new TableColumn(third);
        IDCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        couCol.setCellValueFactory(new PropertyValueFactory<>("course"));
        proCol.setCellValueFactory(new PropertyValueFactory<>("professor"));
        //proCol.setMinWidth(100);
        //proCol.setPrefWidth(100);
        //proCol.setMaxWidth(100);
        grid.add(label, 0, 2);
        grid.add(inputCourse, 0, 3);
        grid.add(btnAdd, 0, 4);
        grid.add(btnDel, 0, 5);
        grid.add(back, 0, 6);
        grid.add(text, 0, 7);
        List();
        table.setEditable(true);
        table.setItems(data);
        table.getColumns().addAll(IDCol, couCol, proCol);
        table.setColumnResizePolicy(table.CONSTRAINED_RESIZE_POLICY);
        vbox.getChildren().add(table);
        Course stu = new Course();
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    int couID = Integer.parseInt(inputCourse.getText().trim());
                    int judge = stu.chooseCourse(id, couID);
                    if (judge == 1) {
                        text.setText("已選入課表");
                    } else if (judge == 2) {
                        text.setText("成功選入課程");
                    } else {
                        text.setText("選課失敗");
                    }
                } catch (java.sql.SQLException b) {
                }
            }
        });
        btnDel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    int couID = Integer.parseInt(inputCourse.getText().trim());
                    boolean judge = stu.deleteCourse(id, couID);
                    if (judge) {
                        text.setText("成功刪除");
                    } else {
                        text.setText("刪除失敗");
                    }
                } catch (java.sql.SQLException b) {
                }
            }
        });
        back.setOnAction(e -> {
            try {
                ((Node) (e.getSource())).getScene().getWindow().hide();
                MenuStudent a = new MenuStudent();
                a.newWindow(id);
            } catch (java.sql.SQLException b) {
            }
        });
        primaryStage.setTitle("ChooseCourse");
    }
}
