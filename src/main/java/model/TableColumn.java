package model;

import util.ConvertUtil;

/**
 * Created by admin on 2017/9/19.
 */
public class TableColumn {
    private String field;
    private String type;
    private String comment;
    private String javaName;
    private String javaType;

    public String getField() {
        return field;
    }

    public TableColumn setField(String field) {
        this.javaName = ConvertUtil.camelName(field);
        this.field = field;

        return this;
    }

    public String getType() {
        return type;
    }

    public TableColumn setType(String type) {
        this.type = type;
        this.javaType = ConvertUtil.javaType(type);
        return this;
    }

    public String getComment() {
        return comment;
    }

    public TableColumn setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
