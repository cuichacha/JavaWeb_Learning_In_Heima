package Code.String;

import Utils.JedisUtil;
import redis.clients.jedis.Jedis;

public class RedisString {
    public static void main(String[] args) {
        Jedis jedis = JedisUtil.getJedis();
        jedis.set("k1", "v1");
        System.out.println(jedis.get("k1"));
        jedis.mset("k2", "v2", "k3", "v3");
        System.out.println(jedis.mget("k2", "k3"));
        System.out.println(jedis.strlen("k1"));
        jedis.del("k1");
        jedis.del("k2");
        jedis.del("k3");
        jedis.close();
    }
}
