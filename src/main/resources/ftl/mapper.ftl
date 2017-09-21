<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${baseUrl}.${daoUrl}.I${tableName?cap_first}Dao">
    <resultMap type="${tableName?cap_first}" id="${tableName}ResultMap">
    <#list props as pro>
        <result property="${pro.name}" column="${pro.jdbcName}"/>
    </#list >
    </resultMap>

    <sql id="table_columns">
    <#list props as pro>
    ${pro.jdbcName}<#if pro_has_next>,</#if>
    </#list>
    </sql>
    <sql id="entity_properties">
    <#list props as pro>
    ${r"#"}{${pro.name}}<#if pro_has_next>,</#if>
    </#list>
    </sql>

    <!-- 适用于主键自增类型 -->
    <insert id="save" parameterType="${tableName?cap_first}" useGeneratedKeys="true" keyProperty="id">
        insert into ${pro.jdbcName}(
        <include refid="table_columns"/>
        )
        values (
        <include refid="entity_properties"/>
        )
    </insert>

    <update id="update" parameterType="${tableName?cap_first}">
        update aggrement_template
        <trim prefix="set" suffixOverrides=",">
            <if test="sku != null and sku != ''">sku = #{sku},</if>
            <if test="classTypeId != null and classTypeId != ''">class_type_id = #{classTypeId},</if>
            <if test="type != null and type != ''">type = #{type},</if>
            <if test="title != null and title != ''">title = #{title},</if>
            <if test="company != null and company != ''">company = #{company},</if>
            <if test="expense != null and expense != ''">expense = #{expense},</if>
            <if test="content != null ">content = #{content},</if>
            <if test="validity != null">validity = #{validity},</if>
            <if test="creator != null and creator != ''">creator = #{creator},</if>
            <if test="createTime != null and createTime != ''">create_time = #{createTime},</if>
            <if test="updator != null and updator != ''">updator = #{updator},</if>
            <if test="updateTime != null and updateTime != ''">update_time = #{updateTime},</if>
        </trim>
        <where>id = #{id}</where>
    </update>

    <select id="findById" resultMap="aggrementTemplateResultMap" parameterType="String">
        select
        <include refid="table_columns"/>
        from aggrement_template
        where id = #{id}
    </select>


    <!-- 使用like用法：columnName like concat('%',#columnName#,'%') -->
    <sql id="page_where">
        <trim prefix="where" prefixOverrides="and | or ">
            <if test="sku != null and sku != ''">and sku = #{sku}</if>
            <if test="classTypeId != null and classTypeId != ''">and class_type_id = #{classTypeId}</if>
            <if test="type != null and type != ''">and type = #{type}</if>
            <if test="title != null and title != ''">and title = #{title}</if>
            <if test="company != null and company != ''">and company = #{company}</if>
            <if test="expense != null and expense != ''">and expense = #{expense}</if>
            <if test="content != null and content != ''">and content = #{content}</if>
            <if test="validity != null and validity != ''">and validity = #{validity}</if>
            <if test="creator != null and creator != ''">and creator = #{creator}</if>
            <if test="createTime != null and createTime != ''">and create_time = #{createTime}</if>
            <if test="updator != null and updator != ''">and updator = #{updator}</if>
            <if test="updateTime != null and updateTime != ''">and update_time = #{updateTime}</if>
        </trim>
    </sql>

    <select id="search" resultMap="aggrementTemplateResultMap" parameterType="AggrementTemplate">
        select
        <include refid="table_columns"/>
        from aggrement_template
        <include refid="page_where"/>
    </select>

</mapper>