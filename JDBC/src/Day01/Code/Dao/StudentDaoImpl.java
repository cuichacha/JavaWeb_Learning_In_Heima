package Day01.Code.Dao;

import Day01.Code.Domain.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private ArrayList<Student> list = new ArrayList<>();
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    @Override
    public List<Student> findAll() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.134.131:3306/jdbc_day01", "root", "password");
            statement = connection.createStatement();
            String sql = "select * from student";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Integer sid = resultSet.getInt("sid");
                String name = resultSet.getString("name");
                Integer age = resultSet.getInt("age");
                Date date = resultSet.getDate("birthday");
                Student student = new Student(sid, name, age, date);
                list.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            resultSet = null;
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            statement = null;
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            connection = null;
        }
        return list;
    }

    @Override
    public Student findByID(Integer id) {
        return null;
    }

    @Override
    public int insert(Student student) {
        return 0;
    }

    @Override
    public int update(Student student) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
