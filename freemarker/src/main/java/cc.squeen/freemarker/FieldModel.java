package cc.squeen.freemarker;

public class FieldModel {
    private String columnName; // 字段名称
    private String columnType; // 类型,返回SqlType中的编号
    private String columnTypeName; // 数据类型名
    private String catalogName; // Catalog名字
    private String columnClassName; // 数据类型的类
    private String columnDisplaySize; // 在数据库中类型的最大字符个数
    private String columnLabel; // 默认的列的标题
    private String schemaName; // 模式
    private String precision; // 类型的精确度(类型的长度)
    private String scale; // 小数点后的位数
    private String tableName; // 对应的表名
    private String isAutoInctement; // 是否自动递增
    private String isCurrency; // 在数据库中是否为货币型
    private String isNullable; // 是否为空
    private String isReadOnly; // 是否为只读
    private String isSearchable; // 能否出现在where中

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnTypeName() {
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

    public String getColumnDisplaySize() {
        return columnDisplaySize;
    }

    public void setColumnDisplaySize(String columnDisplaySize) {
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

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getIsAutoInctement() {
        return isAutoInctement;
    }

    public void setIsAutoInctement(String isAutoInctement) {
        this.isAutoInctement = isAutoInctement;
    }

    public String getIsCurrency() {
        return isCurrency;
    }

    public void setIsCurrency(String isCurrency) {
        this.isCurrency = isCurrency;
    }

    public String getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
    }

    public String getIsReadOnly() {
        return isReadOnly;
    }

    public void setIsReadOnly(String isReadOnly) {
        this.isReadOnly = isReadOnly;
    }

    public String getIsSearchable() {
        return isSearchable;
    }

    public void setIsSearchable(String isSearchable) {
        this.isSearchable = isSearchable;
    }

    @Override
    public String toString() {
        return "FieldModel{" +
                "columnName='" + columnName + '\'' +
                ", columnType='" + columnType + '\'' +
                ", columnTypeName='" + columnTypeName + '\'' +
                ", catalogName='" + catalogName + '\'' +
                ", columnClassName='" + columnClassName + '\'' +
                ", columnDisplaySize='" + columnDisplaySize + '\'' +
                ", columnLabel='" + columnLabel + '\'' +
                ", schemaName='" + schemaName + '\'' +
                ", precision='" + precision + '\'' +
                ", scale='" + scale + '\'' +
                ", tableName='" + tableName + '\'' +
                ", isAutoInctement='" + isAutoInctement + '\'' +
                ", isCurrency='" + isCurrency + '\'' +
                ", isNullable='" + isNullable + '\'' +
                ", isReadOnly='" + isReadOnly + '\'' +
                ", isSearchable='" + isSearchable + '\'' +
                '}';
    }
}
