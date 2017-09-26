<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${urlMap.baseUrl}.${urlMap.daoUrl}.I${tableName?cap_first}Dao">
    <resultMap type="${tableName?cap_first}" id="${tableName}ResultMap">
    <#list column as pro>
        <result property="${pro.javaName}" column="${pro.field}"/>
    </#list >
    </resultMap>

    <sql id="table_columns">
    <#list column as pro>
    ${pro.field}<#if pro_has_next>,</#if>
    </#list>
    </sql>
    <sql id="entity_properties">
    <#list column as pro>
    ${r"#"}{${pro.javaName}}<#if pro_has_next>,</#if>
    </#list>
    </sql>

    <!-- 适用于主键自增类型 -->
    <insert id="insert" parameterType="${tableName?cap_first}" useGeneratedKeys="true" keyProperty="id">
        insert into ${jdbcTableName}(
        <include refid="table_columns"/>
        )
        values (
        <include refid="entity_properties"/>
        )
    </insert>

    <update id="update" parameterType="${tableName?cap_first}">
        update ${jdbcTableName}
        <trim prefix="set" suffixOverrides=",">
        <#list column as pro>
            <if test="${pro.javaName} != null and ${pro.javaName} != ''">${pro.field} =  ${r"#"}{${pro.javaName}},</if>
        </#list>
        </trim>
        <where>id = ${r"#"}{id}</where>
    </update>

    <select id="findById" resultMap="aggrementTemplateResultMap" parameterType="String">
        select
        <include refid="table_columns"/>
        from ${jdbcTableName}
        where id = ${r"#"}{id}
    </select>


    <!-- 使用like用法：columnName like concat('%',#columnName#,'%') -->
    <sql id="page_where">
        <trim prefix="where" prefixOverrides="and | or ">
        <#list column as pro>
            <if test="${pro.javaName} != null and ${pro.javaName} != ''">${pro.field} =  ${r"#"}{${pro.javaName}},</if>
        </#list>
        </trim>
    </sql>

    <select id="search" resultMap="aggrementTemplateResultMap" parameterType="AggrementTemplate">
        select
        <include refid="table_columns"/>
        from ${jdbcTableName}
        <include refid="page_where"/>
    </select>

</mapper>