<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage}.${daoPackage};

import org.apache.ibatis.annotations.Param;
import ${basepackage}.${subpackage}.${pojoPackage}.${className};
import org.springframework.stereotype.Repository;

@Repository
public interface ${className}${daoSuffix} {

    void update${className}(${className} ${classNameLower});

    ${className} get${className}ById(@Param(value = "id") ${table.idColumn.possibleShortJavaType} ${table.idColumn.columnNameLower});

    int add${className}(${className} ${classNameLower});

    void remove${className}(@Param(value = "id") ${table.idColumn.possibleShortJavaType} ${table.idColumn.columnNameLower});

}
