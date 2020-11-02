package Day01.Code.Service;

import Day01.Code.Domain.Student;

import java.util.List;

public interface StudentService {
    public abstract List<Student> findAll();

    public abstract Student findByID(Integer id);

    public abstract int insert(Student student);

    public abstract int update(Student student);

    public abstract int delete(Integer id);
}

