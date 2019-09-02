package cn.itsource.ssm.service.impl;

import cn.itsource.ssm.domain.Condition;
import cn.itsource.ssm.zzz.Job;
import cn.itsource.ssm.domain.PageList;
import cn.itsource.ssm.mapper.JobMapper;
import cn.itsource.ssm.service.IJobService;
import cn.itsource.ssm.util.EhcacheUtil;
import cn.itsource.ssm.util.FreeMarkerUtil;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class JobServiceImpl extends BaseServiceImpl<Job> implements IJobService {

	@Autowired
	private JobMapper jobMapper;

	@Autowired
	private CacheManager cm;

	@Override
	public void add(Job job) {
		jobMapper.add(job);
	}

	@Override
	public void add(Job job, Condition con) {
		/**
		 * 需求：调用add方法
		 * 需求：要修改模板的路径和生成的路径
		 */
		try {
			String fileName = UUID.randomUUID() + ".html";
			job.setHtmlurl("/temp/" + fileName);
			add(job);
			Cache jobCache = cm.getCache("jobCache");
			jobCache.removeAll();
			FreeMarkerUtil.creatHtml(job, con, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public List<Job> findAll() {
		return jobMapper.findAll();
	}

	@Override
	public PageList<Job> findByQuery(Condition con) {
		//用ehcache处理
		Integer count = 0;
		PageList<Job> pageList = null;
		List<Job> job = null;
		//查询到的数据总数
		try {
			String key = "count" +con.getTitle()+ con.getCurrentPage();
			count = (Integer) EhcacheUtil.getData(cm, "jobCache", key, jobMapper, "findCount", con);
			//查询的带分页的数据
			key = "job" +con.getTitle()+ con.getCurrentPage();
			job = (List<Job>) EhcacheUtil.getData(cm, "jobCache", key, jobMapper, "findByQuery", con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pageList = new PageList<>(con.getCurrentPage(), count, con.getPageSize(), job);
		return pageList;
	}

	@Override
	public void update(Job job, Condition con) {
		try {
			String htmlurl = job.getHtmlurl();
			//判断静态页面是否存在
			String fileName = "";
			if (htmlurl == null || htmlurl.trim().length() == 0) {
				fileName = UUID.randomUUID() + ".html";
			} else {
				fileName = htmlurl.substring(htmlurl.lastIndexOf("/") + 1);
			}
			job.setHtmlurl("/temp/" + fileName);
			jobMapper.update(job);
			//生成静态页面
			FreeMarkerUtil.creatHtml(job, con, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Long id, String path) {
		File file = new File(path);
		if (!file.isDirectory()) {
			file.delete();
		}
		jobMapper.delete(id);
	}
}
