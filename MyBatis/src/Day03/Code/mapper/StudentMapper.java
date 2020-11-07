package Day03.Code.mapper;

import Day03.Code.bean.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    @Select("select * from student")
    public abstract List<Student> findAll();

    public abstract Student findBySid(Integer sid);

    public abstract Integer insert(Student student);

    public abstract Integer update(Student student);

    public abstract Integer delete(Integer id);

    public abstract Student findByIdAndName(@Param("sid") Integer sid, @Param("name") String name);

    public abstract Integer updatedUpdate(Student student);

    public abstract List<Student> findByIds(List<Integer> ids);

    public abstract List<Student> findAllInPages();
}
