package util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/9/19.
 */
public class ParamUtil {

    public static Map<String, String> urlMap;

    public static boolean generateAll;

    public static List<String> tableNames;

    public static String author;



    public static void parseParam() throws Exception {
        String generate_all = Resource.getValue("generate_all");
        if (generate_all == null || generate_all == "" || generate_all != "true" || generate_all != "true") {
            throw new Exception("请检查generate_all");
        }
        generateAll = Boolean.parseBoolean(generate_all);
        if (generateAll == true) {
            String tableName = Resource.getValue("table_name");
            String[] split = tableName.split(",");
            tableNames = Arrays.asList(split);
        }
        urlMap.put("baseUrl", getUrl("url.base_url"));
        urlMap.put("baseUrl", getUrl("url.control_url"));
        urlMap.put("baseUrl", getUrl("url.iService_url"));
        urlMap.put("baseUrl", getUrl("url.service_url"));
        urlMap.put("baseUrl", getUrl("url.dao_url"));
        urlMap.put("baseUrl", getUrl("url.bean_url"));

        String au = Resource.getValue("author");
        if (author == null || author == "") {
            throw new Exception("请检查author");
        }
        author = au;
    }


    private static String getUrl(String name) throws Exception {
        String url = Resource.getValue(name);
        if (url == null || url == "") {
            throw new Exception("请填写" + name);
        }
        if (url.startsWith(".")) {
            url = url.substring(1, url.length());
        }
        if (url.endsWith(".")) {
            url = url.substring(0, url.length() - 1);
        }
        return url;
    }

}
