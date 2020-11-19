package Code.Set;

import Utils.JedisUtil;
import redis.clients.jedis.Jedis;

public class RedisSet {
    public static void main(String[] args) {
        Jedis jedis = JedisUtil.getJedis();
        jedis.sadd("k1", "v1", "v2", "v3", "v3", "v3");
        System.out.println(jedis.smembers("k1"));
        System.out.println(jedis.scard("k1"));
        jedis.srem("k1", "v1", "v2", "v3");
        jedis.close();
    }
}
