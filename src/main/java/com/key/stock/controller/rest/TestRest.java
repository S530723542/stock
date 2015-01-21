package com.key.stock.controller.rest;

import org.springframework.stereotype.Controller;

@Controller
public class TestRest
{
	 
	@ResponseBody
	@RequestMapping("/ajax") 
	public Object ajax(HttpServletRequest request)
	{
		
	}
}
