package cn.itsource.ssm.web.controller;

import cn.itsource.ssm.domain.Employee;
import cn.itsource.ssm.service.IEmpolyeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmpolyeeService empolyeeService;

    @RequestMapping("/index")
    public String index(){
        return "/index";
    }
    @RequestMapping("/add")
    @ResponseBody
    public void add(Employee employee){
        empolyeeService.add(employee);
    }

    @RequestMapping("/findOne")
    @ResponseBody
    public Employee findOne(Long id){
        return empolyeeService.findOne(id);
    }
}
