package Day01.Code.Dao;

import Day01.Code.Domain.Student;
import Day01.Code.Utils.DateUtils;
import Day01.Code.Utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private ArrayList<Student> list = new ArrayList<>();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public List<Student> findAll() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.134.132:3306/jdbc_day01", "root", "password");
            String sql = "select * from student";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
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
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            preparedStatement = null;
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
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.134.132:3306/jdbc_day01", "root", "password");
            String sql = "select * from student where sid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Integer sid = resultSet.getInt("sid");
                String name = resultSet.getString("name");
                Integer age = resultSet.getInt("age");
                Date birthday = resultSet.getDate("birthday");
                Student student = new Student(sid, name, age, birthday);
                return student;
            } else {
                return null;
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
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            preparedStatement = null;
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            connection = null;
        }
        return null;
    }

    @Override
    public int insert(Student student) {
        int result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.134.132:3306/jdbc_day01", "root", "password");
            String sql = "insert  into student (sid, name, age, birthday) values (null ,?,?,?)";
//            preparedStatement.setInt(1, student.getSid());
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, DateUtils.date2String(student.getBirthday()));
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            preparedStatement = null;
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            connection = null;
        }
        return result;
    }

    @Override
    public int update(Student student) {
        connection = JDBCUtils.getConnection();
        int result = 0;
        try {
            String sql = "update student set sid = ?, name = ?, age = ?, birthday = ? where sid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, student.getSid());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, DateUtils.date2String(student.getBirthday()));
            preparedStatement.setInt(5, student.getSid());
            result = preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
        return result;
    }

    @Override
    public int delete(Integer id) {
        connection = JDBCUtils.getConnection();
        int result = 0;
        try {
            String sql = "delete from student where sid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
        return result;
    }
}
