package Day01.CodeReview.dao;

import Day01.CodeReview.domain.Student;
import Day01.CodeReview.utils.DateUtil;
import Day01.CodeReview.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Student> list = new ArrayList<>();

    @Override
    public List<Student> findAll() {
        connection = JDBCUtil.getConnection();
        String sql = "select * from student";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer sid = resultSet.getInt("sid");
                String name = resultSet.getString("name");
                Integer age = resultSet.getInt("age");
                String birthday = resultSet.getString("birthday");
                Student student = new Student(sid, name, age, DateUtil.String2Date(birthday));
                list.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(resultSet, preparedStatement, connection);
        }
        return list;
    }

    @Override
    public Student findById(Integer id) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from student where sid = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer insert(Student student) {
        return null;
    }

    @Override
    public Integer update(Student student) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }
}
