package GraphicSMS.mapper;

import GraphicSMS.bean.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    @Select("select * from student")
    public abstract List<Student> findAll();

    @Insert("insert into student values (#{number}, #{name}, #{birthday}, #{address})")
    public abstract Integer addStu(Student student);
}
