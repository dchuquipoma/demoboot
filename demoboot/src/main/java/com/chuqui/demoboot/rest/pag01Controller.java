package com.chuqui.demoboot.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class pag01Controller {
	@RequestMapping("/menu")
	public String getIndexPage(){
		return "menu";
	}
}
