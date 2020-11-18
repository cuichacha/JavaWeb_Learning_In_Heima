package Code.List;

import Utils.JedisUtil;
import redis.clients.jedis.Jedis;

public class RedisList {
    public static void main(String[] args) {
        Jedis jedis = JedisUtil.getJedis();
        jedis.lpush("key2", "v1", "v2", "v3", "v4", "v5");
        System.out.println(jedis.lindex("key2", 3));
        System.out.println(jedis.llen("key2"));
        System.out.println(jedis.lrange("key2", 0, -1));

        jedis.close();
    }
}
