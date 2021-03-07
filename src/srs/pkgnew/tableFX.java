package srs.pkgnew;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class tableFX {

    protected TableView<courseData> table = new TableView<>();
    protected ObservableList<courseData> data = FXCollections.observableArrayList();
    private static Connection conn = connect.getConnection();
    String head = "--------可選課程的信息-------";
    String first = "course ID";
    String second = "course";
    String third = "professor";
    GridPane grid = new GridPane();
    VBox vbox = new VBox();
    Scene scene = new Scene(grid, 280, 450);
    Stage primaryStage = new Stage();
    Text title = new Text(head);
    public tableFX() throws SQLException {

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
       
        primaryStage.setScene(scene);

        StackPane p = new StackPane();
        p.getChildren().add(title);
        StackPane.setAlignment(title, Pos.TOP_CENTER);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.setSpacing(5);
        grid.add(p, 0, 0);
        grid.add(vbox, 0, 1);
        primaryStage.show();
    }

    public void List() throws SQLException {
        Statement stat2;
        ResultSet rs2;
        try {
            stat2 = conn.createStatement();
            rs2 = stat2.executeQuery("select * from course");
            while (rs2.next()) {
                int courseID = rs2.getInt("courseID");//從數據庫讀取資料，顯示課程內容
                String courseName = rs2.getString("coursename");
                String Professor = rs2.getString("professor");
                data.add(new courseData(courseID, courseName, Professor));
            }
            stat2.close();
            rs2.close();
        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

    public static class courseData {

        private final SimpleIntegerProperty courseID;
        private final SimpleStringProperty course;
        private final SimpleStringProperty professor;

        private courseData(int ID, String lesson, String professor) {
            this.courseID = new SimpleIntegerProperty(ID);
            this.course = new SimpleStringProperty(lesson);
            this.professor = new SimpleStringProperty(professor);
        }

        public int getID() {
            return courseID.get();
        }

        public void setID(int ID) {
            courseID.set(ID);
        }

        public String getCourse() {
            return course.get();
        }

        public void setCourse(String lesson) {
            course.set(lesson);
        }

        public String getProfessor() {
            return professor.get();
        }

        public void setProfessor(String teacher) {
            professor.set(teacher);
        }
    }
}
