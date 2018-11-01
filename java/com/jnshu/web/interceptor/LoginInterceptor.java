package com.jnshu.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jnshu.pojo.User;
import com.jnshu.service.CourseInterface;
import com.jnshu.service.StudentInterface;
import com.jnshu.service.UserInterface;
import com.jnshu.util.CookieUtil;
import com.jnshu.util.TokenUtil;

public class LoginInterceptor implements HandlerInterceptor {
	@Autowired
	private StudentInterface si;
	@Autowired
	private CourseInterface ci;
	@Autowired
	private UserInterface ui;
	


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
	String tk= CookieUtil.getCookieValue(request, "token");
	if(tk!=null){
	 	long id =TokenUtil.getID(tk);
	 	long time=TokenUtil.getLogntime(tk);
	 	User u=new User();
	 	u.setUid(id);
		 User user=ui.findUser(u);
		if(user.longtime==time){
			System.out.println("拦截器通过了========================================");
			return true;
			
			
		}else{
			System.out.println("拦截器出错了-------------------------------------");
			
			return false;
		}
	}else{
		String path=request.getContextPath();
		request.getRequestDispatcher("/error.jsp").forward(request, response);
		//response.sendRedirect("../index.jsp");
		System.out.println("拦截器没有cookie值了-------------------------------------");
		return false;
	}

		
	}
	
	
	
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		String path=request.getContextPath();
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

}
