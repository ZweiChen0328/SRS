package srs.pkgnew;

import java.sql.*;

class Manager extends File {

    private static Connection conn = connect.getConnection();//連接數據庫

    public boolean professorLogin(String pass, String num) throws SQLException {
        id = pass;
        inputPassword = num;

        String professorID = null;//在迴圈外先訂定好data type
        String professorPassword = null;
        Statement stat;
        ResultSet rs;
        stat = conn.createStatement();
        rs = stat.executeQuery("select * from professorFile");
        while (rs.next()) {//從數據庫中，一行一行查找，直到沒有下一筆資料
            professorID = rs.getString("ID");//將數據庫的資料，存入變數中
            professorPassword = rs.getString("Password");
            if (id.equals(professorID) && inputPassword.equals(professorPassword)) {//判斷是否有登入資料
                return true;
            }
        }
        return false;
    }

    public boolean changePassword(String ID, String pass) throws SQLException {
        Statement stat;
        ResultSet rs;
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from professorFile");
            while (rs.next()) {
                String student = rs.getString("ID");//將數據庫的資料，存入變數中
                if (ID.equals(student)) {//判斷是否有登入資料
                    stat.executeUpdate("UPDATE professorFile SET Password ='" + pass + "' WHERE ID='" + ID + "'");
                    return true;
                }
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }
}
