package Day02.CodeReview.DataSource;


import java.sql.Connection;
import java.sql.SQLException;

public class Test3 {
    public static void main(String[] args) {
        MyDataSource myDataSource = new MyDataSource();
        try {
            Connection connection = myDataSource.getConnection();
            MyConnection2 myConnection2 = new MyConnection2(connection, myDataSource.getList());
            myConnection2.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
