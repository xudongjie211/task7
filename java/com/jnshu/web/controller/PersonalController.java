package com.jnshu.web.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.jnshu.exception.MessageException;
import com.jnshu.pojo.Student;
import com.jnshu.service.CourseInterface;
import com.jnshu.service.StudentInterface;
import com.jnshu.service.UserInterface;
import com.jnshu.util.CookieUtil;
import com.jnshu.util.TokenUtil;
import com.jnshu.util.alioos.AlioosUtil;

@Controller
@RequestMapping("/u")
public class PersonalController {
	@Autowired
	private StudentInterface si;
	@Autowired
	private CourseInterface ci;
	@Autowired
	private UserInterface ui;	
	@Autowired
	private AlioosUtil au;
	
	@RequestMapping(value="/personalpage")
	public String personpage(Model model,HttpServletRequest request) throws Exception {
		long uid;
		try {
			uid = TokenUtil.getID(CookieUtil.getCookieValue(request, "token"));
		} catch (UnsupportedEncodingException e) {
			throw new MessageException("cookie工具类查找value异常");
		}
		Student stu=si.selectOne(uid);		
		model.addAttribute("stu", stu);		
		return "personalpage";
	}
	
	
	
	
	
	
	
	@RequestMapping(value="/imagehandle", method=RequestMethod.POST)
	public String uploadpicture(HttpServletRequest request,MultipartFile file) throws Exception{
		long uid;
		try {
			uid = TokenUtil.getID(CookieUtil.getCookieValue(request, "token"));
		} catch (UnsupportedEncodingException e) {
			throw new MessageException("cookie工具类查找value异常");
		}
		Student stu=si.selectOne(uid);	
		String url;
		try {
			url = au.springuploadFile(stu.name, file);
		} catch (Exception e) {
			throw new MessageException("阿里云对象存储图片上传报错");
		}
		long time=System.currentTimeMillis();
		stu.setImage(url);
		stu.setUpdate_at(time);
		si.update(stu);
		return "redirect:/homepage";
	}
	
	
	
	
}
