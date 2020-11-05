package Day02.CodeReview.Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Properties;

public class Test {
    public static void main(String[] args) {
        InputStream resourceAsStream = JDBCUtil.class.getClassLoader().getResourceAsStream("Day02/CodeReview/Druid/druid.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection connection = dataSource.getConnection();
            connection = JDBCUtil.getConnection();
            String sql = "select * from student";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int sid = resultSet.getInt("sid");
                System.out.println(sid);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
