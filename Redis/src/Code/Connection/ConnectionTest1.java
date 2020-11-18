package Code.Connection;

import redis.clients.jedis.Jedis;

public class ConnectionTest1 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.134.2", 6379);
        jedis.set("name", "lalala");
        System.out.println(jedis.get("name"));
        jedis.close();
    }
}

