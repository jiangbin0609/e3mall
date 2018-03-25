package cn.e3mall.common.jedis;

/**   
 * @description  redis工具接口
 * @author JiangBin   
 * @date 2018年3月7日 下午10:10:56 
 * @version 1.0.0  
 * @
 */
public interface JedisClient {

	/** 
	 * @description 向redis中添加数据
	 * @param key
	 * @param value
	 * @return
	 * @exception
	 * @author JiangBin
	 * @date 2018年3月7日 下午10:11:15
	 * @version 1.0.0
	 */
	String set(String key, String value);

	/** 
	 * @description 从redis中获取数据
	 * @param key
	 * @return
	 * @exception
	 * @author JiangBin
	 * @date 2018年3月7日 下午10:11:38
	 * @version 1.0.0
	 */
	String get(String key);

	/** 
	 * @description 判断该数据是否在redis中
	 * @param key
	 * @return
	 * @exception
	 * @author JiangBin
	 * @date 2018年3月7日 下午10:11:58
	 * @version 1.0.0
	 */
	Boolean exists(String key);

	/** 
	 * @description 指定过期时间
	 * @param key
	 * @param seconds
	 * @return
	 * @exception
	 * @author JiangBin
	 * @date 2018年3月7日 下午10:21:42
	 * @version 1.0.0
	 */
	Long expire(String key, int seconds);

	/** 
	 * @description 查看该值到期的剩余时间
	 * @param key
	 * @return
	 * @exception
	 * @author JiangBin
	 * @date 2018年3月7日 下午10:23:26
	 * @version 1.0.0
	 */
	Long ttl(String key);

	/** 
	 * @description 将value的值原子性的递增1
	 * @param key
	 * @return
	 * @exception
	 * @author JiangBin
	 * @date 2018年3月7日 下午10:24:40
	 * @version 1.0.0
	 */
	Long incr(String key);

	Long hset(String key, String field, String value);

	String hget(String key, String field);

	Long hdel(String key, String... field);
}
