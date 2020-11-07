package Day02.Code.service;

import Day02.Code.bean.Student;
import Day02.Code.mapper.StudentMapper;
import Day02.Code.utils.MapperUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        StudentMapper mapper = MapperUtil.getMapper(StudentMapper.class, true);
        Student student = mapper.findBySid(sid);
        MapperUtil.close();
        return student;
    }

    @Override
    public Integer insert(Student student) {
        StudentMapper mapper = MapperUtil.getMapper(StudentMapper.class, true);
        Integer result = mapper.insert(student);
        MapperUtil.close();
        return result;
    }

    @Override
    public Integer update(Student student) {
        StudentMapper mapper = MapperUtil.getMapper(StudentMapper.class, true);
        Integer result = mapper.update(student);
        MapperUtil.close();
        return result;
    }

    @Override
    public Integer delete(Integer id) {
        StudentMapper mapper = MapperUtil.getMapper(StudentMapper.class, true);
        Integer result = mapper.delete(id);
        MapperUtil.close();
        return result;
    }

    @Override
    public Student findByIdAndName(Integer sid, String name) {
        StudentMapper mapper = MapperUtil.getMapper(StudentMapper.class, true);
        Student student = mapper.findByIdAndName(sid, name);
        MapperUtil.close();
        return student;
    }

    @Override
    public Integer updatedUpdate(Student student) {
        StudentMapper mapper = MapperUtil.getMapper(StudentMapper.class, true);
        Integer result = mapper.updatedUpdate(student);
        MapperUtil.close();
        return result;
    }

    @Override
    public List<Student> findByIds(List<Integer> ids) {
        StudentMapper mapper = MapperUtil.getMapper(StudentMapper.class, true);
        List<Student> students = mapper.findByIds(ids);
        MapperUtil.close();
        return students;
    }

    @Override
    public List<Student> findAllInPages() {
        StudentMapper mapper = MapperUtil.getMapper(StudentMapper.class, true);
        PageHelper.startPage(1,3);
        List<Student> students = mapper.findAllInPages();
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        MapperUtil.close();
        return students;
    }
}
