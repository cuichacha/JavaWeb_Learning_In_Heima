package GraphicSMS.mapper;

import GraphicSMS.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user where username=#{username} and password=#{password}")
    public abstract User logIn(@Param("username") String username, @Param("password") String password);
}
