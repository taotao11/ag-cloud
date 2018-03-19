package com.jpa.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * redis : 
 ---------------------
 1/RedisFactory : redis工厂. --- 通过application.properties配置文件，spring boot会自动创建，我们引入使用即可。
 2/RedisTempalte: redis操作类.
 3/ReidisManager:redis的管理类.
 
 * 
 * @author Angel -- 守护天使
 * @version v.0.1
 * @date 2017年9月21日
 */
@Configuration//这是配置类.
@EnableCaching //开启缓存.
public class RedisCacheConfig {
	
	@Bean
	public RedisTemplate<String,String> redisTempalte(RedisConnectionFactory redisConnectionFactory){
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		return redisTemplate;
	}
	
	/**
	 * 将我们定义的redis 的 redisTempalte(缓存操作类)，设置到spring cahcheManager对象中，
	 * 这样的话，spring 就可以使用cacaheManager对我们的对象进行缓存控制。
	 * @param redisTempalte
	 * @return
	 */
	@Bean
	public CacheManager cacheManager(RedisTemplate redisTempalte){
		CacheManager cacheManager = new RedisCacheManager(redisTempalte);
		return cacheManager;
	}
	
}
