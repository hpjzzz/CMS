package cn.itsource.ehcache;

import cn.itsource.ssm.domain.Condition;
import cn.itsource.ssm.mapper.AddressMapper;
import cn.itsource.ssm.mapper.JobMapper;
import cn.itsource.ssm.mapper.PictureMapper;
import cn.itsource.ssm.util.EhcacheUtil;
import cn.itsource.ssm.zzz.Job;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Method;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EhcacheTest {

	@Autowired
	private AddressMapper addressMapper;

	@Autowired
	private PictureMapper pictureMapper;

	@Autowired
	private JobMapper jobMapper;

	@Autowired
	private CacheManager cm;

	@Test
	public void testQuery() throws Exception {
		/**
		 * 需求：把list从缓存中拿出来
		 * 1.写出一般的查询流程
		 * 2.创建缓存
		 * 3.如果有缓存，把list从缓存中拿出来
		 * 如果没有就生成
		 */
		//可能出现的问题：当将查询的数据强转时不能转换对应的数据类型
		//测试报错是不能强转,其实是没有获取到value
		//最终原因：没有存储到磁盘
		// 是没有实现序列化
		Condition con = new Condition();
		for (int i = 0; i < 5; i++) {
			List<Job> list = (List<Job>) EhcacheUtil.getData(cm, "jobCache", "addrList", jobMapper, "findByQuery",con);
			System.out.println("这是原始数据："+EhcacheUtil.getData(cm, "jobCache", "addrList", jobMapper, "findByQuery",con)+"\n"+"这是结尾");
			for (Job address : list) {
				System.out.println(address);
			}
			System.out.println(list);
		}
	}

	private Object getData(String cacheName, String dataKey, Object mapper, String methodName, Object... obj) throws Exception {
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
			Method method = clz.getMethod(methodName, Object[].class);
			/**
			 * 如果参数是可变参数并且是一个Object类型
			 * 反射调用的时候，传递的是一个数组的时候，将自动拆分
			 * 如果直接传递一个Object类型的数组，底层会将数组拆分
			 * 这个时候元素的类型可能不是Object，就会报调用方法的时候，参数异常
			 */
			Object[] obj2 = new Object[]{obj};
			Object value = method.invoke(mapper, obj2);
			//将查询到的数据放到缓存中
			Element data = new Element(dataKey, value);
			cache.put(data);
			//重新获取element
			element = cache.get(dataKey);
		}
		return element.getObjectValue();
	}

	@Test
	public void getData2() throws Exception {

		//当缓存中没有数据，就调用dao层查询
		/**
		 * List<Address> list = addressMapper.findAll();
		 *使用反射去调用
		 * 1.获取对应的字节码对象
		 * 2.获取方法
		 * 3.获取method对象
		 * 4.执行方法
		 */
		Condition con = new Condition();
		Class<? extends Object> clz = jobMapper.getClass();
		Method findCount = clz.getMethod("loadByQuery", Condition.class);
		Object invoke = findCount.invoke(jobMapper,con);
		List<Job> i = (List<Job>)invoke;
		System.out.println(i);
		/**
		 * 如果参数是可变参数并且是一个Object类型
		 * 反射调用的时候，传递的是一个数组的时候，将自动拆分
		 * 如果直接传递一个Object类型的数组，底层会将数组拆分
		 * 这个时候元素的类型可能不是Object，就会报调用方法的时候，参数异常
		 */
//		Object[] obj2 = new Object[]{obj};
//		Object value = method.invoke(mapper, obj2);
	}

}
