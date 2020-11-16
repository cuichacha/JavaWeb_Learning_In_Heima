package GraphicSMS.service;

import GraphicSMS.bean.User;
import GraphicSMS.mapper.UserMapper;
import GraphicSMS.utils.MapperUtil;

public class UserServiceImpl implements UserService {

    @Override
    public User logIn(User user) {
        UserMapper mapper = MapperUtil.getMapper(UserMapper.class, true);
        User logInUser = mapper.logIn(user.getUsername(), user.getPassword());
        MapperUtil.close();
        return logInUser;
    }
}
