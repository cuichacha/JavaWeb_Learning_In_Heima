package Day01.CodeReview.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil2 {
    private static SqlSessionFactory sessionFactory;

    private SqlSessionUtil2() {
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
        return sqlSession;
    }

    public static SqlSession openSqlSession(boolean autoCommit) {
        if (autoCommit) {
            SqlSession sqlSession = sessionFactory.openSession(true);
            return sqlSession;
        } else {
            return openSqlSession();
        }
    }

    public static void close(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    public static void commit(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.commit();
        }
    }

    public static void rollBack(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.rollback();
        }
    }
}
