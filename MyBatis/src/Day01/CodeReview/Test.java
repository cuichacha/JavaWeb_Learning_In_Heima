package Day01.CodeReview;

import Day01.CodeReview.bean.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("Day01/CodeReview/MyBatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            List<Student> list = sqlSession.selectList("xx.findAll");
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
