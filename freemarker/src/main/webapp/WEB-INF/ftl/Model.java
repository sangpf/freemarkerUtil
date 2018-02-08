package ${packageName};

import java.io.Serializable;
import java.util.Date;

public class ${className} implements Serializable{
	<#list fields as field>
	private ${field.columnTypeName} ${field.columnName};
	</#list>

	<#list fields as field>
	public ${field.columnTypeName} ${field.getName}() {
		return ${field.columnName};
	}
	public void ${field.setName}(${field.columnTypeName} ${field.columnName}) {
		this.${field.columnName} = ${field.columnName};
	}

	</#list>

}