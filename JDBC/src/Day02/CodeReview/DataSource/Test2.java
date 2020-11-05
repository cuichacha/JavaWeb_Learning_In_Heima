package Day02.CodeReview.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Test2 {
    public static void main(String[] args) {
        MyDataSource myDataSource = new MyDataSource();

        try {
            Connection connection = myDataSource.getConnection();
            MyConnection1 myConnection1 = new MyConnection1(connection, myDataSource.getList());
            myConnection1.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
