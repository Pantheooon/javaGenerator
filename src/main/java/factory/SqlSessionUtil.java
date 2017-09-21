package factory;

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
    private static SqlSession sqlSession;

    public static SqlSession getInstance() throws IOException {
        if (sqlSession == null) {
            String resource = "mybatis/mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
        }
        return sqlSession;
    }

    private SqlSessionUtil() {
    }

}
