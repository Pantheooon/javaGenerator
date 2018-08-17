package ${urlMap.baseUrl}.${urlMap.beanUrl};
import org.apache.ibatis.type.Alias;


@Alias("${tableName?cap_first}")
public class ${tableName?cap_first}{

    <#list column as pro>

    /**
     * <#if pro.comment??>${pro.comment}</#if>
     */
    private ${pro.javaType} ${pro.javaName};
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