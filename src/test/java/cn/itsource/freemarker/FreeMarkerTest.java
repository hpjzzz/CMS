package cn.itsource.freemarker;


import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class FreeMarkerTest {

    @Autowired
    private DataSource ds;

    @Test
    public void testCreateHtml() throws Exception{
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        //设置读取模板的文件夹路径
        File f = new File("F:\\java res\\myssm\\src\\main\\resources");
        cfg.setDirectoryForTemplateLoading(f);
        
        //设置编码
        cfg.setDefaultEncoding("UTF-8");
        
        //获取模板对象
        Template template = cfg.getTemplate("hello.ftl");
        
        //准备数据
        Address address = new Address();
        address.setHref("https://www.baidu.com");
        address.setTagName("91影像");

        User user = new User();
        user.setAddress(address);
        user.setName("王老师");
        
        //生成页面
        PrintWriter pw = new PrintWriter(new File(f, "hello.html"),"UTF-8");
        template.process(user,pw);
        pw.close();
    }
    //用map新建一个java类
    @Test
    public void testCreateHtml2() throws Exception{
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        //设置读取模板的文件夹路径
        File f = new File("F:\\java res\\myssm\\src\\main\\resources");
        cfg.setDirectoryForTemplateLoading(f);

        //设置编码
        cfg.setDefaultEncoding("UTF-8");

        //获取模板对象
        Template template = cfg.getTemplate("java.ftl");

        //准备数据
        HashMap<String, Object> field = new HashMap<>();
        field.put("name", "id");
        field.put("type", "Integer");
        field.put("getName", "getId");
        field.put("setName", "setId");

        HashMap<String, Object> clz = new HashMap<>();
        clz.put("className", "Address");
        clz.put("id", field);


        //生成页面
        String fileName = "Address.java";
        PrintWriter pw = new PrintWriter(new File(f, fileName),"UTF-8");
        template.process(clz,pw);
        pw.close();
    }


    @Test
    public void testCreateHtml3() throws Exception{
        //生成静态页面
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        //设置读取模板的文件夹路径
        File f = new File("F:\\java res\\myssm\\src\\main\\resources");
        cfg.setDirectoryForTemplateLoading(f);

        //设置编码
        cfg.setDefaultEncoding("UTF-8");

        //获取模板对象
        Template template = cfg.getTemplate("java2.ftl");

        //准备数据
        Connection coon = ds.getConnection();
        String sql = "select * from job";
        //预编译对象
        PreparedStatement pst = coon.prepareStatement(sql);
        //执行SQL语句
        ResultSet rs = pst.executeQuery();
        //获取元数据
        ResultSetMetaData rsmd = rs.getMetaData();
        int count = rsmd.getColumnCount();
        /**
         * 遍历元数据并封装属性
         *
         */
        HashMap<String, Object> clz = new HashMap<>();
        for (int i = 1; i<= count; i++){
            //存放字段信息
            HashMap<String, Object> field = new HashMap<>();
            //获取字段名
            String name = rsmd.getColumnLabel(i);
            //生成get/set名字
            String getName = "get"+name.substring(0,1).toUpperCase()+name.substring(1);
            String setName = "set"+name.substring(0,1).toUpperCase()+name.substring(1);
            //获取类型
            String type = rsmd.getColumnClassName(i);

            field.put("name", name);
            field.put("type", type);
            field.put("getName", getName);
            field.put("setName", setName);

            clz.put(name, field);
        }

        //第三个map封装所有字段
        HashMap<String, Object> table = new HashMap<>();
        table.put("className", "Address");
        table.put("table", clz);


        //生成页面
        String fileName = "Address.java";
        PrintWriter pw = new PrintWriter(new File(f, fileName),"UTF-8");
        template.process(table,pw);
        pw.close();
    }
}
