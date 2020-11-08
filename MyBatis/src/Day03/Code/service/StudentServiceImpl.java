package Day03.Code.service;

import Day03.Code.bean.Course;
import Day03.Code.bean.Student;
import Day03.Code.mapper.StudentMapper;
import Day03.Code.utils.MapperUtil;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> findAll() {
        StudentMapper mapper = MapperUtil.getMapper(StudentMapper.class, true);
        List<Student> students = mapper.findAll();
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
        return null;
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
        return null;
    }

    @Override
    public Integer updatedUpdate(Student student) {
        return null;
    }

    @Override
    public List<Student> findByIds(List<Integer> ids) {
        return null;
    }

    @Override
    public List<Student> findAllInPages() {
        return null;
    }

    @Override
    public List<Student> findCourses() {
        StudentMapper mapper = MapperUtil.getMapper(StudentMapper.class, true);
        List<Student> courses = mapper.findCourses();
        MapperUtil.close();
        return courses;
    }
}
