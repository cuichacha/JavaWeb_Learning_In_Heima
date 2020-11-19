package Code.Key;

import Utils.JedisUtil;
import redis.clients.jedis.Jedis;

public class RedisKey {
    public static void main(String[] args) {
        Jedis jedis = JedisUtil.getJedis();
        jedis.sadd("key", "v1", "v2", "v3");
        jedis.expire("key", 10);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(jedis.ttl("key"));
        jedis.close();
    }
}
