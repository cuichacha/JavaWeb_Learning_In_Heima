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
        jedis.set("user:id:001:name", "张三");
        jedis.set("user:id:001:age", "23");
        jedis.set("user:id:001:score", "83");
        System.out.println(jedis.get("user:id:001:name"));
        System.out.println(jedis.get("user:id:001:age"));
        System.out.println(jedis.get("user:id:001:score"));
        jedis.close();
    }
}
