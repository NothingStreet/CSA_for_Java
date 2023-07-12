package Work5;
import java.sql.*;
import java.util.ResourceBundle;

public class ChangeTable {
    public static void showSelect(ResultSet rs){
        try {
            while (rs.next()) {
                System.out.println(rs.getString("sno") + "," +
                        rs.getString("name") + "," +
                        rs.getString("age") +
                        rs.getString("college"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ResultSet rs=null;
        Statement stmt=null;
        Connection conn=null;

        ResourceBundle bundle=ResourceBundle.getBundle("Work5.jdbc");
        String driver=bundle.getString("driver");
        String url=bundle.getString("url");
        String user=bundle.getString("user");
        String password=bundle.getString("password");


        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,password);
            stmt=conn.createStatement();
            conn.setAutoCommit(false);

            //-------------------------------------------------------------------------
            System.out.println("第1题的效果");
            System.out.println("----------------");
            String insert1="insert into test.student values " +
                    "('s001','老大',20,'计算机学院')," +
                    "('s002','老二',19,'计算机学院')," +
                    "('s003','老三',18,'计算机学院')," +
                    "('s004','老四',17,'计算机学院')";
            String select1="select * from test.student";
            int count=stmt.executeUpdate(insert1);
            rs=stmt.executeQuery(select1);
            if(count==4){
                showSelect(rs);
            }else System.out.println("插入失败");

            //--------------------------------------------------------------------------
            System.out.println("----------------");
            System.out.println("第2题的效果");
            System.out.println("----------------");
            rs=stmt.executeQuery(select1);
            showSelect(rs);

            //-------------------------------------------------------------------------
            System.out.println("----------------");
            System.out.println("第3题的效果");
            System.out.println("----------------");
            String delete="delete from test.student where sno='s004'";
            count=stmt.executeUpdate(delete);
            rs=stmt.executeQuery(select1);
            if(count==1){
                showSelect(rs);
            }else System.out.println("删除失败");

            //------------------------------------------------------------------------
            System.out.println("-----------------");
            String select2="select * from test.student where sno='s003'";
            rs=stmt.executeQuery(select2);
            while(rs.next()) {
                System.out.println("第4题：Student{sno='" + rs.getString("sno") + "',name='" + rs.getString("name")
                        + "',age=" + rs.getString("age") + ",college='" + rs.getString("college") + "'}");
            }
            System.out.println("第4题的效果");
            System.out.println("-----------------");
            rs=stmt.executeQuery(select1);
            showSelect(rs);

            //-------------------------------------------------------------------------
            System.out.println("----------------");
            System.out.println("第5题的效果");
            System.out.println("----------------");
            String update="update test.student set college='通信学院' where sno='s001'";
            count=stmt.executeUpdate(update);
            rs=stmt.executeQuery(select1);
            if(count==1){
                showSelect(rs);
            }else System.out.println("修改失败");


            conn.commit();
        }catch (Exception e){
            e.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
