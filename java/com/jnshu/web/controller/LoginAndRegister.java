package com.jnshu.web.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyuncs.exceptions.ClientException;
import com.jnshu.exception.MessageException;
import com.jnshu.logTest.Slf4jTest;
import com.jnshu.pojo.Email;
import com.jnshu.pojo.Phone;
import com.jnshu.pojo.Student;
import com.jnshu.pojo.User;
import com.jnshu.service.CourseInterface;
import com.jnshu.service.StudentInterface;
import com.jnshu.service.UserInterface;
import com.jnshu.util.*;
import com.jnshu.util.alismsUtil.AliSmsUtil;
import com.jnshu.util.emailUtil.EmailSpring;
@Controller
public class LoginAndRegister {
	@Autowired
	private StudentInterface si;
	@Autowired
	private CourseInterface ci;
	@Autowired
	private UserInterface ui;	
	@Autowired
	private EmailSpring es;	
	@Autowired
	private AliSmsUtil as;
	
	
	private Logger logger = LoggerFactory.getLogger(LoginAndRegister.class);
	
//	@RequestMapping(value="/register",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
//	@ResponseBody
//	public String studentregister(String name,String phone,String password,String email,String emailverify,Model model,HttpServletRequest request){
//		if(name!=""&&password!=""&&email!=""&&emailverify!=""){
//		Student stu=new Student();
//		stu.setName(name);
//		stu.setPhone(phone);
//		stu.setEmail(email);
//		stu.setPassword(password);
//		String emailnum=(String)request.getSession().getAttribute("emailnum");
//		//电话的正则判断
//		if(RegexUtil.checkCellphone(phone)&&emailnum.equals(emailverify)){//
//			if(si.findByname(name)!=null){
//				return "名字已占用";
//			}else{
//				long time=System.currentTimeMillis();
//				stu.setCreate_at(time);
//				stu.setPassword(PasswordUtil.generate(stu.password));
//				si.add(stu);
//				
//			return "注册成功";
//			}
//		}else{
//			return "电话号码不符合规范或验证码错误";
//			
//		}
//		}else{
//			return "信息请填完整";
//		}
//		
//	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String studentregister(HttpServletRequest request,String code){
		Student stu=si.findByCode(code);
		if(stu!=null){
			stu.setCode(null);
			stu.setStatus("1");
			si.update(stu);
			return "success";
		}
		
		return "error";
	}
	
	
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String student(Student st, Model model, HttpServletResponse response, HttpServletRequest request,
			String verifynum) throws Exception{
		logger.info("到达login业务类{}");
		System.out.println(request.getSession().getAttribute("phonenum"));
		System.out.println(verifynum);
		if (request.getSession().getAttribute("phonenum").equals(verifynum)) {

			Student stu = si.findByname(st.name);
			System.out.println(stu.password);
			System.out.println(PasswordUtil.verify(st.password, stu.password));
			if (stu != null&&(stu.status).equals("1")) {
				if (PasswordUtil.verify(st.password, stu.password)) {
					long time = System.currentTimeMillis();
					User u = new User();
					u.setUid(stu.id);
					u.setLongtime(time);
					User use = ui.findUser(u);

					if (use != null) {

						String tk;
						try {
							tk = TokenUtil.createToken(stu.id, time);
						} catch (Exception e) {
							throw new MessageException("创建token令牌异常");
						}
						CookieUtil.addCookie(response, "token", tk);
						ui.update(u);
						model.addAttribute("list", si.select());
						return "homepage";
					} else {
						String tk;
						try {
							tk = TokenUtil.createToken(stu.id, time);
						} catch (Exception e) {
							throw new MessageException("创建token令牌异常");
						}
						CookieUtil.addCookie(response, "token", tk);
						ui.add(u);
						model.addAttribute("list", si.select());
						return "homepage";

					}
				} else {
					return "logindefault";

				}
			} else {
				return "logindefault";

			}
		} else {

			return "logindefault";
		}

	}
	
