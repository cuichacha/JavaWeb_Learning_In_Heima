package Day03.Code.service;

import Day03.Code.bean.Classes;
import Day03.Code.mapper.ClassMapper;
import Day03.Code.utils.MapperUtil;

import java.util.List;

public class ClassServiceImpl implements ClassService {
    @Override
    public List<Classes> findAll() {
        ClassMapper mapper = MapperUtil.getMapper(ClassMapper.class, true);
        List<Classes> classes = mapper.findAll();
        MapperUtil.close();
        return classes;
    }
}
