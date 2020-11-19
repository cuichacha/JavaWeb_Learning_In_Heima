package Code.Set;

import Utils.JedisUtil;
import redis.clients.jedis.Jedis;

public class RedisSet {
    public static void main(String[] args) {
        Jedis jedis = JedisUtil.getJedis();
        jedis.sadd("key", "v1", "v2", "v3", "v4", "v5", "v5");
        System.out.println(jedis.smembers("key"));
        System.out.println(jedis.scard("key"));
        jedis.close();
    }
}
