package Utils;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Locale;
import java.util.ResourceBundle;

public class JedisUtil {
    private static JedisPool jedisPool;

    private JedisUtil() {
    }

    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("redis");
        String host = resourceBundle.getString("redis.host");
        int port = Integer.parseInt(resourceBundle.getString("redis.port"));
        int maxTotal = Integer.parseInt(resourceBundle.getString("redis.maxTotal"));
        int maxIdle = Integer.parseInt(resourceBundle.getString("redis.maxIdle"));
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPool = new JedisPool(jedisPoolConfig, host, port );
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
