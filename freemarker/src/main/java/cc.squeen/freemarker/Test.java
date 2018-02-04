package cc.squeen.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) throws Exception{
        Configuration conf = new Configuration();

        String dir = "D:\\JavaTools\\idea_space\\Test\\freemarker\\src\\main\\webapp\\WEB-INF\\ftl\\";

//        设置模板所在目录
        conf.setDirectoryForTemplateLoading(new File(dir));
//        获取模板
        Template template = conf.getTemplate("treemarker_test.html");

        //准备数据
        HashMap<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("world","你好，世界");

        //准备输出流
        FileWriter writer = new FileWriter(new File(dir + "hello.html"));

//        生成开始
        template.process(dataMap,writer);
        System.out.println("生成完毕");

        //关闭流
        writer.close();
    }
}
