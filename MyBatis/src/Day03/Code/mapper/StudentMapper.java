package Day03.Code.mapper;

import Day03.Code.bean.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {
    @Select("select * from student")
    public abstract List<Student> findAll();

    @Select("select * from student where sid = #{sid}")
    public abstract Student findBySid(Integer sid);

    @Insert("insert into student (sid, name, age, insert_time) values (#{sid}, #{name}, #{age}, #{insertTime})")
    public abstract Integer insert(Student student);

    public abstract Integer update(Student student);

    @Delete("delete from student where sid = #{sid}")
    public abstract Integer delete(Integer id);

    public abstract Student findByIdAndName(@Param("sid") Integer sid, @Param("name") String name);

    public abstract Integer updatedUpdate(Student student);

    public abstract List<Student> findByIds(List<Integer> ids);

    public abstract List<Student> findAllInPages();

    @Select("select distinct s.sid, s.name, s.age from student as s, stu_cr as sc where s.sid = sc.sid")
    @Results({
            @Result(column = "sid", property = "sid"),
            @Result(column = "name", property = "name"),
            @Result(column = "age", property = "age"),
            @Result(column = "sid", property = "courses",
                    javaType = List.class,
                    many = @Many(select = "Day03.Code.mapper.CourseMapper.findCourse")
            )
    })
    public abstract List<Student> findCourses();
}
