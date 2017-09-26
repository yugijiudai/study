<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
<#assign classNameUpper = className?upper_case>
<#assign sqlName = table.sqlName>   
<#assign sqlNameLower = sqlName?uncap_first>   
<#assign sqlNameUpper = sqlName?upper_case>
<#assign allColumns = table.columns>
<#assign columns = table.notPkColumns>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${basepackage}.${subpackage}.${daoPackage}.${className}${daoSuffix}">
<#--<mapper namespace="${className}">-->

	<resultMap id="${className}Result" type="${basepackage}.${subpackage}.${pojoPackage}.${className}">
		<id property="${table.idColumn.sqlName}" column="${sqlNameLower}_${table.idColumn.columnNameLower}"/>
		<#list columns as column>
		<result property="${column.columnNameLower}" column="${sqlNameLower}_${column.sqlName}" />
		</#list>
	</resultMap>


    <sql id="query${className}Result">
	<#list allColumns as column>
		${sqlNameLower}.${column.sqlName} AS ${sqlNameLower}_${column.sqlName}<#if column_has_next>,</#if>
	</#list>
    </sql>


	<insert id="add${className}" parameterType="${basepackage}.${subpackage}.${pojoPackage}.${className}" useGeneratedKeys= "true"  keyProperty= "${table.idColumn.columnNameLower}" >
		INSERT INTO ${sqlNameLower} (<#list columns as column>${column.sqlName}<#if column_has_next>, </#if></#list>)
		VALUES (<#list columns as column>${r"#{"}${column.columnNameLower}, jdbcType=${column.jdbcType}${r"}"}<#if column_has_next>, </#if></#list>)
	</insert>

	<select id="get${className}ById" resultMap="${className}Result">
		SELECT
        <include refid="query${className}Result"/>
		FROM ${sqlNameLower} AS ${sqlNameLower}
        <if test="id != null and id != ''">
		WHERE ${sqlNameLower}.${table.idColumn.sqlName} = ${r"#{"}id${r"}"}
		</if>
	</select>
	
	<update id="update${className}" parameterType="${basepackage}.${subpackage}.${pojoPackage}.${className}">
		UPDATE ${sqlNameLower}
		<trim prefix="SET" suffixOverrides=",">
		<#list columns as column>
		<#if !column.pk>
			<if test="${column.columnNameLower}!=null">
				${column.sqlName}=${r"#{"}${column.columnNameLower}, jdbcType=${column.jdbcType}${r"}"}<#if column_has_next>, </#if>
			</if>
		</#if>
		</#list>
        </trim>
		WHERE ${table.idColumn.sqlName} = ${r"#{"}${table.idColumn.columnNameLower}${r"}"}
	</update>
	
	<delete id="remove${className}">
		DELETE FROM ${sqlNameLower}
		WHERE ${table.idColumn.sqlName} = ${r"#{"}id${r"}"}
	</delete>



</mapper>