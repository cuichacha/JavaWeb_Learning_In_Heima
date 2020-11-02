package Day01.Code.Dao;

import Day01.Code.Domain.Student;

import java.util.List;

public interface StudentDao {
    public abstract List<Student> findAll();

    public abstract Student findByID(Integer id);

    public abstract int insert(Student student);

    public abstract int update(Student student);

    public abstract int delete(Integer id);
}
