package factory;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/9/21.
 */
public class FreeMakerTemplateUtil {

    private static Map<String, Template> templates = new HashMap<String, Template>();

    public static Template getTemplate(String type) throws IOException {
        Template template = FreeMakerTemplateUtil.templates.get(type);
        if (template == null) {
            Configuration cfg = new Configuration();
            cfg.setClassForTemplateLoading(FreeMakerTemplateUtil.class, "/ftl");
            template = cfg.getTemplate(type + ".ftl");
            templates.put(type, template);
        }
        return template;
    }

}
