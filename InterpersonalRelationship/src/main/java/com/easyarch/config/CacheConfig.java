package com.example.javaanli.demo.config;

import org.springframework.cache.interceptor.KeyGenerator;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import java.lang.reflect.Method;
import java.net.UnknownHostException;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {

        return new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost", 6379));
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        return RedisCacheManager.create(redisConnectionFactory);
    }
    /**
     * 配置key的生成策略
     * 下边的xxx就是你使用 @Cacheable注解内的key = "#xxx"中的xxx
     * @return
     */
//    @Bean(name = "xxxGenerator")
//    public KeyGenerator xxxGenerator() {
//        return new KeyGenerator() {
//            @Override
//            public Object generate(Object target, Method method, Object... params) {
//                StringBuilder sb = new StringBuilder();
//                sb.append(params[0].toString());
//                return sb.toString();
//            }
//        };
//    }

//    需要用redis存特定的对象的时候可以这么做
//    @Bean
//    public RedisTemplate<Object, Employee> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
//        RedisTemplate<Object, Employee> template = new RedisTemplate();
//        template.setConnectionFactory(redisConnectionFactory);
//        /**
//         * 下面两句就是自己制定序列化
//         */
//        Jackson2JsonRedisSerializer<Employee> employeeJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
//        template.setDefaultSerializer(employeeJackson2JsonRedisSerializer);
//        return template;
//    }

}
