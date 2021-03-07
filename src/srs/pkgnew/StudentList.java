package srs.pkgnew;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class StudentList extends tableFX {

    private static Connection conn = connect.getConnection();
    private final TableView<studentData> table2 = new TableView<>();
    private final ObservableList<studentData> data2 = FXCollections.observableArrayList();
    Text text = new Text();
    Label label = new Label("修課人數:");

    public StudentList(int id) throws SQLException {
        super.head = "--------選課學生的信息-------";
        title.setText(head);
        super.first = "StudentID";
        super.second = "StudentName";
        super.third = "Department";
        TableColumn IDCol = new TableColumn(first);
        TableColumn nameCol = new TableColumn(second);
        TableColumn depCol = new TableColumn(third);

        IDCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        depCol.setCellValueFactory(new PropertyValueFactory<>("department"));
        List(id);
        
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.setSpacing(5);
        hbox.getChildren().addAll(label,text);
                
        grid.add(hbox, 0, 2);
        table2.setEditable(true);
        table2.setItems(data2);
        table2.getColumns().addAll(IDCol, nameCol, depCol);
        vbox.getChildren().add(table2);
        primaryStage.setTitle("myList");
        primaryStage.show();
    }

    public void List(int courseID) throws SQLException {
        Statement stat2;
        ResultSet rs, rs2;
        int i = 0;
        try {
            stat2 = conn.createStatement();
            rs2 = stat2.executeQuery("select * from stuCourse");
            while (rs2.next()) {
                int haveExist = rs2.getInt("courseID");
                if (courseID == haveExist) {//判斷是否有登入資料
                    String studentID = rs2.getString("studentID");//從數據庫讀取資料，顯示課程內容
                    rs = stat2.executeQuery("select * from studentfile");
                    while (rs.next()) {
                        String ID = rs.getString("ID");
                        if (studentID.equals(ID)) {
                            String StudentName = rs.getString("studentname");
                            String Department = rs.getString("Department");
                            data2.add(new studentData(ID, StudentName, Department));
                            i++;
                        }
                    }
                }
            }
            text.setText(Integer.toString(i));
            stat2.close();
            rs2.close();
        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

    public static class studentData {

        private final SimpleStringProperty stuID;
        private final SimpleStringProperty stuName;
        private final SimpleStringProperty department;

        private studentData(String ID, String name, String major) {
            this.stuID = new SimpleStringProperty(ID);
            this.stuName = new SimpleStringProperty(name);
            this.department = new SimpleStringProperty(major);
        }

        public String getID() {
            return stuID.get();
        }

        public void setID(String ID) {
            stuID.set(ID);
        }

        public String getName() {
            return stuName.get();
        }

        public void setName(String name) {
            stuName.set(name);
        }

        public String getDepartment() {
            return department.get();
        }

        public void setProfessor(String major) {
            department.set(major);
        }
    }
}
