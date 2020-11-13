package Code.Search.service;

import Code.bean.User;

import java.util.List;

public interface SearchService {
    public abstract List<User> keywords(String username);
}
