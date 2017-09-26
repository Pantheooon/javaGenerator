package util;

import java.util.*;

/**
 * Created by admin on 2017/9/19.
 */
public class ParamUtil {

    public static Map<String, String> urlMap = new HashMap<String, String>();

    public static boolean generateAll;

    public static List<String> tableNames;

    public static String author;


    public static void parseParam() throws Exception {
        String generate_all = Resource.getValue("generate_all");
        if (generate_all == null || generate_all == "" || (!generate_all.equals("true") && !generate_all.equals("false"))) {
            throw new Exception("请检查generate_all");
        }
        generateAll = Boolean.parseBoolean(generate_all);
        if (generateAll == false) {
            String tableName = Resource.getValue("table_name");
            if (tableName == null || tableName.equals("")) {
                throw new Exception("请检查需要生成的表名");
            }
            String[] split = tableName.split(",");
            tableNames = Arrays.asList(split);
        }
        urlMap.put("baseUrl", getUrl("url.base_url"));
        urlMap.put("controlUrl", getUrl("url.control_url"));
        urlMap.put("serviceUrl", getUrl("url.service_url"));
        urlMap.put("serviceImplUrl", getUrl("url.service_impl_url"));
        urlMap.put("daoUrl", getUrl("url.dao_url"));
        urlMap.put("beanUrl", getUrl("url.bean_url"));

        String au=new String(Resource.getValue("author").getBytes("ISO8859-1"),"GB2312");
        if (au == null || au.equals("")) {
            throw new Exception("请检查author");
        }
        author = au;
    }


    private static String getUrl(String name) throws Exception {
        String url = Resource.getValue(name);
        if (url == null || url.equals("")) {
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
