<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage}.service;
import ${basepackage}.${subpackage}.${pojoPackage}.${className};

public interface ${className}Service {

    void update${className}(${className} ${classNameLower});

    ${className} get${className}ById(${table.idColumn.possibleShortJavaType} ${table.idColumn.columnNameLower});

    int add${className}(${className} ${classNameLower});

    void remove${className}(${table.idColumn.possibleShortJavaType} ${table.idColumn.columnNameLower});

}
