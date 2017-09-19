package util;

/**
 * Created by admin on 2017/9/19.
 */
public class ConvertUtil {


    /**
     * 将字段名转为驼峰命名
     *
     * @param name
     * @return
     */
    public static String camelName(String name) {
        StringBuilder result = new StringBuilder();
        if (name == null || name == "") {
            return "";
        } else if (!name.contains("_")) {
            return name.substring(0, 1).toLowerCase() + name.substring(1);
        }
        String camels[] = name.split("_");
        for (String camel : camels) {
            if (camel == null) {
                continue;
            }
            if (result.length() == 0) {
                result.append(camel.toLowerCase());
            } else {
                result.append(camel.substring(0, 1).toUpperCase());
                result.append(camel.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

    public static String javaType(String type) {
        if (type == null || type == "") {
            return "";
        }
        if (type.startsWith("varchar") || type.startsWith("char") || type.startsWith("longtext") || type.startsWith("text")) {
            return "String";
        } else if (type.startsWith("int")) {
            return "Integer";
        } else if (type.startsWith("bigint")) {
            return "Long";
        } else if (type.startsWith("double")) {
            return "Double";
        } else if (type.startsWith("date") || type.startsWith("time")) {
            return "Date";
        } else if (type.startsWith("tinyint")) {
            return "Boolean";
        }
        return type;
    }
}
