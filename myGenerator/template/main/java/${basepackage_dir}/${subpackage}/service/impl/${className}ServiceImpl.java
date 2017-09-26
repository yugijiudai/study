<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage}.service.impl;

import lombok.extern.<#if loggerType ? contains("Log4j")>log4j<#else>slf4j</#if>.${loggerType};
import ${basepackage}.${subpackage}.${daoPackage}.${className}${daoSuffix};
import ${basepackage}.${subpackage}.${pojoPackage}.${className};
import ${basepackage}.${subpackage}.service.${className}Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("${classNameLower}ServiceImpl")
@${loggerType}
public class ${className}ServiceImpl implements ${className}Service {

    @Resource
    private ${className}${daoSuffix} ${classNameLower}${daoSuffix};


    @Override
    public ${className} get${className}ById(${table.idColumn.possibleShortJavaType} ${table.idColumn.columnNameLower}) {
        return ${classNameLower}${daoSuffix}.get${className}ById(${table.idColumn.columnNameLower});
    }

    @Override
    public int add${className}(${className} ${classNameLower}) {
        return ${classNameLower}${daoSuffix}.add${className}(${classNameLower});
    }


    @Override
    public void remove${className}(${table.idColumn.possibleShortJavaType} ${table.idColumn.columnNameLower}) {
        ${classNameLower}${daoSuffix}.remove${className}(${table.idColumn.columnNameLower});
    }

    @Override
    public void update${className}(${className} ${classNameLower}) {
        ${classNameLower}${daoSuffix}.update${className}(${classNameLower});
    }


}
