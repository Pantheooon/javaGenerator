package parse;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by admin on 2017/9/20.
 */
public class ParseFilterChain {

    private List<AbstractParseFilter> parseFilterList;

    private Map<String, Object> map;

    private Logger log = Logger.getLogger("ParseFilterChain");

    public ParseFilterChain(Map<String, Object> map) {
        init();
        this.map = map;
    }

    private void init() {
        log.info("初始化解析器");
        String path = System.getProperty("usr.dir")+"/out";
        parseFilterList.add(new ParseControl(path+"/control"));
        parseFilterList.add(new ParseService(path+"/service"));
        parseFilterList.add(new ParseServiceImpl(path+"/serviceImpl"));
        parseFilterList.add(new ParseDao(path+"/dao"));
        parseFilterList.add(new ParseBean(path+"/bean"));
        parseFilterList.add(new ParseXml(path+"/xml"));
    }

    public void parse() {
        if (parseFilterList == null || !parseFilterList.isEmpty()) {
            throw new NullPointerException("请初始化解析器");
        }
        log.info("开始解析");
        for (String s : map.keySet()) {
            map.get()
        }
        for (AbstractParseFilter parseFilter : parseFilterList) {
            parseFilter.parseAndOut(map);
        }

    }
}
