package Day03.Code.mapper;

import Day03.Code.bean.Person;
import org.apache.ibatis.annotations.Select;

public interface PersonMapper {
    @Select("select * from person where id = #{id}")
    public abstract Person findById(Integer id);
}
