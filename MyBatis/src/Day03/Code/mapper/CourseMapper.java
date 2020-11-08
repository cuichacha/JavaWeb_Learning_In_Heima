package Day03.Code.mapper;

import Day03.Code.bean.Course;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CourseMapper {
    @Select("select distinct c.id, c.NAME from course as c, stu_cr as sc where c.id = sc.cid;")
    public abstract List<Course> findCourse(Integer sid);
}
