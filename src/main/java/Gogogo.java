import parse.ParseFilterChain;
import util.ParamUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/9/20.
 */
public class Gogogo {

    private ParseFilterChain parseFilterChain;

    private void init() throws Exception {
        //解析参数,获取需要解析的表
        ParamUtil.parseParam();
        //解析表
        Map<String, Object> map = new HashMap();
        //创建解析器执行链
        parseFilterChain = new ParseFilterChain(map);
    }


    public void start() throws Exception {
        init();
        parseFilterChain.parse();
    }
}
