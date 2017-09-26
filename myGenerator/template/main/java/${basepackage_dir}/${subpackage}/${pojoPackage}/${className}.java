<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage}.${pojoPackage};
import lombok.Data;
/**
 * ${table.tableAlias}
 * @author Parky
 *
 */
@Data
public class ${className} {

    <#list table.columns as column>
    /**
     * ${column.columnAlias}
     */
    private ${column.possibleShortJavaType} ${column.columnNameLower};

    </#list>

}