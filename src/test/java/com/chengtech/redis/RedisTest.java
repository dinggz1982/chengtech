package com.chengtech.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

	@Autowired
	private RedisTemplate<String, Object> redis;
	
	@Test
	public void test(){
		//redis.opsForValue().set("111", "1111");
		System.out.println(redis.opsForValue().get("111"));
	}

}
