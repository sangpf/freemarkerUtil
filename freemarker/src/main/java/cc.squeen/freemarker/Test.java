package cc.squeen.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws Exception{

        String tableName = "t_user";
        String className = "User";
        String packageName = "cc.squeen.model";

        Configuration conf = new Configuration();
        String dir = "D:\\JAVA\\IDEA_space\\Test\\freemarker\\src\\main\\webapp\\WEB-INF\\ftl\\";

        //设置模板所在目录
        conf.setDirectoryForTemplateLoading(new File(dir));
        //获取模板
        Template template = conf.getTemplate("Model.java");

        //准备数据
        HashMap<String, Object> dataMap = new HashMap<String, Object>();

        List<FieldModel> t_user = TestDemo.getFieldModel_list(tableName);

        dataMap.put("fields",t_user);
        dataMap.put("className",className);
        dataMap.put("packageName",packageName);

        String targetDir = "D:\\JAVA\\IDEA_space\\Test\\freemarker\\src\\main\\java\\cc\\squeen\\model\\";
        File targetFile = new File(targetDir + className + ".java");
        //准备输出流
        FileWriter fileWriter = new FileWriter(targetFile);

        //生成开始
        template.process(dataMap,fileWriter);
        System.out.println("生成完毕");

        //关闭流
        fileWriter.close();
    }


}
