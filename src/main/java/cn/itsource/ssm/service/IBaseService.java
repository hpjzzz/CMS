package cn.itsource.ssm.service;

import java.util.List;

public interface IBaseService<T> {
    void add(T t);

    void delete(Long id);

    void update(T t);

    T findOne(Long id);

    List<T> findAll();

}
