package cn.e3mall.jedis.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class JedisTest {

	@Test
	public void testJedisCluster() {
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.25.128",(int)6379));  
		nodes.add(new HostAndPort("192.168.25.132",(int)6379)); 
		nodes.add(new HostAndPort("192.168.25.130",(int)6379));
		nodes.add(new HostAndPort("192.168.25.129",(int)6379));  
		nodes.add(new HostAndPort("192.168.25.134",(int)6379)); 
		nodes.add(new HostAndPort("192.168.25.135",(int)6379));
		
		JedisCluster cluster = new JedisCluster(nodes);
		
		cluster.set("jedis-cluster", "hello jedis cluster");
		String result = cluster.get("jedis-cluster");
		System.out.println(result);
		
		cluster.close();
	}
	
	
	@Test
	public void testJedisPool() throws Exception {
		// 第一步：创建一个JedisPool对象。需要指定服务端的ip及端口。
		JedisPool jedisPool = new JedisPool("192.168.25.135", 6379);
		// 第二步：从JedisPool中获得Jedis对象。
		Jedis jedis = jedisPool.getResource();
		// 第三步：使用Jedis操作redis服务器。
		jedis.set("jedis", "test1");
		String result = jedis.get("jedis");
		System.out.println(result);
		// 第四步：操作完毕后关闭jedis对象，连接池回收资源。
		jedis.close();
		// 第五步：关闭JedisPool对象。
		jedisPool.close();
	}
}
