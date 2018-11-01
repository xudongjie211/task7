package com.jnshu.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jnshu.pojo.Course;
import com.jnshu.pojo.Student;
import com.jnshu.service.CourseInterface;
import com.jnshu.service.StudentInterface;
import com.jnshu.service.UserInterface;
@Controller
//@RequestMapping(value="/u")
public class CourseController {
		@Autowired
		private StudentInterface si;
		@Autowired
		private CourseInterface ci;
		@Autowired
		private UserInterface ui;	
		
		@RequestMapping(value="/coursepage")
		public String course(Model model){
			List<Course> course=ci.select();
			model.addAttribute("courses", course);
			//System.out.println("cousrsssssss");
			return "coursepage";
		}
		
		


	
	
}
