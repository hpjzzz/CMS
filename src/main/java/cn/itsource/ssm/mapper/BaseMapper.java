package cn.itsource.ssm.mapper;

import cn.itsource.ssm.domain.Condition;

import java.util.List;

public interface BaseMapper<T> {
    void add(T t);

    void delete(Long id);

    void update(T t);

    T findOne(Long id);

    List<T> findAll();
    //查询总数据
    int findCount(Condition con);
}
