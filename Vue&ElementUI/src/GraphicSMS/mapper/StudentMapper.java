package GraphicSMS.mapper;

import GraphicSMS.bean.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {
    @Select("select * from student")
    public abstract List<Student> findAll();

    @Insert("insert into student values (#{number}, #{name}, #{birthday}, #{address})")
    public abstract Integer addStu(Student student);

    @Update("update student set number=#{number},name=#{name},birthday=#{birthday},address=#{address} where number = #{id}")
    public abstract Integer updateStu(@Param("student") Student student, @Param("id") Integer id);
}
