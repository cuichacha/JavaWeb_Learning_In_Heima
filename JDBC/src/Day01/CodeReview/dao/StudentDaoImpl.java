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
    public Student findBySid(Integer sid) {
        Connection connection = JDBCUtil.getConnection();
        Student student = new Student();
        String sql = "select * from student where sid = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, sid);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Integer id = resultSet.getInt("sid");
                String name = resultSet.getString("name");
                Integer age = resultSet.getInt("age");
                String birthday = resultSet.getString("birthday");
                student = new Student(id, name, age, DateUtil.String2Date(birthday));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(resultSet, preparedStatement, connection);
        }
        return student;
    }

    @Override
    public Integer insert(Student student) {
        connection = JDBCUtil.getConnection();
        Integer result = 0;
        String sql = "insert into student (sid, name, age, birthday) values (null, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, DateUtil.date2String(student.getBirthday()));
            result = this.preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(null, preparedStatement, connection);
        }
        return result;
    }

    @Override
    public Integer update(Student student) {
        connection = JDBCUtil.getConnection();
        Integer result = 0;
        String sql = "update student set name = ?, age = ?, birthday = ? where sid = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, DateUtil.date2String(student.getBirthday()));
            preparedStatement.setInt(4, student.getSid());
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(null, preparedStatement, connection);
        }
        return result;
    }

    @Override
    public Integer delete(Integer id) {
        Connection connection = JDBCUtil.getConnection();
        Integer result = 0;
        String sql = "delete from student where sid = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(null, preparedStatement, connection);
        }
        return result;
    }
}
