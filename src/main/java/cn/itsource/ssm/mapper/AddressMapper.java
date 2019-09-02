package cn.itsource.ssm.mapper;

import cn.itsource.ssm.domain.Address;

public interface AddressMapper extends BaseMapper<Address> {
    String findAddress(Long id);
}
