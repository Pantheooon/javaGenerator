package util;


import dao.ITableDao;
import factory.SqlSessionUtil;
import model.TableColumn;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/9/19.
 */
public class TableUtil {

    private static final Log log = LogFactory.getLog(TableUtil.class);
    public static List<String> getTableNames() throws Exception {
        List<String> tableNames = new ArrayList<String>();
        if (ParamUtil.generateAll == true) {
            ITableDao dao = SqlSessionUtil.getInstance();
            tableNames = dao.showTables();
        } else {
            tableNames = ParamUtil.tableNames;
        }

        return tableNames;

    }


    public static Map<String, List<TableColumn>> getColumns() throws Exception {
        log.debug("获取需要生成的表和字段");
        List<String> tableNames = getTableNames();
        if (tableNames == null || tableNames.isEmpty()) {
            throw new Exception("请检查表名");
        }
        Map<String, List<TableColumn>> listMap = new HashMap<String, List<TableColumn>>();
        for (String tableName : tableNames) {
            log.debug("需要生成的表有"+tableName);
            ITableDao instance = SqlSessionUtil.getInstance();
            List<TableColumn> tableColumns = instance.showFields(tableName);
            listMap.put(tableName, tableColumns);
        }
        return listMap;

    }
}
