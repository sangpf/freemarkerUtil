package cc.squeen.freemarker;

public class FieldModel {
    private String columnName; // 字段名称
    private String upperColumnName; // 字段名称
    private Integer columnType; // 类型,返回SqlType中的编号
    private String columnTypeName; // 数据类型名
    private String catalogName; // Catalog名字
    private String columnClassName; // 数据类型的类
    private Integer columnDisplaySize; // 在数据库中类型的最大字符个数
    private String columnLabel; // 默认的列的标题
    private String schemaName; // 模式
    private Integer precision; // 类型的精确度(类型的长度)
    private Integer scale; // 小数点后的位数
    private String tableName; // 对应的表名
    private boolean isAutoInctement; // 是否自动递增
    private boolean isCurrency; // 在数据库中是否为货币型
    private Integer isNullable; // 是否为空
    private boolean isReadOnly; // 是否为只读
    private boolean isSearchable; // 能否出现在where中

    private String columnComment; //从数据库中读取备注

    private String modelColumnName_1;  //代表模型中 #
    private String modelColumnName_2;  // 代表模型中 $

    public String getModelColumnName_1() {
        return "#{"+columnName+"}";
    }

    public void setModelColumnName_1(String modelColumnName_1) {
        this.modelColumnName_1 = modelColumnName_1;
    }

    public String getModelColumnName_2() {
        return "${"+columnName+"}";
    }

    public void setModelColumnName_2(String modelColumnName_2) {
        this.modelColumnName_2 = modelColumnName_2;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Integer getColumnType() {
        return columnType;
    }

    public void setColumnType(Integer columnType) {
        this.columnType = columnType;
    }

    public String getColumnTypeName() {
        if (columnTypeName.equals("INT") || columnTypeName.equals("TINYINT")){
            columnTypeName = "Integer";
        }else if (columnTypeName.equals("VARCHAR")){
            columnTypeName = "String";
        }else if (columnTypeName.equals("DATETIME") || columnTypeName.equals("TIMESTAMP")){
            columnTypeName = "Date";
        }

        return columnTypeName;
    }

    public void setColumnTypeName(String columnTypeName) {
        this.columnTypeName = columnTypeName;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getColumnClassName() {
        return columnClassName;
    }

    public void setColumnClassName(String columnClassName) {
        this.columnClassName = columnClassName;
    }

    public Integer getColumnDisplaySize() {
        return columnDisplaySize;
    }

    public void setColumnDisplaySize(Integer columnDisplaySize) {
        this.columnDisplaySize = columnDisplaySize;
    }

    public String getColumnLabel() {
        return columnLabel;
    }

    public void setColumnLabel(String columnLabel) {
        this.columnLabel = columnLabel;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public boolean isAutoInctement() {
        return isAutoInctement;
    }

    public void setAutoInctement(boolean autoInctement) {
        isAutoInctement = autoInctement;
    }

    public boolean isCurrency() {
        return isCurrency;
    }

    public void setCurrency(boolean currency) {
        isCurrency = currency;
    }

    public Integer getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(Integer isNullable) {
        this.isNullable = isNullable;
    }

    public boolean isReadOnly() {
        return isReadOnly;
    }

    public void setReadOnly(boolean readOnly) {
        isReadOnly = readOnly;
    }

    public boolean isSearchable() {
        return isSearchable;
    }

    public void setSearchable(boolean searchable) {
        isSearchable = searchable;
    }

    public String upperCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
//    public String getSetName() {
//        this.setName = "set"+upperCase(this.columnName);
//        return setName;
//    }
//
//    public String getGetName() {
//        this.getName = "get"+upperCase(this.columnName);
//        return getName;
//    }

    public String getColumnComment() {
        return columnComment;
    }
    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getUpperColumnName() {
        this.upperColumnName = upperCase(columnName);
        return upperColumnName;
    }

    @Override
    public String toString() {
        return "FieldModel{" +
                "columnName='" + columnName + '\'' +
                ", columnType=" + columnType +
                ", columnTypeName='" + columnTypeName + '\'' +
                ", catalogName='" + catalogName + '\'' +
                ", columnClassName='" + columnClassName + '\'' +
                ", columnDisplaySize=" + columnDisplaySize +
                ", columnLabel='" + columnLabel + '\'' +
                ", schemaName='" + schemaName + '\'' +
                ", precision=" + precision +
                ", scale=" + scale +
                ", tableName='" + tableName + '\'' +
                ", isAutoInctement=" + isAutoInctement +
                ", isCurrency=" + isCurrency +
                ", isNullable=" + isNullable +
                ", isReadOnly=" + isReadOnly +
                ", isSearchable=" + isSearchable +
                '}';
    }
}
