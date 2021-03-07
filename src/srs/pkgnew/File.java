package srs.pkgnew;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class File {
 private static Connection conn = connect.getConnection();//連接數據庫
    protected String id;//學號
    protected String name;
    protected String department;//系級
    protected String inputPassword;

    public File() {
        this.id = "";
        this.name = "";
        this.department = "";
    }

    public File(String id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean createFile() throws SQLException {
        if (id.equals("") || name.equals("") || department.equals("")) {
            return false;
        } else {
            Statement stat;
            ResultSet rs;
            try {
                stat = conn.createStatement();
                rs = stat.executeQuery("select * from studentfile");
                while (rs.next()) {
                    String ID = rs.getString("ID");
                    if (id.equals(ID)) {
                        return false;
                    }
                }
                stat.executeUpdate("INSERT INTO studentfile (ID, studentname, department) VALUES ('" + id + "','" + name + "','" + department + "')");
                return true;
            } catch (SQLException error) {
                error.printStackTrace();
            }
        }
        return false;
    }

    public boolean deleteFile(String ID) throws SQLException {
        Statement stat;
        ResultSet rs;
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from studentfile");
            while (rs.next()) {
                String student = rs.getString("ID");//將數據庫的資料，存入變數中
                if (ID.equals(student)) {//判斷是否有登入資料
                    stat.executeUpdate("DELETE FROM studentfile WHERE ID = '" + ID + "' ");
                    return true;
                }
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }

    public boolean modifyFile() throws SQLException {
        if (id.equals("") || name.equals("") || department.equals("")) {
            return false;
        } else {
            Statement stat;
            ResultSet rs;
            try {
                stat = conn.createStatement();
                rs = stat.executeQuery("select * from studentfile");
                while (rs.next()) {
                    String ID = rs.getString("ID");
                    if (id.equals(ID)) {
                        stat.executeUpdate("UPDATE studentfile SET studentname = '" + name + "',department='" + department + "' WHERE ID = '" + ID + "'");
                        return true;
                    }
                }
                return false;
            } catch (SQLException error) {
                error.printStackTrace();
            }
        }
        return false;
    }
}
