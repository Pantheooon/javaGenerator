package util;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by admin on 2017/9/19.
 */
public class Resource {

    private static final String PARAM_PROPERTY_NAME = "param";
    private static Map<String, ResourceBundle> map = new HashMap();

    private static ResourceBundle getResourceBundle(String str) {
        ResourceBundle resourceBundle = null;
        if (map.get(str) == null) {
            resourceBundle = ResourceBundle.getBundle(str, Locale.SIMPLIFIED_CHINESE);
            map.put(str, resourceBundle);

        } else {
            resourceBundle = map.get(str);
        }
        return resourceBundle;
    }


    /**
     * name为文件的key
     *
     * @param name
     * @return
     */
    public static String getValue(String name) {
        ResourceBundle resourceBundle = getResourceBundle(PARAM_PROPERTY_NAME);
        return resourceBundle.getString(name);
    }
}
