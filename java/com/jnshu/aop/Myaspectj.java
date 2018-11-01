package com.jnshu.aop;



import org.aspectj.lang.ProceedingJoinPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





public class Myaspectj {
	private static Logger lg = LoggerFactory.getLogger(Myaspectj.class);
	//private static final long ONE_MINUTE=6;
	public void before(){
		
		System.out.println("前置通知=========================");
	}

	public Object timearound(ProceedingJoinPoint joinPoint) {
		long startTime = System.currentTimeMillis();
		// 定义返回对象、得到方法需要的参数
		Object resultData = null;
		//Object[] args = joinPoint.getArgs();
		//Object apiName = args[0];
		try {
			// 调用钉钉接口
			//lg.info("======>请求[xxx]接口开始,参数:{}", args);
			resultData = joinPoint.proceed();
			long endTime = System.currentTimeMillis();
			lg.info("======>请求[xxx]接口完成,耗时:{},返回:{}", (endTime - startTime), resultData);
		} catch (Throwable e) {
			// 记录异常信息
			long endTime = System.currentTimeMillis();
			lg.error("======>请求[xxx]接口异常！耗时:{}", (endTime - startTime));
		}
		return resultData;


	}
	
	
	
	
	
	
	
}
