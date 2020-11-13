package Code.Search.service;

import Code.Search.mapper.SearchMapper;
import Code.Search.utils.MapperUtil;
import Code.bean.User;

import java.util.List;

public class SearchServiceImpl implements SearchService {
    @Override
    public List<User> keywords(String username) {
        SearchMapper mapper = MapperUtil.getMapper(SearchMapper.class, true);
        List<User> users = mapper.keywords(username);
        MapperUtil.close();
        return users;
    }
}
