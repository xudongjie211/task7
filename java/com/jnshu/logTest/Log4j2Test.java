package com.jnshu.logTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Test {
	 static  Logger lg=LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		lg.debug("这是debug");
	}

}
