package Day01.CodeReview.service;

import Day01.CodeReview.domain.Student;

import java.util.List;

public interface StudentService {
    public abstract List<Student> findAll();

    public abstract Student findById(Integer id);

    public abstract Integer insert(Student student);

    public abstract Integer update(Student student);

    public abstract Integer delete(Integer id);
}
