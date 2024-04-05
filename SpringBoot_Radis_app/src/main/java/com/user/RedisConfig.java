package com.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig 
{
	@Bean
	JedisConnectionFactory jedisConnectionFactory()
	{
		JedisConnectionFactory jcf = new  JedisConnectionFactory();
//		jcf.setHostName("");
//		jcf.setPassword("");
//		jcf.setPort("");
		return jcf;
	}
	
	@Bean
	RedisTemplate<String, User> radiRedisTemplate()
	{
		RedisTemplate<String, User> redisTemplate=new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
		
	}

}
