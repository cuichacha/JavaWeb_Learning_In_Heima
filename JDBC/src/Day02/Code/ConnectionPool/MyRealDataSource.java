package Day02.Code.ConnectionPool;

import Day01.Code.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyRealDataSource extends MyDataSource {
    private List<Connection> list = new ArrayList<>();

    public MyRealDataSource(List<Connection> list) {
        for (int i = 0; i < 3; i++) {
            list.add(JDBCUtils.getConnection());
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return list.remove(0);
    }
}
