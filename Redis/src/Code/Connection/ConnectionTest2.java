package Code.Connection;

import Utils.JedisUtil;
import redis.clients.jedis.Jedis;

public class ConnectionTest2 {
    public static void main(String[] args) {
        Jedis jedis = JedisUtil.getJedis();
        jedis.set("age", "0");
        System.out.println(jedis.get("age"));
        jedis.close();
    }
}

