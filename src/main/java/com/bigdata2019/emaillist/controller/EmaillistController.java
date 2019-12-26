package com.bigdata2019.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigdata2019.emaillist.repository.EmaillistRepository;
import com.bigdata2019.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {
	
	@Autowired
	private EmaillistRepository emaillistRepository;
	
	@RequestMapping({"", "/index", "/list"})
	public String index(Model model) {
		
		List<EmaillistVo> list = emaillistRepository.findAll();

		model.addAttribute("list", list);
		return "WEB-INF/views/index.jsp";
	}
	
	@RequestMapping("/form")
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}
	
	
	@RequestMapping("/add")
	public String add(EmaillistVo vo) {
		emaillistRepository.insert(vo);
		return "redirect:/";
	}

}
