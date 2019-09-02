package cn.itsource.ssm.service;

import cn.itsource.ssm.domain.Condition;
import cn.itsource.ssm.domain.PageList;
import cn.itsource.ssm.domain.Picture;
import cn.itsource.ssm.util.PageResult;
import cn.itsource.ssm.util.page.query.PictureQuery;

public interface IPictureService extends IBaseService<Picture> {
    PageList<Picture> loadByQuery(Condition con);//分页

}
