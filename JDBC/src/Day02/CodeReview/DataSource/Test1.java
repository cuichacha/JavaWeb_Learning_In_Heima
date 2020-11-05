package Day02.CodeReview.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Test1 {
    public static void main(String[] args) {
        MyDataSource myDataSource = new MyDataSource();
        try {
            Connection connection = myDataSource.getConnection();
            System.out.println(connection);
            myDataSource.back(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
