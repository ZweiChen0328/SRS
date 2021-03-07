
package srs.pkgnew;

import java.sql.SQLException;


public class ModifyFX extends Option{
 
    public void newWindow() throws SQLException {
        label.setText("原帳號:");
        label2.setText("所屬系籍:");
        label3.setText("學生姓名:");
        btn.setText("修改檔案");
        title.setText("修改學生檔案");
        btn.setOnAction(e -> {
            try {
                String id = account.getText().trim();
                String dep = department.getText().trim();
                String stu = name.getText().trim();
                File freshman = new File(id, stu, dep);
                boolean judge = freshman.modifyFile();
                if (judge) {
                    text.setText("Modify Successful!");
                } else {
                    text.setText("Modify Failure!");
                }
            } catch (java.sql.SQLException b) {
            }
        });
        primaryStage.setTitle("CreateFX");
        primaryStage.show();
    }
}
