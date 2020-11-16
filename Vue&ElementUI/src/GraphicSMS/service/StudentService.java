package GraphicSMS.service;

import GraphicSMS.bean.Student;
import com.github.pagehelper.PageInfo;

public interface StudentService {
    public abstract PageInfo<Student> findByPage(Integer startPage, Integer pageSize);

    public abstract Integer addStu(Student student);
}
