package com.chuqui.demoboot.rest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/prin/s")
	public String getIndexPage(){
		return "UserManagement";
	}
}
