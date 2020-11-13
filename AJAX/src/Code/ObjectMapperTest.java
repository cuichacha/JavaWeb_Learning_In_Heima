package Code;

import Code.bean.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ObjectMapperTest {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void Test1() throws IOException {
        User user1 = new User("张三", 23);
        String s1 = objectMapper.writeValueAsString(user1);
        System.out.println(s1);

        User user = objectMapper.readValue(s1, User.class);
        System.out.println(user);
    }

    @Test
    public void Test2() throws IOException {
        List<User> list = new ArrayList<>();
        User user1 = new User("张三", 23);
        User user2= new User("李四", 24);
        list.add(user1);
        list.add(user2);
        String s = objectMapper.writeValueAsString(list);
        System.out.println(s);

        List<User> users = objectMapper.readValue(s, new TypeReference<List<User>>() {
        });
        System.out.println(users);
    }
}
