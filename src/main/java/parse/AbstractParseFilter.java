package parse;

import java.io.File;
import java.io.Writer;
import java.util.Map;

/**
 * Created by admin on 2017/9/21.
 */
public abstract class AbstractParseFilter {


    protected String parseType;


    protected final String SEPARATOR_SYMBOL = "/";

    protected final String DIRECTORY_NAME = "out";

    protected Writer out;

    String projectPath = System.getProperty("user.dir");


    public AbstractParseFilter(String parseType) {
        this.parseType = parseType;
        generateFile();
    }

    public abstract void parseFreeMarker(Map<String, Object> root);


    protected void generateFile() {
        File file = new File(projectPath + SEPARATOR_SYMBOL + DIRECTORY_NAME + SEPARATOR_SYMBOL + parseType);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public void realse() throws Exception {
        if (out == null) {
            throw new Exception("释放资源出错");
        }
        out.close();

    }

    protected String getFileName(String name) {
        String fileName = "";
        String upperFirst = name.substring(0, 1).toUpperCase() + name.substring(1);
        switch (parseType) {
            case "control":
                fileName = upperFirst + "Controller.java";
                break;
            case "service":
                fileName = "I" + upperFirst + "Service.java";
                break;
            case "serviceImpl":
                fileName = upperFirst + "ServiceImpl.java";
                break;
            case "dao":
                fileName = "I" + upperFirst + "Dao.java";
                break;
            case "mapper":
                fileName = upperFirst + ".xml";
                break;
            case "bean":
                fileName = upperFirst + ".java";
                break;
            default:
                fileName = "error";
        }
        return fileName;
    }

}
