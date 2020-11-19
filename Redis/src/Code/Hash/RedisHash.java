package Code.Hash;

import Utils.JedisUtil;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class RedisHash {
    public static void main(String[] args) {
        Jedis jedis = JedisUtil.getJedis();
        jedis.hset("key1", "k1", "v1");
        System.out.println(jedis.hget("key1", "k1"));
        Map<String, String> map = new HashMap<>();
        map.put("k2", "v2");
        map.put("k3", "v3");
        map.put("k4", "v4");
        jedis.hmset("key2", map);
        System.out.println(jedis.hmget("key2", "k2", "k3", "k4"));
        System.out.println(jedis.hgetAll("key2"));
        System.out.println(jedis.hlen("key2"));
        jedis.close();
    }
}
