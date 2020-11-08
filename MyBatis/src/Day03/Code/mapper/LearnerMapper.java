package Day03.Code.mapper;

import Day03.Code.bean.Learner;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LearnerMapper {
    @Select("select * from learner where cid = #{cid}")
    public abstract List<Learner> findByCid(Integer cid);
}
