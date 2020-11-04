package Day01.CodeReview.service;

import Day01.CodeReview.dao.StudentDao;
import Day01.CodeReview.dao.StudentDaoImpl;
import Day01.CodeReview.domain.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student findBySid(Integer sid) {
        return studentDao.findBySid(sid);
    }

    @Override
    public Integer insert(Student student) {
        return studentDao.insert(student);
    }

    @Override
    public Integer update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public Integer delete(Integer id) {
        return studentDao.delete(id);
    }
}
