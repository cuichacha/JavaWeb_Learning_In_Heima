package Code.Set;

import Utils.JedisUtil;
import redis.clients.jedis.Jedis;

public class RedisSet {
    public static void main(String[] args) {
        Jedis jedis = JedisUtil.getJedis();


        jedis.close();
    }
}
