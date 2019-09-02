package cn.itsource.ssm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/show")
public class ShowController {

	@RequestMapping("/{method}")
	public String jump(@PathVariable("method")String method){

		return "forward:/"+method+".jsp";
	}
}
