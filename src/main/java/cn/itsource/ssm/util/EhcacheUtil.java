package cn.itsource.ssm.util;

import cn.itsource.ssm.domain.Condition;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.lang.reflect.Method;

public class EhcacheUtil {
	/**
	 * @param cm         缓存管理对象
	 * @param cacheName  缓存对象名
	 * @param dataKey    数据的key
	 * @param mapper     调用的dao
	 * @param methodName 调用的方法
	 * @param obj        参数
	 * @return
	 * @throws Exception
	 */
	public static Object getData(CacheManager cm, String cacheName, String dataKey, Object mapper, String methodName, Object... obj) throws Exception {
		Cache cache = cm.getCache(cacheName);
		Element element = cache.get(dataKey);

		if (element == null) {
			//当缓存中没有数据，就调用dao层查询
			/**
			 * List<Address> list = addressMapper.findAll();
			 *使用反射去调用
			 * 1.获取对应的字节码对象
			 * 2.获取方法
			 * 3.获取method对象
			 * 4.执行方法
			 */
			Class<? extends Object> clz = mapper.getClass();
			Method method = null;
			Object value = null;
			//判断调用的不同的方法
			if (obj == null) {
				method = clz.getMethod(methodName);
				value = method.invoke(mapper);
			} else if (obj[0] instanceof Condition){
				method = clz.getMethod(methodName, Condition.class);
				value = method.invoke(mapper, obj[0]);
			}else {
				method = clz.getMethod(methodName, Object[].class);
				/**
				 * 如果参数是可变参数并且是一个Object类型
				 * 反射调用的时候，传递的是一个数组的时候，将自动拆分
				 * 如果直接传递一个Object类型的数组，底层会将数组拆分
				 * 这个时候元素的类型可能不是Object，就会报调用方法的时候，参数异常
				 */
				Object[] obj2 = new Object[]{obj};
				//封装调用
				value = method.invoke(mapper, obj2);
			}


			//将查询到的数据放到缓存中
			Element data = new Element(dataKey, value);
			cache.put(data);
			//重新获取element
			element = cache.get(dataKey);
		}
		return element.getObjectValue();
	}
}
