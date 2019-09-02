package cn.itsource.ssm.service.impl;

import cn.itsource.ssm.domain.Address;
import cn.itsource.ssm.mapper.AddressMapper;
import cn.itsource.ssm.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressServiceImpl extends BaseServiceImpl<Address> implements IAddressService {
    @Autowired
    private AddressMapper addressMapper;
    @Override
    public void add(Address address) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Address address) {

    }

    @Override
    public Address findOne(Long id) {
        return addressMapper.findOne(id);
    }

    @Override
    public List<Address> findAll() {
        return addressMapper.findAll();
    }

    @Override
    public String findAddress(Long id) {
        return addressMapper.findAddress(id);
    }
}
