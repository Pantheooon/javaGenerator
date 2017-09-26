package ${urlMap.baseUrl}.${urlMap.beanUrl}

public class ${tableName?cap_first}{

    <#list column as pro>
    private ${pro.javaType} ${pro.javaName};  <#if pro.comment??>//${pro.comment}</#if>
    </#list>


    //setter and getter

    <#list column  as pro>
    public void set${pro.javaName?cap_first}(${pro.javaType} ${pro.javaName}){
            this.${pro.javaName} = ${pro.javaName};
    }
    public ${pro.javaType} get${pro.javaName?cap_first}(){
        return this.${pro.javaName};
    }
    </#list>

}