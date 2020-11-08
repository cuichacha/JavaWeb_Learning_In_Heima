package Day02.Code.service;

import Day02.Code.bean.Student;
import Day02.Code.mapper.CourseMapper;
import Day02.Code.utils.MapperUtil;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    @Override
    public List<Student> findAll() {
        CourseMapper mapper = MapperUtil.getMapper(CourseMapper.class, true);
        List<Student> courses = mapper.findAll();
        MapperUtil.close();
        return courses;
    }
}
