package cn.itsource.ssm.web.controller;


import cn.itsource.ssm.domain.Address;
import cn.itsource.ssm.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private IAddressService addressService;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Address> findAll(){
        System.out.println("11111");
        return addressService.findAll();
    }


}
