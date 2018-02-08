package cc.squeen.freemarker;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDemo {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/sang?useUnicode=true&characterEncoding=utf8";
//            String user = "root";
//            String pass = "sang123456";

            String url = "jdbc:mysql://101.200.166.221:3306/guoyan?useUnicode=true&characterEncoding=utf8";
            String user = "developer";
            String pass = "xindongchadb";

            conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static List<FieldModel> getFieldModel_list(String tableName){
        Connection connection = getConnection();
        String sql = "select * from "+tableName;

        List<FieldModel> filedModel_list = new ArrayList<FieldModel>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(sql);

            ResultSetMetaData metaData = resultSet.getMetaData();

            for (int i=1 ; i <= metaData.getColumnCount(); i++){
                FieldModel fieldModel = new FieldModel();
                fieldModel.setColumnName(metaData.getColumnName(i));
                fieldModel.setColumnType(metaData.getColumnType(i));
                fieldModel.setColumnTypeName(metaData.getColumnTypeName(i));
                fieldModel.setCatalogName(metaData.getCatalogName(i));
                fieldModel.setColumnClassName(metaData.getColumnClassName(i));
                fieldModel.setColumnDisplaySize(metaData.getColumnDisplaySize(i));
                fieldModel.setColumnLabel(metaData.getColumnLabel(i));
                fieldModel.setSchemaName(metaData.getSchemaName(i));
                fieldModel.setPrecision(metaData.getPrecision(i));
                fieldModel.setScale(metaData.getScale(i));
                fieldModel.setTableName(metaData.getTableName(i));
                fieldModel.setAutoInctement(metaData.isAutoIncrement(i));

                filedModel_list.add(fieldModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filedModel_list;
    }

    public static void main(String[] args) {
        Connection conn = getConnection();
        String sql = "select * from u_user";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData data = rs.getMetaData();
            for (int i = 1; i <= data.getColumnCount(); i++) {
                // 获得所有列的数目及实际列数
                int columnCount = data.getColumnCount();
                // 获得指定列的列名
                String columnName = data.getColumnName(i);
                // 获得指定列的列值
                int columnType = data.getColumnType(i);
                // 获得指定列的数据类型名
                String columnTypeName = data.getColumnTypeName(i);
                // 所在的Catalog名字
                String catalogName = data.getCatalogName(i);
                // 对应数据类型的类
                String columnClassName = data.getColumnClassName(i);
                // 在数据库中类型的最大字符个数
                int columnDisplaySize = data.getColumnDisplaySize(i);
                // 默认的列的标题
                String columnLabel = data.getColumnLabel(i);
                // 获得列的模式
                String schemaName = data.getSchemaName(i);
                // 某列类型的精确度(类型的长度)
                int precision = data.getPrecision(i);
                // 小数点后的位数
                int scale = data.getScale(i);
                // 获取某列对应的表名
                String tableName = data.getTableName(i);
                // 是否自动递增
                boolean isAutoInctement = data.isAutoIncrement(i);
                // 在数据库中是否为货币型
                boolean isCurrency = data.isCurrency(i);
                // 是否为空
                int isNullable = data.isNullable(i);
                // 是否为只读
                boolean isReadOnly = data.isReadOnly(i);
                // 能否出现在where中
                boolean isSearchable = data.isSearchable(i);
                System.out.println(columnCount);
                System.out.println("获得列" + i + "的字段名称:" + columnName);
                System.out.println("获得列" + i + "的类型,返回SqlType中的编号:"+ columnType);
                System.out.println("获得列" + i + "的数据类型名:" + columnTypeName);
                System.out.println("获得列" + i + "所在的Catalog名字:"+ catalogName);
                System.out.println("获得列" + i + "对应数据类型的类:"+ columnClassName);
                System.out.println("获得列" + i + "在数据库中类型的最大字符个数:"+ columnDisplaySize);
                System.out.println("获得列" + i + "的默认的列的标题:" + columnLabel);
                System.out.println("获得列" + i + "的模式:" + schemaName);
                System.out.println("获得列" + i + "类型的精确度(类型的长度):" + precision);
                System.out.println("获得列" + i + "小数点后的位数:" + scale);
                System.out.println("获得列" + i + "对应的表名:" + tableName);
                System.out.println("获得列" + i + "是否自动递增:" + isAutoInctement);
                System.out.println("获得列" + i + "在数据库中是否为货币型:" + isCurrency);
                System.out.println("获得列" + i + "是否为空:" + isNullable);
                System.out.println("获得列" + i + "是否为只读:" + isReadOnly);
                System.out.println("获得列" + i + "能否出现在where中:"+ isSearchable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}