package Day02.CodeReview.DataSource;

import Day02.CodeReview.utils.JDBCUtil;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MyDataSource implements DataSource {
    private List<Connection> list = new ArrayList<>();

    public MyDataSource() {
        for (int i = 0; i < 3; i++) {
            list.add(JDBCUtil.getConnection());
            System.out.println(list.get(i));
        }
    }

    public List<Connection> getList() {
        return list;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return list.remove(0);
    }

    public void back(Connection connection) {
        list.add(connection);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
