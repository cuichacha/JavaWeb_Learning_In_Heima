package Code.Hash;

import Utils.JedisUtil;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class RedisHash {
    public static void main(String[] args) {
        Jedis jedis = JedisUtil.getJedis();
        jedis.hset("key", "k1", "v1");
        System.out.println(jedis.hget("key", "k1"));
        Map<String, String> map = new HashMap<>();
        map.put("k2", "v2");
        map.put("k3", "v3");
        map.put("k4", "v4");
        jedis.hmset("key", map);
        System.out.println(jedis.hgetAll("key"));
        System.out.println(jedis.hget("key", "k3"));
        System.out.println(jedis.hmget("key", "k1", "k2"));
        System.out.println(jedis.hkeys("key"));
        System.out.println(jedis.hvals("key"));
        jedis.close();
    }
}
