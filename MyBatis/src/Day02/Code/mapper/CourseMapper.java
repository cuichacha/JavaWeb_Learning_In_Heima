package Day02.Code.mapper;

import Day02.Code.bean.Student;

import java.util.List;

public interface CourseMapper {
    public abstract List<Student> findAll();
}
