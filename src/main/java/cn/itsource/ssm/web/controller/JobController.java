package cn.itsource.ssm.web.controller;

import cn.itsource.ssm.domain.Condition;
import cn.itsource.ssm.zzz.Job;
import cn.itsource.ssm.domain.PageList;
import cn.itsource.ssm.service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/job")
public class JobController {

    @Autowired
    private IJobService jobService;

    @RequestMapping("/add")
    public String add(Job job, HttpServletRequest req){
        ServletContext context = req.getServletContext();
        //模板路径
        String template = context.getRealPath("WEB-INF/template");
        //静态页面生成路径
        String output = context.getRealPath("/temp");
        Condition con = new Condition();
        con.setTemplate(template);
        con.setOutput(output);
        System.out.println(template+"\n"+output);
        //添加数据
        jobService.add(job,con);
        return "redirect:/jump/jobs";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Job> findAll(){
        return jobService.findAll();
    }

    @RequestMapping("/findOne")
    @ResponseBody
    public Job findOne(Long id){
        return jobService.findOne(id);
    }

    @RequestMapping("/page")
    @ResponseBody
    public PageList<Job> page(Condition con){
        System.out.println(con);
        return jobService.findByQuery(con);
    }

    @RequestMapping("/del")
    public String del(Long id, String htmlurl, HttpServletRequest req){
        ServletContext context = req.getServletContext();
        String realPath = context.getRealPath(htmlurl);
        System.out.println(realPath);
//        jobService.delete(id,realPath);
        return "redirect:/jump/jobs";
    }

    @RequestMapping("/update")
    public String update(Job job, HttpServletRequest req){
        ServletContext context = req.getServletContext();
        //模板路径
        String template = context.getRealPath("WEB-INF/template");
        //静态页面生成路径
        String output = context.getRealPath("/temp");
        Condition con = new Condition();
        con.setTemplate(template);
        con.setOutput(output);
        System.out.println(template+"\n"+output);
        jobService.update(job,con);
        return "redirect:/jump/jobs";
    }

}
