package com.chc.redis.redistest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.RedisClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.TimeUnit;

@Controller
@Slf4j
public class RedisController {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 缓存测试
     *
     * @return
     * @author  SHANHY
     * @create  2016年9月12日
     */
    @RequestMapping("/redisTest")
    public String redisTest() {
        try {
            redisTemplate.opsForValue().set("test-key", "redis测试内容", 2, TimeUnit.SECONDS);// 缓存有效期2秒

            log.info("从Redis中读取数据：" + redisTemplate.opsForValue().get("test-key").toString());

            TimeUnit.SECONDS.sleep(3);

            log.info("等待3秒后尝试读取过期的数据：" + redisTemplate.opsForValue().get("test-key"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "OK";
    }


    @Autowired
    private RedisClient redisClient;

    @Autowired
    private TestService testService;

    @GetMapping("/redisCache")
    public String redisCache() {
        redisClient.set("shanhy", "hello,shanhy", 100);
        log.info("getRedisValue = {}", redisClient.get("shanhy"));
        testService.testCache2("aaa", "bbb");
        return testService.testCache();
    }
}
