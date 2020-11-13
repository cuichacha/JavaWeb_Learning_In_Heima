package Code.Search.mapper;

import Code.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface SearchMapper {
    @Select("select * from relevant_results where name like concat(#{username}, '%') order by search_count desc limit 4")
    public abstract List<User> keywords(String username);
}
