import redis.clients.jedis.Jedis;

public class TedisTest {
    public static void main(String[] args) {
        //连接本地的jedis服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //测试是否已经连接
        //生成键值对的key
        System.out.println(jedis.set("myname","zz"));
        //判断redis是否正在运行
        System.out.println("服务正在运行"+jedis.ping());
        //根据键获取值
//        System.out.println(jedis.get("myname"));
        //删除键
//        System.out.println(jedis.del("myname"));
        //序列化键
        System.out.println(jedis.dump("myname"));
        //key是否存在
        System.out.println(jedis.exists("myname"));
        //设置过期时间,以秒计
        System.out.println(jedis.expire("myname",60));
        //设置过期时间戳
        long l =100000;
        System.out.println(jedis.expireAt("myname",l));
        //设置毫秒级过期时间
        System.out.println(jedis.pexpireAt("myname",50000));
        //符合模式
        System.out.println(jedis.keys("m"));
        //将当前数据库的key存储在指定的数据库当中去
        jedis.move("",22);
        //将这个键持久化
        jedis.persist("myname");
        //获取key的剩余存活时间，毫秒级别
        System.out.println(jedis.pttl("myname"));
        //从当前数据库中随机的返回key
        System.out.println(jedis.randomKey());
        //重新命名key
        System.out.println(jedis.rename("myname","newname"));
        //获取键的值的所有类型
        System.out.println(jedis.type("newname"));
    }
}
