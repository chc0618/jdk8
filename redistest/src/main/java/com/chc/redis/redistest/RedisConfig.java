package com.chc.redis.redistest;

import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.RedisClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Value("${spring.redis.host}")
    private String redisHost = "127.0.0.1";

//    @Value("${spring.redis.port}")
    private int redisPort = 6379;

//    @Value("${redis.task.pass}")
    private String redisPass ="";

    @Bean(name = "factory")
    public JedisConnectionFactory getJedisFactory(){
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setPort(redisPort);
        connectionFactory.setHostName(redisHost);
//        connectionFactory.setPassword(redisPass);
        return connectionFactory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        template.setValueSerializer(new RedisObjectSerializer());
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public RedisClient redisClient(JedisConnectionFactory factory){
        return new RedisClient(factory);
    }
}
