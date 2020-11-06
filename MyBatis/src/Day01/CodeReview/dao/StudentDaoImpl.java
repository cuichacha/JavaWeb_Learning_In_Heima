package Day01.CodeReview.dao;

import Day01.CodeReview.bean.Student;
import Day01.CodeReview.utils.SqlSessionUtil2;
import Day01.CodeReview.utils.SqlSessionUtil4;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> findAll() {
        SqlSession sqlSession = SqlSessionUtil4.openSqlSession(true);
        List<Student> list = sqlSession.selectList("xx.findAll");
        SqlSessionUtil4.close();
        return list;
    }

    @Override
    public Student findBySid(Integer sid) {
        SqlSession sqlSession = SqlSessionUtil4.openSqlSession(true);
        Student student = sqlSession.selectOne("xx.findBySid", 3);
        SqlSessionUtil4.close();
        return student;
    }

    @Override
    public Integer insert(Student student) {
        SqlSession sqlSession = SqlSessionUtil4.openSqlSession(true);
        Integer result = sqlSession.insert("xx.insert", student);
        SqlSessionUtil4.close();
        return result;
    }

    @Override
    public Integer update(Student student) {
        SqlSession sqlSession = SqlSessionUtil4.openSqlSession(true);
        Integer result = sqlSession.update("xx.update", student);
        SqlSessionUtil4.close();
        return result;
    }

    @Override
    public Integer delete(Integer id) {
        SqlSession sqlSession = SqlSessionUtil4.openSqlSession(true);
        Integer result = sqlSession.delete("xx.delete", id);
        SqlSessionUtil4.close();
        return result;
    }
}
