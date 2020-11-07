package Day03.Code.service;

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
}
