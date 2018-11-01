package com.jnshu.redisstudent;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;




@Repository
public class RedisStudent {
	@Resource(name="redisTemplate")
	private RedisTemplate rt;
	
	//指定缓存失效时间
	public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                rt.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
	
	//获取失效时间
	public long getExpire(String key) {
        return rt.getExpire(key, TimeUnit.SECONDS);
}
	
	
	
	//判断是否存在
	public boolean haskey(Object key){			
		try {
			return rt.hasKey(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public void deletekey(Object key){
		
		rt.delete(key);
		
	}
	
	public boolean hsetredis(String key,String field ,Object obj){//第一个是key，后面的是field属性名称和值，可以保持第一个加入值不变
		
		
		try {
			rt.opsForHash().put(key,field, obj);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
		
		
		//直接放map的集合类
		//Map<String,Object> testMap = new HashMap();
        //testMap.put("name","jack");
        //testMap.put("age",27);
        //testMap.put("class","1");
        //template.opsForHash().putAll("redisHash1",testMap);
	
	}
	public boolean hsettimeredis(String key, String item, Object value, long time) {
        try {
            rt.opsForHash().put(key, item, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
	
	
	
	
	public boolean addstringredis(String key,Object value){
		try {
			if(key!=null&&value!=null){
			rt.opsForValue().set(key, value);
			return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Object getstringredis(String key){
		if(key!=null){
			return rt.opsForValue().get(key);
			
		}else{
			return false;
		}
	}
	
	
	public void addhashredis(){
		
		
	}
	
	
	
	
	
	
}
