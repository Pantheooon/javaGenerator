package Client;

import factory.SqlSessionUtil;
import model.TableColumn;
import parse.ParseFilterChain;
import util.ConvertUtil;
import util.TableUtil;
import util.ParamUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/9/20.
 */
public class Gogogo {

    private ParseFilterChain parseFilterChain;

    private Map<String, List<TableColumn>> map;

    private void init() throws Exception {
        //解析参数,获取需要解析的表
        ParamUtil.parseParam();
        //解析表
        map = TableUtil.getColumns();
        //创建解析器执行链
        parseFilterChain = new ParseFilterChain();
    }


    public void start() {
        try {
            init();
            for (String tables : map.keySet()) {
                Map<String, Object> root = new HashMap<String, Object>();
                root.put("column", map.get(tables));
                root.put("tableName", ConvertUtil.camelName(tables));
                root.put("jdbcTableName", tables);
                root.put("author", ParamUtil.author);
                root.put("urlMap", ParamUtil.urlMap);
                parseFilterChain.parse(root);
            }
            System.out.println("恭喜生成成功,代码在项目out目录下");
        } catch (Exception e) {
            System.err.println("生成错误");
        } finally {
            try {
                parseFilterChain.realse();
                SqlSessionUtil.realse();
            } catch (Exception e) {
                System.err.println("资源释放出错");
            }
        }
    }
}
