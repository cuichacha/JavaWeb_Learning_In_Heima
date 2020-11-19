package Code.List;

import Utils.JedisUtil;
import redis.clients.jedis.Jedis;

public class RedisList {
    public static void main(String[] args) {
        Jedis jedis = JedisUtil.getJedis();
        jedis.lpush("k1", "v2", "v3", "v4", "v5");
        jedis.rpush("k1", "v1");
        System.out.println(jedis.lrange("k1", 0, -1));
        System.out.println(jedis.lindex("k1", 3));
        System.out.println(jedis.llen("k1"));
        System.out.println(jedis.lpop("k1"));
        System.out.println(jedis.rpop("k1"));
        System.out.println(jedis.blpop(5, "k1"));
        jedis.close();
    }
}
