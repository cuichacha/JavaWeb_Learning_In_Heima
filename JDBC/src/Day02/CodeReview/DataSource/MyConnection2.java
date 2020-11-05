package Day02.CodeReview.DataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MyConnection2 extends MyConnectionAdapter {
    private List<Connection> list;
    private Connection connection;

    public MyConnection2(Connection connection, List<Connection> list) {
        super(connection);
        this.connection = connection;
        this.list = list;
    }

    @Override
    public void close() throws SQLException {
        list.add(connection);
        System.out.println(list);
    }
}
