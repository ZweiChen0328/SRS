package srs.pkgnew;

import java.sql.*;
import java.util.*;

public class Course {

    private String name;
    private String room;
    private String pro;
    Scanner scC = new Scanner(System.in);
    protected static Connection conn = connect.getConnection();//連接數據庫

    public Course() {
        this.name = "";
        this.room = "";
        this.pro = "";
    }

    public Course(String name, String room, String pro) {
        this.name = name;
        this.room = room;
        this.pro = pro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getProfessor() {
        return pro;
    }

    public void setProfessor(String pro) {
        this.pro = pro;
    }

    public int chooseCourse(String ID, int courseID) throws SQLException {
        int courseID2 = 0;
        Statement stat;
        ResultSet rs, rs2;
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from course");
            while (rs.next()) {
                courseID2 = rs.getInt("courseID");
                if (courseID == courseID2) {
                    rs2 = stat.executeQuery("select * from stuCourse");
                    while (rs2.next()) {
                        String student = rs2.getString("studentID");//將數據庫的資料，存入變數中
                        int haveExist = rs2.getInt("courseID");
                        if (ID.equals(student) && (courseID == haveExist)) {//判斷是否有登入資料
                            stat.close();
                            rs2.close();
                            return 1;
                        }
                    }
                    stat.executeUpdate("INSERT INTO stuCourse (studentID, courseID) VALUES ('" + ID + "'," + courseID + ")");
                    return 2;
                }
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return 0;
    }

    public boolean deleteCourse(String ID, int courseID) throws SQLException {
        Statement stat;
        ResultSet rs;
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from stuCourse");
            while (rs.next()) {
                String student = rs.getString("studentID");//將數據庫的資料，存入變數中
                int haveExist = rs.getInt("courseID");
                if (ID.equals(student) && (courseID == haveExist)) {//判斷是否有登入資料
                    stat.executeUpdate("DELETE FROM stuCourse WHERE studentID = '" + ID + "'AND courseID = '" + courseID + "' ");
                    stat.close();
                    rs.close();
                    return true;
                }
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }
}
