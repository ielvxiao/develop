package redis;

import com.lvxiao.redis.entity.Student;
import com.lvxiao.redis.utils.JedisUtil;
import com.lvxiao.redis.utils.SerializeUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lvxiao
 * @date 2019/4/27
 */
public class RedisTest {

    private JedisUtil jedisUtil;

    @Before
    public void before() {
        jedisUtil = JedisUtil.getInstance();

    }

    @Test
    public void testPutGet() {

//        strings.set("nnn", "nnnn");
//        System.out.println("-----" + strings.get("nnn"));
//        Jedis jedis = JedisUtil.getInstance().getJedis();
//        jedisUtil.expire("test",100);
//
//        JedisUtil.Hash hash = jedisUtil.new Hash();
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("henan", "lvxiao");
//        System.out.println(hash.hmset("china", map));
//        JedisUtil.getInstance().returnJedis(jedis);
        JedisUtil.Strings strings = jedisUtil.new Strings();
        Student student = new Student(18, "吕啸");

      //  strings.set("dx", SerializeUtil.serizlize(student));


        Object object = new Object();
        object = SerializeUtil.deserialize(strings.getByteSByKey("dx"));
        Student os = (Student) object;
        System.out.println(os.getName());
    }


}
