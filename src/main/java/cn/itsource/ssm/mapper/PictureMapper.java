package cn.itsource.ssm.mapper;

import cn.itsource.ssm.domain.Condition;
import cn.itsource.ssm.domain.Picture;
import java.util.List;

public interface PictureMapper extends BaseMapper<Picture> {
    //分页查询
    List<Picture> loadByQuery(Condition con);
}
