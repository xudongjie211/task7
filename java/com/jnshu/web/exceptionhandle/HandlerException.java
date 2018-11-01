package com.jnshu.web.exceptionhandle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.jnshu.exception.MessageException;
import com.jnshu.logTest.Slf4jTest;



@Component
public class HandlerException implements HandlerExceptionResolver {
	Logger log = LoggerFactory.getLogger(Slf4jTest.class);
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception e) {
		ModelAndView mac=new ModelAndView();
		
		if(e instanceof MessageException){
			MessageException me=(MessageException)e;
			mac.addObject("error", me.getMessage());
			log.error("预期异常"+me.getMessage());
		}else{	
			log.info("未知异常"+obj);
			mac.addObject("error", "未知错误类型"+obj);				
		}
			mac.setViewName("error");
			return mac;
	}

}
