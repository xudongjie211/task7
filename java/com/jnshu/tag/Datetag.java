package com.jnshu.tag;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class Datetag extends TagSupport {
	
	private static final long serialVersionUID =1L;
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int doStartTag() throws JspException {
		String vv = "" + name;
        try {
            long time = Long.valueOf(vv.trim());
            Calendar c = Calendar.getInstance();//默认时区获得日历
            c.setTimeInMillis(time);//通过long值设定当前时间
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy年MM月dd日HH点mm分ss秒");
            String s = dateformat.format(c.getTime());//返回date对象并格式化输出
            pageContext.getOut().write(s);//当前页面上直接输出
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.doStartTag();
		
	}

}
