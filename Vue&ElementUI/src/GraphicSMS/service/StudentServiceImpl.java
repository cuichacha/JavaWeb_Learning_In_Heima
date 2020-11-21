package GraphicSMS.service;

import GraphicSMS.bean.Student;
import GraphicSMS.mapper.StudentMapper;
import GraphicSMS.utils.MapperUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class StudentServiceImpl implements StudentService {
//     private  StudentMapper mapper = MapperUtil.getMapper(StudentMapper.class, true);
//     切记！！此处的mapper不能提取，不然静态的selSessionFactory只有一个，关闭之后会报错！！

    @Override
    public PageInfo<Student> findByPage(Integer startPage, Integer pageSize) {
        StudentMapper mapper = MapperUtil.getMapper(StudentMapper.class, true);
        PageHelper.startPage(startPage, pageSize);
        List<Student> students = mapper.findAll();
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        MapperUtil.close();
        return pageInfo;
    }

    @Override
    public Integer addStu(Student student) {
        StudentMapper mapper = MapperUtil.getMapper(StudentMapper.class, true);
        Integer result = mapper.addStu(student);
        MapperUtil.close();
        return result;
    }

    @Override
    public Integer updateStu(Student student, Integer id) {
        StudentMapper mapper = MapperUtil.getMapper(StudentMapper.class, true);
        Integer result = mapper.updateStu(student, id);
        MapperUtil.close();
        return result;
    }
}
