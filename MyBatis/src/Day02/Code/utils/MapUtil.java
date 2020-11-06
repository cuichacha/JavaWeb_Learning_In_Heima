package Day02.Code.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MapUtil {
    private static SqlSessionFactory sqlSessionFactory;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

    private MapUtil() {
    }

    static {
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("Day02/Code/MyBatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    public static<T> T getMapper(Class<T> tClass, boolean autoCommit) {
        SqlSession sqlSession = sqlSessionFactory.openSession(autoCommit);
        threadLocal.set(sqlSession);
        T mapper = sqlSession.getMapper(tClass);
        return mapper;
    }

    public static void commit() {
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession != null) {
            sqlSession.commit();
        }
    }

    public static void close() {
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}
