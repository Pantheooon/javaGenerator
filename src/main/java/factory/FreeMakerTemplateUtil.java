package factory;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.IOException;
import java.util.Map;

/**
 * Created by admin on 2017/9/21.
 */
public class FreeMakerTemplateUtil {

    private static Map<String, Template> templates;

    public static Template getTemplate(String type) throws IOException {
        Template template = FreeMakerTemplateUtil.templates.get(type);
        if (template == null) {
            Configuration cfg = new Configuration();
            cfg.setClassForTemplateLoading(FreeMakerTemplateUtil.class, "/template");
            template = cfg.getTemplate("control.ftl");
            templates.put(type, template);
        }
        return template;
    }
}
