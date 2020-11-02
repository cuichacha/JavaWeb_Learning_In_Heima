package Day01.Code.Service;

import Day01.Code.Dao.StudentDao;
import Day01.Code.Dao.StudentDaoImpl;
import Day01.Code.Domain.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student findByID(Integer id) {
        return studentDao.findByID(id);
    }

    @Override
    public int insert(Student student) {
        return studentDao.insert(student);
    }

    @Override
    public int update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public int delete(Integer id) {
        return studentDao.delete(id);
    }
}
