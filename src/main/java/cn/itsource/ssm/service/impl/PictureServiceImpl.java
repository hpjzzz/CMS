package cn.itsource.ssm.service.impl;

import cn.itsource.ssm.domain.Condition;
import cn.itsource.ssm.domain.PageList;
import cn.itsource.ssm.domain.Picture;
import cn.itsource.ssm.mapper.PictureMapper;
import cn.itsource.ssm.service.IPictureService;
import cn.itsource.ssm.util.EhcacheUtil;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl extends BaseServiceImpl<Picture> implements IPictureService {
	@Autowired
	private PictureMapper pictureMapper;
	@Autowired
	private CacheManager cm;

	@Override
	public PageList<Picture> loadByQuery(Condition con) {
		PageList<Picture> pageList = null;
		Integer count = 0;
		List<Picture> pictures = null;
		String countKey = "picTotal"+con.getCurrentPage();
		try {
			//查询的带分页的数据
//			List<Picture> pictures = pictureMapper.loadByQuery(con);
			//查询到的数据总数
//			Integer count = pictureMapper.findCount(con);


			count = (Integer) EhcacheUtil.getData(cm, "picCache", countKey, pictureMapper, "findCount", con);
			countKey = "pic"+con.getCurrentPage();
			pictures = (List<Picture>) EhcacheUtil.getData(cm, "picCache", countKey, pictureMapper, "loadByQuery", con);


			pageList = new PageList<>(con.getCurrentPage(), count, con.getPageSize(), pictures);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageList;
	}
//    @Override
//    public PageResult<Picture> loadByQuery(PictureQuery pictureQuery) {
//        PageResult<Picture> pageResult = new PageResult<>();
//        Page<Picture> page = PageHelper.startPage(pictureQuery.getPage(), pictureQuery.getRows());
//        pictureMapper.loadByQuery(pictureQuery);
//        List<Picture> result = page.getResult();
//        //分页数据
//        pageResult.setRows(result);
//        //总条数
//        pageResult.setTotal(page.getTotal());
//        System.out.println(pageResult);
//        return pageResult;
//    }
}
