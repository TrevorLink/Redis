import redis.clients.jedis.Jedis;

/**
 * @author HuangSir
 * @date 2021-11-25 13:01
 */
public class RedisTest {
   public static void main(String[] args) {
      Jedis jedis = new Jedis("120.24.179.229",6379);
      System.out.println(jedis.ping());
      jedis.close();
   }
}
