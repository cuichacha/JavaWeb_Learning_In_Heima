package Day01.CodeReview.dao;

import Day01.CodeReview.bean.Student;

import java.util.List;

public interface StudentDao {
    public abstract List<Student> findAll();

    public abstract Student findBySid(Integer sid);

    public abstract Integer insert(Student student);

    public abstract Integer update(Student student);

    public abstract Integer delete(Integer id);

}
