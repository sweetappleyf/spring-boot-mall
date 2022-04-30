package com.yfmal.service;

import com.yfmal.vo.ResultVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Resource
@Service
public interface UserService {

     //用户注册
     public ResultVO userResgit(String name, String pwd);

     //用户登录
     public ResultVO checkLogin(String name, String pwd);

}
