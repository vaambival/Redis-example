import redis.clients.jedis.JedisPooled;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try (JedisPooled jedis = new JedisPooled("localhost", 6379)) {
            String value = jedis.get("bike:1");
            if (value != null) System.out.println("The name of the bike is: " + value + ".");
            Map<String, String> bike1 = new HashMap<>();
            bike1.put("model", "Deimos");
            bike1.put("brand", "Ergonom");
            bike1.put("type", "Enduro bikes");
            bike1.put("price", "4972");

            Long res1 = jedis.hset("moto:1", bike1);
            System.out.println(res1); // 4

            String res2 = jedis.hget("moto:1", "model");
            System.out.println(res2); // Deimos

            String res3 = jedis.hget("moto:1", "price");
            System.out.println(res3); // 4972

            Map<String, String> res4 = jedis.hgetAll("moto:1");
            System.out.println(res4);
        }

    }
}
