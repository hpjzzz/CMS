package cn.itsource.ssm.mapper;

import cn.itsource.ssm.domain.Condition;
import cn.itsource.ssm.zzz.Job;

import java.util.List;

public interface JobMapper extends BaseMapper<Job> {
    List<Job> findByQuery(Condition con);
}
