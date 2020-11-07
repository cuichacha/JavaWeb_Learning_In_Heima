package Day02.Code.service;

import Day02.Code.bean.Classes;
import Day02.Code.mapper.ClassMapper;
import Day02.Code.utils.MapperUtil;

import java.util.List;

public class ClassServiceImpl implements ClassService{
    @Override
    public List<Classes> findAll() {
        ClassMapper mapper = MapperUtil.getMapper(ClassMapper.class, true);
        List<Classes> classes = mapper.findAll();
        MapperUtil.close();
        return classes;
    }
}
