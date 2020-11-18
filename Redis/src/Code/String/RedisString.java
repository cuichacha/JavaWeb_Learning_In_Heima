package Code.String;

import Utils.JedisUtil;
import redis.clients.jedis.Jedis;

public class RedisString {
    public static void main(String[] args) {
        Jedis jedis = JedisUtil.getJedis();

        jedis.close();
    }
}
