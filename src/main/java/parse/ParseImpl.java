package parse;

import factory.FreeMakerTemplateUtil;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.Map;

/**
 * Created by admin on 2017/9/20.
 */
public class ParseImpl extends AbstractParseFilter {

    public ParseImpl(String type) {
        super(type);
    }

    public void parseFreeMarker(Map<String, Object> root) {
        try {
            Template control = FreeMakerTemplateUtil.getTemplate(super.parseType);
            String filePath = super.projectPath + SEPARATOR_SYMBOL + DIRECTORY_NAME + SEPARATOR_SYMBOL + parseType + SEPARATOR_SYMBOL + getFileName((String) root.get("tableName"));
            out = new OutputStreamWriter(new FileOutputStream(filePath));
            control.process(root, out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }


}
