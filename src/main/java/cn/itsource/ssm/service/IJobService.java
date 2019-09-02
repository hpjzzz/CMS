package cn.itsource.ssm.service;

import cn.itsource.ssm.domain.Condition;
import cn.itsource.ssm.zzz.Job;
import cn.itsource.ssm.domain.PageList;

public interface IJobService extends IBaseService<Job> {
    PageList<Job> findByQuery(Condition con);
    void add(Job job, Condition con);
    void update(Job job,Condition con);
    void delete(Long id, String path);
}
