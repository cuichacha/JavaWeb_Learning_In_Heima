package Day01.CodeReview.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SqlSessionUtil3 {
    private static SqlSessionFactory sessionFactory;
    private static Map<Thread, SqlSession> map = new ConcurrentHashMap<>();

    private SqlSessionUtil3() {
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

    public static SqlSession openSqlSession() {
        SqlSession sqlSession = sessionFactory.openSession(false);
        map.put(Thread.currentThread(), sqlSession);
        return sqlSession;
    }

    public static SqlSession openSqlSession(boolean autoCommit) {
        if (autoCommit) {
            SqlSession sqlSession = sessionFactory.openSession(true);
            map.put(Thread.currentThread(), sqlSession);
            return sqlSession;
        } else {
            return openSqlSession();
        }
    }

    public static void close() {
        SqlSession sqlSession = map.get(Thread.currentThread());
        if (sqlSession != null) {
            sqlSession.close();
            map.remove(sqlSession);
        }
    }

    public static void commit() {
        SqlSession sqlSession = map.get(Thread.currentThread());
        if (sqlSession != null) {
            sqlSession.commit();
        }
    }

    public static void rollBack() {
        SqlSession sqlSession = map.get(Thread.currentThread());
        if (sqlSession != null) {
            sqlSession.rollback();
        }
    }
}
