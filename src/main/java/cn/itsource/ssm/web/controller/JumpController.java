package cn.itsource.ssm.web.controller;

import cn.itsource.ssm.domain.Picture;
import cn.itsource.ssm.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/jump")
public class JumpController {

    @RequestMapping("/{method}")
    public String test2(@PathVariable("method")String method){

        return method;
    }

}
