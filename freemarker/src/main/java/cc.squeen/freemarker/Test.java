package cc.squeen.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args){

        //调查
//        String tableName = "gy_investigation";
//        String up_className = "Investigation";
//        String low_className = "investigation";

        // 答案
//        String tableName = "gy_answer";
//        String up_className = "Answer";
//        String low_className = "answer";

        String tableName = "gy_user";
        String up_className = "User";
        String low_className = "user";

//        String tableName = "gy_client";
//        String up_className = "Client";
//        String low_className = "client";

//        String tableName = "gy_question";
//        String up_className = "Question";
//        String low_className = "question";

//        String tableName = "gy_project";
//        String up_className = "Project";
//        String low_className = "project";
        
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
        List<FieldModel> field_list = MysqlUtil.getFieldModel_list(tableName);
        List<String> primaryKeys = MysqlUtil.getPrimaryKeys(tableName);

        String key = "";
        if (primaryKeys.size()>0){
            key = primaryKeys.get(0);
        }

        // 从集合中剔除主键
        Iterator<FieldModel> iterator = field_list.iterator();

        ArrayList<FieldModel> field_list_noKey = new ArrayList<FieldModel>();

        while (iterator.hasNext()){
            FieldModel next = iterator.next();
            String columnName = next.getColumnName();
            if (!columnName.equals(key)){
                field_list_noKey.add(next);
            }
        }

        //输出目标路径
        String targetDir = "D:\\JAVA\\IDEA_space\\Test\\freemarker\\src\\main\\java\\cc\\squeen\\model\\";

        try {
            generateModel(conf,field_list,up_className,low_className,targetDir);
            generateModelVo(conf,up_className,low_className,targetDir);
            generateXml(conf,field_list_noKey,key,up_className,low_className,tableName,targetDir);
            generateDao(conf,up_className,low_className,targetDir);
            generateQuery(conf,field_list,up_className,low_className,targetDir);
            generateService(conf,up_className,low_className,targetDir);
            generateServiceImpl(conf,up_className,low_className,targetDir);
            generateController(conf,up_className,low_className,targetDir);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("生成完毕");
    }

    public static void generateXml(Configuration configuration, List<FieldModel> field_list,String key,
                                   String up_className,String low_className,String tableName,
                                   String targetDir) throws Exception{
        //获取模版
        Template template = configuration.getTemplate("sqlMapper.html");

        //准备数据
        HashMap<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("fields",field_list);
        dataMap.put("tableName",tableName);
        dataMap.put("up_className",up_className);
        dataMap.put("low_className",low_className);

        dataMap.put("key",key);
        dataMap.put("keyModel","#{"+key+"}");

        dataMap.put("startRow","#{startRow}");
        dataMap.put("pageSize","#{pageSize}");

        // 封装固定显示的数据
        Iterator<FieldModel> iterator = field_list.iterator();
        while (iterator.hasNext()){
            FieldModel next = iterator.next();
            String columnName = next.getColumnName();
            dataMap.put(columnName,"#{"+columnName+"}");
        }

        File targetFile = new File(targetDir + up_className + "Mapper.xml");
        //准备输出流
        FileWriter fileWriter = new FileWriter(targetFile);

        //输出
        template.process(dataMap,fileWriter);
        //关闭流
        fileWriter.close();
    }

    public static void generateQuery(Configuration configuration, List<FieldModel> field_list,
                                     String up_className,String low_className, String targetDir
                                     ) throws Exception{
        // 获取模版
        Template template = configuration.getTemplate("Query.html");

        //准备数据
        HashMap<String, Object> dataMap = new HashMap<String, Object>();

        dataMap.put("fields",field_list);
        dataMap.put("up_className",up_className);
        dataMap.put("low_className",low_className);

        File targetFile = new File(targetDir + up_className + "Query.java");
        //准备输出流
        FileWriter fileWriter = new FileWriter(targetFile);

        //输出
        template.process(dataMap,fileWriter);
        //关闭流
        fileWriter.close();
    }

    public static void generateDao(Configuration configuration,
                                   String up_className,String low_className, String targetDir) throws Exception{
        // 获取模版
        Template template = configuration.getTemplate("Dao.html");
        //准备数据
        HashMap<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("up_className",up_className);
        dataMap.put("low_className",low_className);

        File targetFile = new File(targetDir + up_className + "Dao.java");
        //准备输出流
        FileWriter fileWriter = new FileWriter(targetFile);

        //输出
        template.process(dataMap,fileWriter);
        //关闭流
        fileWriter.close();
    }

    public static void generateService(Configuration configuration,
                                       String up_className,String low_className, String targetDir) throws Exception{
        // 获取模版
        Template template = configuration.getTemplate("Service.html");
        //准备数据
        HashMap<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("up_className",up_className);
        dataMap.put("low_className",low_className);

        File targetFile = new File(targetDir + up_className + "Service.java");
        //准备输出流
        FileWriter fileWriter = new FileWriter(targetFile);

        //输出
        template.process(dataMap,fileWriter);
        //关闭流
        fileWriter.close();
    }

    public static void generateServiceImpl(Configuration configuration,
                                       String up_className,String low_className, String targetDir) throws Exception{
        // 获取模版
        Template template = configuration.getTemplate("ServiceImpl.html");
        //准备数据
        HashMap<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("up_className",up_className);
        dataMap.put("low_className",low_className);

        File targetFile = new File(targetDir + up_className + "ServiceImpl.java");
        //准备输出流
        FileWriter fileWriter = new FileWriter(targetFile);

        //输出
        template.process(dataMap,fileWriter);
        //关闭流
        fileWriter.close();
    }

    public static void generateController(Configuration configuration,String up_className,
                                          String low_className, String targetDir) throws Exception{
        // 获取模版
        Template template = configuration.getTemplate("Controller.html");
        //准备数据
        HashMap<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("up_className",up_className);
        dataMap.put("low_className",low_className);

        File targetFile = new File(targetDir + up_className + "Controller.java");
        //准备输出流
        FileWriter fileWriter = new FileWriter(targetFile);

        //输出
        template.process(dataMap,fileWriter);
        //关闭流
        fileWriter.close();
    }

    public static void generateModel(Configuration configuration, List<FieldModel> field_list,
                                     String up_className,String low_className, String targetDir) throws Exception{
        // 获取模版
        Template template = configuration.getTemplate("Model.html");

        //准备数据
        HashMap<String, Object> dataMap = new HashMap<String, Object>();

        dataMap.put("fields",field_list);
        dataMap.put("up_className",up_className);
        dataMap.put("low_className",low_className);

        File targetFile = new File(targetDir + up_className + ".java");
        //准备输出流
        FileWriter fileWriter = new FileWriter(targetFile);

        //输出
        template.process(dataMap,fileWriter);
        //关闭流
        fileWriter.close();
    }

    public static void generateModelVo(Configuration configuration, String up_className,String low_className,
                                       String targetDir) throws Exception{
        // 获取模版
        Template template = configuration.getTemplate("ModelVo.html");

        //准备数据
        HashMap<String, Object> dataMap = new HashMap<String, Object>();

        dataMap.put("up_className",up_className);
        dataMap.put("low_className",low_className);

        File targetFile = new File(targetDir + up_className + "Vo.java");
        //准备输出流
        FileWriter fileWriter = new FileWriter(targetFile);

        //输出
        template.process(dataMap,fileWriter);
        //关闭流
        fileWriter.close();
    }

}
