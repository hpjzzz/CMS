package cn.itsource.ssm.service.impl;

import cn.itsource.ssm.mapper.BaseMapper;
import cn.itsource.ssm.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class BaseServiceImpl<T> implements IBaseService<T> {

    @Autowired
    private BaseMapper<T> baseMapper;

    @Override
    public void add(T t) {
        baseMapper.add(t);
    }

    @Override
    public void delete(Long id) {
        baseMapper.delete(id);
    }


    @Override
    public void update(T t) {
        baseMapper.update(t);
    }

    @Override
    public T findOne(Long id) {
        return baseMapper.findOne(id);
    }

    @Override
    public List<T> findAll() {
        return baseMapper.findAll();
    }
}
