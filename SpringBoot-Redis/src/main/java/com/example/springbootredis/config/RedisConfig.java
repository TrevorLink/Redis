package com.example.springbootredis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author HuangSir
 * @date 2021-11-26 11:45
 */
@Configuration
public class RedisConfig {
   @Bean
   //我们自己注册的RedisTemplate为了业务方便一般都是<String,Object>类型
   public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
      RedisTemplate<String, Object> template = new RedisTemplate<>();
      template.setConnectionFactory(redisConnectionFactory);
      //Jackson序列化配置
      Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);
      ObjectMapper om = new ObjectMapper();
      om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
      om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
      serializer.setObjectMapper(om);
      //String序列化配置
      StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
      //key采用String的序列化方式
      template.setKeySerializer(stringRedisSerializer);
      // hash的key也采用String的序列化方式
      template.setHashKeySerializer(stringRedisSerializer);
      //对于value我们采用json的序列化方式
      template.setValueSerializer(serializer);
      //对于Hash的Value我们也用json的序列化方式
      template.setHashValueSerializer(serializer);
      // 调用刚才看的序列化源码中默认的方法,重新设置序列化
      template.afterPropertiesSet();
      return template;
   }
}
