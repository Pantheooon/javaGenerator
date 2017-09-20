package parse;

import org.apache.log4j.spi.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by admin on 2017/9/20.
 */
public class ParseFilterChain {

    private List<ParseFilter> parseFilterList;

    private Map<String, Object> map;

    private Logger log = Logger.getLogger("ParseFilterChain");

    public ParseFilterChain(Map<String, Object> map) {
        init();
        this.map = map;
    }

    private void init() {
        log.info("初始化解析器");
    }

    public void parse() {
        if (parseFilterList == null || !parseFilterList.isEmpty()) {
            throw new NullPointerException("请初始化解析器");
        }
        log.info("开始解析");
        for (ParseFilter parseFilter : parseFilterList) {
            parseFilter.parseFreeMarker(map);
        }

    }
}
