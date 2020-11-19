package Code.List;

import Utils.JedisUtil;
import redis.clients.jedis.Jedis;

public class RedisList {
    public static void main(String[] args) {
        Jedis jedis = JedisUtil.getJedis();
        jedis.lpush("key", "v2", "v3", "v4", "v5");
        jedis.rpush("key", "v1");
        System.out.println(jedis.lindex("key", 3));
        System.out.println(jedis.llen("key"));
        System.out.println(jedis.lrange("key", 0, -1));
        System.out.println(jedis.lpop("key"));
        System.out.println(jedis.rpop("key"));
        jedis.rpush("key", "v1");
        jedis.lpush("key", "v5", "v1", "v2", "v3", "v3", "v3");
        jedis.lrem("key", 3, "v3");
        jedis.brpop(10, "key");
        jedis.close();
    }
}
