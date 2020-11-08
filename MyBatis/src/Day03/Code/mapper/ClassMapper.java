package Day03.Code.mapper;

import Day03.Code.bean.Classes;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ClassMapper {
    @Select("select * from classes")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "id", property = "learners",
                    javaType = List.class,
                    many = @Many(select = "Day03.Code.mapper.LearnerMapper.findByCid")
            )
    })
    public abstract List<Classes> findAll();
}
