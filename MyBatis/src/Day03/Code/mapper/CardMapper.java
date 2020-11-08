package Day03.Code.mapper;

import Day03.Code.bean.Card;
import Day03.Code.bean.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CardMapper {
    @Select("select * from card")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "number", property = "number"),
            @Result(column = "id", property = "person",
                    javaType = Person.class,
                    one = @One(select = "Day03.Code.mapper.PersonMapper.findById")
            )
    })
    public abstract List<Card> findAll();
}
