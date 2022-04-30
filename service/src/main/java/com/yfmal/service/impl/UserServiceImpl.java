package com.yfmal.service.impl;

import com.yfmal.dao.UsersMapper;
import com.yfmal.entity.Users;
import com.yfmal.service.UserService;
import com.yfmal.utils.MD5Utils;
import com.yfmal.vo.ResStatus;
import com.yfmal.vo.ResultVO;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;


import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Transactional
    public ResultVO userResgit(String name, String pwd) {
        synchronized (this) {
            //1.根据⽤户查询，这个⽤户是否已经被注册
            Example example = new Example(Users.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("username",name);
            List<Users> users = usersMapper.selectByExample(example);

            //2.如果没有被注册则进⾏保存操作
            if (users.size() == 0) {
                String md5Pwd = MD5Utils.md5(pwd);
                Users user = new Users();
                user.setUsername(name);
                user.setPassword(md5Pwd);
                user.setUserImg("img/default.png");
                user.setUserRegtime(new Date());
                user.setUserModtime(new Date());
                int i = usersMapper.insertUseGeneratedKeys(user);
                if (i > 0) {
                    return new ResultVO(ResStatus.OK, "注册成功！", user);
                } else {
                    return new ResultVO(ResStatus.NO, "注册失败！", null);
                }
            } else {
                return new ResultVO(ResStatus.NO, "用户名已被注册！", null);
            }
        }
    }

    @Override
    public ResultVO checkLogin(String name, String pwd) {
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",name);
        List<Users> users = usersMapper.selectByExample(example);

        if (users.size() == 0){
            return new ResultVO(ResStatus.NO,"登录失败,用户名不存在!",null);
        }else {
            String md5Pwd = MD5Utils.md5(pwd);
            if (md5Pwd.equals(users.get(0).getPassword())){
                //登录成功，生成token
                JwtBuilder builder = Jwts.builder();
                HashMap<String,Object> map = new HashMap<>();
                map.put("key1","value1");
                map.put("key2","value2");

                String token = builder.setSubject(name)           //主题，token中携带的数据
                        .setIssuedAt(new Date())                  //设置token生成时间
                        .setId(users.get(0).getUserId()+"")         //设置用户ID为token id
                        .setClaims(map)                               //map中可以存放用户的角色权限信息
                        .setExpiration(new Date(System.currentTimeMillis()+24 * 60 * 60 * 1000))//设置token过期时间
                        .signWith(SignatureAlgorithm.HS256,"yangfan123456")//设置加密方式和密码
                        .compact();

                System.out.println(token);
                return new ResultVO(ResStatus.OK,token,users.get(0));
            }else {
                return new ResultVO(ResStatus.NO,"登录失败,密码错误!",null);
            }
        }
    }
}
