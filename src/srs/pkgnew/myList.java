package srs.pkgnew;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class myList extends tableFX {

    private static Connection conn = connect.getConnection();
    private final TableView<courseData> table2 = new TableView<>();
    private final ObservableList<courseData> data2 = FXCollections.observableArrayList();

    public myList(String id) throws SQLException {
        super.head = "--------已選課程的信息-------";
        title.setText(head);
        TableColumn IDCol = new TableColumn(first);
        TableColumn couCol = new TableColumn(second);
        TableColumn proCol = new TableColumn(third);
        proCol.setMinWidth(100);
        proCol.setPrefWidth(100);
        proCol.setMaxWidth(100);
        IDCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        couCol.setCellValueFactory(new PropertyValueFactory<>("course"));
        proCol.setCellValueFactory(new PropertyValueFactory<>("professor"));

        List(id);

        table2.setEditable(true);
        table2.setItems(data2);
        table2.getColumns().addAll(IDCol, couCol, proCol);
        table2.setColumnResizePolicy(table.CONSTRAINED_RESIZE_POLICY);
        vbox.getChildren().add(table2);
        Button back = new Button("back");
        grid.add(back, 0, 2);
        back.setOnAction(e -> {
            try {
                ((Node) (e.getSource())).getScene().getWindow().hide();
                MenuStudent a = new MenuStudent();
                a.newWindow(id);
            } catch (java.sql.SQLException b) {
            }
        });
        primaryStage.setTitle("myList");
        primaryStage.show();
    }

    public void List(String ID) throws SQLException {
        Statement stat2;
        ResultSet rs, rs2;
        try {
            stat2 = conn.createStatement();
            rs2 = stat2.executeQuery("select * from stuCourse");
            while (rs2.next()) {
                String studentID = rs2.getString("studentID");
                if (ID.equals(studentID)) {//判斷是否有登入資料
                    int haveExist = rs2.getInt("courseID");//從數據庫讀取資料，顯示課程內容
                    rs = stat2.executeQuery("select * from course");
                    while (rs.next()) {
                        int courseID = rs.getInt("courseID");
                        if (haveExist == courseID) {
                            String courseName = rs.getString("coursename");
                            String Professor = rs.getString("professor");
                            data2.add(new courseData(courseID, courseName, Professor));
                        }
                    }
                }
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
