package Day01.CodeReview.dao;

import Day01.CodeReview.bean.Student;
import Day01.CodeReview.utils.SqlSessionUtil2;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private SqlSession sqlSession;

    @Override
    public List<Student> findAll() {
        sqlSession = SqlSessionUtil2.openSqlSession(true);
        List<Student> list = sqlSession.selectList("xx.findAll");
        sqlSession.close();
        return list;
    }

    @Override
    public Student findBySid(Integer sid) {
        sqlSession = SqlSessionUtil2.openSqlSession(true);
        Student student = sqlSession.selectOne("xx.findById", 3);
        sqlSession.close();
        return student;
    }

    @Override
    public Integer insert(Student student) {
        sqlSession = SqlSessionUtil2.openSqlSession(true);
        Integer result = sqlSession.insert("xx.insert");
        sqlSession.close();
        return result;
    }

    @Override
    public Integer update(Student student) {
        sqlSession = SqlSessionUtil2.openSqlSession(true);
        Integer result = sqlSession.update("xx.update");
        sqlSession.close();
        return result;
    }

    @Override
    public Integer delete(Integer id) {
        sqlSession = SqlSessionUtil2.openSqlSession(true);
        Integer result = sqlSession.delete("xx.delete");
        sqlSession.close();
        return result;
    }
}
