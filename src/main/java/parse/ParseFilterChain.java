package parse;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/9/20.
 */
public class ParseFilterChain {

    private List<AbstractParseFilter> parseFilterList;


    private static final Log log = LogFactory.getLog(ParseFilterChain.class);

    public ParseFilterChain() {
        initFilterList();
    }

    private void initFilterList() {
        log.debug("开始初始化");
        parseFilterList = new ArrayList<AbstractParseFilter>();
        parseFilterList.add(new ParseImpl("control"));
        parseFilterList.add(new ParseImpl("service"));
        parseFilterList.add(new ParseImpl("serviceImpl"));
        parseFilterList.add(new ParseImpl("dao"));
        parseFilterList.add(new ParseImpl("bean"));
        parseFilterList.add(new ParseImpl("mapper"));
    }

    public void parse(Map<String, Object> root) throws Exception {
        if (parseFilterList == null || parseFilterList.isEmpty()) {
            throw new NullPointerException("请初始化解析器");
        }
        log.debug("开始解析");
        for (AbstractParseFilter parseFilter : parseFilterList) {
            parseFilter.parseFreeMarker(root);
        }

    }

    public void realse() throws Exception {
        for (AbstractParseFilter parseFilter : parseFilterList) {
            parseFilter.realse();
        }
    }
}
