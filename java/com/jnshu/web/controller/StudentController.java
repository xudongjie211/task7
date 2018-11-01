package com.jnshu.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jnshu.pojo.Student;
import com.jnshu.service.CourseInterface;
import com.jnshu.service.StudentInterface;
import com.jnshu.service.UserInterface;

@Controller
public class StudentController {
	@Autowired
	private StudentInterface si;
	@Autowired
	private CourseInterface ci;
	@Autowired
	private UserInterface ui;	
	
	@RequestMapping(value="/homepage")
	public String student(Model model){
	//	int i=1/0;
		List<Student> list=si.select();
		model.addAttribute("list", list);
		int num=si.count();
		model.addAttribute("num", num);
		System.out.println(num);
		return "homepage";
	}
	@RequestMapping(value="/recommend")
	public String recommend(Model model){
		return "recommend";
	}
	
	
	
	
	
	
}
