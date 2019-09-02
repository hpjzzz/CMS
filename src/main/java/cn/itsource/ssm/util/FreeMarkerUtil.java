package cn.itsource.ssm.util;

import cn.itsource.ssm.domain.Condition;
import cn.itsource.ssm.zzz.Job;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FreeMarkerUtil {
	public static void creatHtml(Job job, Condition con, String fileName) throws IOException, TemplateException {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
		//设置读取模板的文件夹路径
		File f = new File(con.getTemplate());
		cfg.setDirectoryForTemplateLoading(f);

		//设置编码
		cfg.setDefaultEncoding("UTF-8");

		//获取模板对象
		Template template = cfg.getTemplate("details.ftl");

		//生成页面
		PrintWriter pw = new PrintWriter(new File(con.getOutput(), fileName),"UTF-8");
		template.process(job,pw);
		pw.close();
	}
}
