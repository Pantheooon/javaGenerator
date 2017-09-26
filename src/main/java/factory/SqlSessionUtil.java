package factory;

import dao.ITableDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by admin on 2017/9/21.
 */
public class SqlSessionUtil {
    private static ITableDao dao;
    private static SqlSession sqlSession;

    public static ITableDao getInstance() throws IOException {
        if (dao == null) {
            String resource = "mybatis/mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            dao = sqlSession.getMapper(ITableDao.class);
        }
        return dao;
    }

    private SqlSessionUtil() {
    }

    public static void realse() {
        sqlSession.close();
    }

}
