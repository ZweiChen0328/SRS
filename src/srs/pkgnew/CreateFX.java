package srs.pkgnew;

import java.sql.SQLException;
public class CreateFX extends Option {

    public void newWindow() throws SQLException {
        label.setText("新帳號:");
        label2.setText("所屬系籍:");
        label3.setText("新學生:");
        btn.setText("寫入檔案");
        title.setText("新增學生檔案");
        btn.setOnAction(e -> {
            try {
                String id = account.getText().trim();
                String dep = department.getText().trim();
                String stu = name.getText().trim();
                File freshman = new File(id, stu, dep);
                boolean judge = freshman.createFile();
                if (judge) {
                    text.setText("Create Successful!");
                } else {
                    text.setText("Create Failure!");
                }
            } catch (java.sql.SQLException b) {
            }
        });
        primaryStage.setTitle("CreateFX");
        primaryStage.show();
    }
}
