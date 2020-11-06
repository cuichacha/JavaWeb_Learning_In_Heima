package Day02.Code.service;

import Day02.Code.bean.Student;

import java.util.List;

public interface StudentService {
    public abstract List<Student> findAll();

    public abstract Student findBySid(Integer sid);

    public abstract Integer insert(Student student);

    public abstract Integer update(Student student);

    public abstract Integer delete(Integer id);
}
