package cc.squeen.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args){

        String tableName = "gy_project";
        String className = "Project";
        String modelPackageName = "cc.squeen.model";
        String queryPackageName = "cc.squeen.model";
        String daoPackageName = "cc.squeen.model";
        String servicePackageName = "cc.squeen.model";

        String templateDir = "D:\\JAVA\\IDEA_space\\Test\\freemarker\\src\\main\\webapp\\WEB-INF\\ftl\\";
        Configuration conf = new Configuration();
        //设置模版路径
        try {
            conf.setDirectoryForTemplateLoading(new File(templateDir));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //准备数据
        HashMap<String, Object> dataMap = new HashMap<String, Object>();
        List<FieldModel> field_list = TestDemo.getFieldModel_list(tableName);

        dataMap.put("fields",field_list);

        //输出目标路径
        String targetDir = "D:\\JAVA\\IDEA_space\\Test\\freemarker\\src\\main\\java\\cc\\squeen\\model\\";

        try {
            generateModel(conf,field_list,className,targetDir,modelPackageName);
            generateXml(conf,field_list,className,targetDir);
            generateDao(conf,className,targetDir,queryPackageName,modelPackageName,daoPackageName);
            generateQuery(conf,field_list,className,targetDir,queryPackageName);
            generateService(conf,className,targetDir,modelPackageName,queryPackageName,servicePackageName);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("生成完毕");
    }

    public static void generateQuery(Configuration configuration, List<FieldModel> field_list,
                                     String className, String targetDir,
                                     String queryPackageName) throws Exception{
        // 获取模版
        Template template = configuration.getTemplate("Query.html");

        //准备数据
        HashMap<String, Object> dataMap = new HashMap<String, Object>();

        dataMap.put("fields",field_list);
        dataMap.put("queryPackageName",queryPackageName);
        dataMap.put("className",className);

        File targetFile = new File(targetDir + className + "Query.java");
        //准备输出流
        FileWriter fileWriter = new FileWriter(targetFile);

        //输出
        template.process(dataMap,fileWriter);
        //关闭流
        fileWriter.close();
    }

    public static void generateDao(Configuration configuration,
                                   String className, String targetDir,String queryPackageName,
                                   String modelPackageName,String daoPackageName) throws Exception{
        // 获取模版
        Template template = configuration.getTemplate("Dao.html");
        //准备数据
        HashMap<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("className",className);
        dataMap.put("modelPackageName",modelPackageName);
        dataMap.put("queryPackageName",queryPackageName);
        dataMap.put("daoPackageName",daoPackageName);

        File targetFile = new File(targetDir + className + "Dao.java");
        //准备输出流
        FileWriter fileWriter = new FileWriter(targetFile);

        //输出
        template.process(dataMap,fileWriter);
        //关闭流
        fileWriter.close();
    }

    public static void generateService(Configuration configuration,
                                   String className, String targetDir,
                                   String modelPackageName, String queryPackageName,
                                   String servicePackageName) throws Exception{
        // 获取模版
        Template template = configuration.getTemplate("Service.html");
        //准备数据
        HashMap<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("className",className);
        dataMap.put("modelPackageName",modelPackageName);
        dataMap.put("queryPackageName",queryPackageName);
        dataMap.put("servicePackageName",servicePackageName);

        File targetFile = new File(targetDir + className + "Service.java");
        //准备输出流
        FileWriter fileWriter = new FileWriter(targetFile);

        //输出
        template.process(dataMap,fileWriter);
        //关闭流
        fileWriter.close();
    }

    public static void generateXml(Configuration configuration, List<FieldModel> field_list,
                                   String className, String targetDir) throws Exception{
        //获取模版
        Template template = configuration.getTemplate("sqlMapper.html");

        //准备数据
        HashMap<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("fields",field_list);

        File targetFile = new File(targetDir + className + ".xml");
        //准备输出流
        FileWriter fileWriter = new FileWriter(targetFile);

        //输出
        template.process(dataMap,fileWriter);
        //关闭流
        fileWriter.close();
    }

    public static void generateModel(Configuration configuration, List<FieldModel> field_list,
                                     String className, String targetDir,
                                     String packageName) throws Exception{
        // 获取模版
        Template template = configuration.getTemplate("Model.html");

        //准备数据
        HashMap<String, Object> dataMap = new HashMap<String, Object>();

        dataMap.put("fields",field_list);
        dataMap.put("packageName",packageName);
        dataMap.put("className",className);

        File targetFile = new File(targetDir + className + ".java");
        //准备输出流
        FileWriter fileWriter = new FileWriter(targetFile);

        //输出
        template.process(dataMap,fileWriter);
        //关闭流
        fileWriter.close();
    }

}
