package cn.itsource.ssm.service;

import cn.itsource.ssm.domain.Address;

public interface IAddressService extends IBaseService<Address> {
    String findAddress(Long id);
}
