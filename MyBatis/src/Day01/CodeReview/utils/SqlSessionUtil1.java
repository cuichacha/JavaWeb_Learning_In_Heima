package Day01.CodeReview.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil1 {
    private static SqlSessionFactory sessionFactory;

    private SqlSessionUtil1() {
    }

    static {
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("Day01/CodeReview/MyBatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = sessionFactory.openSession();
        return sqlSession;
    }

    public static void close(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}
