package test_case;

import dao.ITableDao;
import model.TableColumn;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.ConvertUtil;
import util.GetTableNames;
import util.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/9/19.
 */
public class firstTest {

    private SqlSession sqlSession;

    private Map<String, List<TableColumn>> map = new HashMap();

    @Before
    public void beforeTest() throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }


    @Test
    public void test() {
        ITableDao mapper = sqlSession.getMapper(ITableDao.class);
        List<String> strings = mapper.showTables();
        for (String string : strings) {
            List<TableColumn> tableColumns = mapper.showFields("`" + string + "`");
            map.put(ConvertUtil.camelName(string), tableColumns);
        }
        System.out.println(1);
    }

    @Test
    public void testCamel() {
        String class_sy = ConvertUtil.camelName("sub_stu_time");
        System.out.println(class_sy);
    }

    @Test
    public void testResouece() throws Exception {
//        String test = Resource.getValue("generate_all");
//        boolean b = Boolean.parseBoolean(test);
//        ParamUtil.generateAll = b;

        String table_name = Resource.getValue("table_name");
        List<String> tableNames = GetTableNames.getTableNames(table_name);
        for (String tableName : tableNames) {
            System.out.println(tableName);
        }
    }


    @After
    public void realse() {
        sqlSession.close();
        System.out.println(123);
    }

}
