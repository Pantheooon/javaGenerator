package ${baseUrl}.${beanUrl}

public class ${tableName?cap_first}{

    <#list props as pro>
    private ${pro.javaType} ${pro.name};  <#if pro.comment??>/*${pro.comment}*/</#if>
    </#list>


    //setter and getter

    <#list props as pro>
    public void set${pro.name?cap_first}(${pro.javaType} ${pro.name}){
            this.${pro.name} = ${pro.name};
    }
    public ${pro.javaType} get${pro.name?cap_first}(){
        return this.${pro.name};
    }
    </#list>

}