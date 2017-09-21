package parse;

import java.util.Map;

/**
 * Created by admin on 2017/9/21.
 */
public abstract class AbstractParseFilter {

    private String outUrl;

    public AbstractParseFilter(String outUrl) {
        this.outUrl = outUrl;
    }

    public abstract void parseFreeMarker(Map<String, Object> map);

    public abstract void out();

    public void parseAndOut(Map<String, Object> root) {
        parseFreeMarker(root);
        out();
    }
}