//	@RequestMapping(value="/sendEmail",method=RequestMethod.POST)
//	public void sendEmail(HttpServletRequest request,@RequestBody Email email1) throws Exception{
//		String email=email1.email;
//		if(RegexUtil.checkEmail(email)){
//			String verifynum=VerifyNumUtil.getRondomStr(6);
//			request.getSession().setAttribute("emailnum",verifynum);
//			try {
//				es.send_common(email, "邮箱注册验证码", "你的验证码是:"+verifynum);
//				logger.debug("邮箱发送成功"+request.getSession().getAttribute("emailnum"));
//				
//			} catch (IOException e) {
//				throw new MessageException("邮箱验证码发送异常");
//			}
//		}else{
//			throw new MessageException("邮箱不符合正则规范");			
//		}
//		
//	}
	@RequestMapping(value="/sendEmail",method=RequestMethod.POST)
	public void sendEmail(HttpServletRequest request,@RequestBody Email email1) throws Exception{
		String email=email1.email;
		long id=email1.sid;
		if(RegexUtil.checkEmail(email)){
			Student stu=si.selectOne(id);
			stu.setEmail(email);
			si.update(stu);
			String code=stu.code;
			try {
				es.send_common(email, "邮箱激活",code);
				logger.debug("邮箱发送成功"+request.getSession().getAttribute("emailnum"));
				
			} catch (Exception e) {
				throw new MessageException("邮箱验证码发送异常");
			}
		}else{
			throw new MessageException("邮箱不符合正则规范");			
		}
		
	}
	
	
	
	
	
	@RequestMapping(value = "/sendPhone", method = RequestMethod.POST)
	public void sendPhone(HttpServletRequest request,@RequestBody Phone phone1) throws Exception {
		String phonenum=phone1.phonenum;
		System.out.println(phonenum);
		if (si.findByphone(phonenum)!=null) {
			String verifynum = VerifyNumUtil.getRondomStr(6);
			request.getSession().setAttribute("phonenum", verifynum);
			System.out.println(verifynum);
			try {
				as.sendMessage(phonenum, verifynum);
				logger.debug("短信发送成功" + request.getSession().getAttribute("phonenum"));

			} catch (Exception e) {
				throw new MessageException("短信验证码发送异常");	
			}
		} else {
			throw new MessageException("手机号不存在");

		}

	}
	@RequestMapping(value="/namehandle",method=RequestMethod.PUT)
	public @ResponseBody Student changename(@RequestBody Student stu,HttpServletRequest request) throws Exception{
		String myname=stu.name;
		long uid;
		try {
			uid = TokenUtil.getID(CookieUtil.getCookieValue(request, "token"));
		} catch (UnsupportedEncodingException e) {
			throw new MessageException("cookie工具类查找value异常");
		}
		Student stu1=si.selectOne(uid);
		stu1.setName(myname);
		si.update(stu1);
		return stu1;
	}
	
	@RequestMapping(value="/phonehandle",method=RequestMethod.PUT)
	public @ResponseBody Student changephone(@RequestBody Student stu,HttpServletRequest request) throws Exception {
		String myphone=stu.phone;
		long uid;
		try {
			uid = TokenUtil.getID(CookieUtil.getCookieValue(request, "token"));
		} catch (UnsupportedEncodingException e) {
			throw new MessageException("cookie工具类查找value异常");
		}
		Student stu1=si.selectOne(uid);
		stu1.setPhone(myphone);;
		si.update(stu1);
		return stu1;
	}
	@RequestMapping(value="/emailhandle",method=RequestMethod.PUT)
	public @ResponseBody Student changeemail(@RequestBody Student stu,HttpServletRequest request) throws Exception{
		String myemail=stu.email;
		long uid;
		try {
			uid = TokenUtil.getID(CookieUtil.getCookieValue(request, "token"));
		} catch (UnsupportedEncodingException e) {
			throw new MessageException("cookie工具类查找value异常");
		}
		Student stu1=si.selectOne(uid);
		stu1.setEmail(myemail);;
		si.update(stu1);
		return stu1;
	}
	
	@RequestMapping(value="/imagedelete",method=RequestMethod.DELETE)
	public void deleteimage(@RequestBody Student stu,HttpServletRequest request){
		long myid=stu.id;	
		Student stu1=si.selectOne(myid);
		stu1.setImage("");
		si.updateImage(stu1);

	}
	
	
	@RequestMapping(value="/registersure",method=RequestMethod.POST)
	public String studentregistersure(Model model,HttpServletRequest request,Student stu){
		
		if(RegexUtil.checkCellphone(stu.phone)){//
			Student s=new Student();
			s.setName(stu.name);
			s.setPhone(stu.phone);
					
			if(si.findByname(s.name)!=null){
				return "error";
			}else{
				long time=System.currentTimeMillis();
				s.setCreate_at(time);
				s.setPassword(PasswordUtil.generate(stu.password));
				String code=UUidUtil.getuuit();
				s.setCode(code);
				s.setStatus("0");
				long id=si.add(s);
				model.addAttribute("stunum", id);
			return "registersure";
			}
		}else{
			return "error";
			
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
