package Day02.Code.service;

import Day02.Code.bean.Student;
import Day02.Code.mapper.StudentMapper;
import Day02.Code.utils.MapUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> findAll() {
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("Day02/Code/MyBatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.findAll();
        sqlSession.close();
        return students;
    }

    @Override
    public Student findBySid(Integer sid) {
        StudentMapper mapper = MapUtil.getMapper(StudentMapper.class, true);
        Student student = mapper.findBySid(sid);
        MapUtil.close();
        return student;
    }

    @Override
    public Integer insert(Student student) {
        StudentMapper mapper = MapUtil.getMapper(StudentMapper.class, true);
        Integer result = mapper.insert(student);
        MapUtil.close();
        return result;
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
