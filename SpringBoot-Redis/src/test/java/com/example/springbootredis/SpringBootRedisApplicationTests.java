package com.example.springbootredis;

import com.example.springbootredis.pojo.User;
import com.example.springbootredis.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringBootRedisApplicationTests {

   @Autowired
   @Qualifier("redisTemplate")
   private RedisTemplate redisTemplate;

   @Autowired
   private RedisUtil redisUtil;

   @Test
   void contextLoads() {
      User user = new User("niao", 19);
      redisTemplate.opsForValue().set("user", user);
      System.out.println(redisTemplate.opsForValue().get("user"));
   }

   @Test
   public void testUtils() {
      redisUtil.set("name","niaotendo");
      System.out.println(redisUtil.get("name"));
   }
}
