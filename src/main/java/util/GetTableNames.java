package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/9/19.
 */
public class GetTableNames {


    public static List<String> getTableNames(String names) throws Exception {
        if (names == "" || names == null) {
            throw new Exception("请填写需要生成的表名！");
        }
        if (names.startsWith(",")) {
            throw new Exception("请检查需要生成的表名，首字母不能是,开始！");
        }
        List<String> tables = new ArrayList<String>();
        if (names.contains(",")) {
            String[] split = names.split(",");
            for (String s : split) {
                tables.add(s);
            }
        } else {
            tables.add(names);
        }

        return tables;
    }
}
