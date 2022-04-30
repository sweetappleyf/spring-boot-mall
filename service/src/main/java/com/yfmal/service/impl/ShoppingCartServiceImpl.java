package com.yfmal.service.impl;

import com.yfmal.dao.ShoppingCartMapper;
import com.yfmal.entity.ShoppingCart;
import com.yfmal.entity.ShoppingCartVO;
import com.yfmal.service.ShoppingCartService;
import com.yfmal.vo.ResStatus;
import com.yfmal.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    public ResultVO addShoppingCart(ShoppingCart cart){
        cart.setCartTime(sdf.format(new Date()));
        int i = shoppingCartMapper.insert(cart);
        if (i>0){
            return new ResultVO(ResStatus.OK,"success",null);

        }else {
            return new ResultVO(ResStatus.NO,"fail",null);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public ResultVO listShoppingCartsByUserId(int userId) {
        List<ShoppingCartVO> list = shoppingCartMapper.selectShopcartByUserId(userId);
        ResultVO resultVO = new ResultVO(ResStatus.OK,"success",list);
        return resultVO;
    }

    @Override
    public ResultVO updateCartNum(int cartId, int cartNum) {
        int i = shoppingCartMapper.updateCartnumByCartid(cartId, cartNum);
        if(i>0){
            return new ResultVO(ResStatus.OK,"update success",null);
        }else{
            return new ResultVO(ResStatus.NO,"update fail",null);
        }

    }



    @Override
    public ResultVO listShoppingCartsByCids(String cids) {
        String[] arr = cids.split(",");
        List<Integer> cartIds = new ArrayList<>();
        for (int i=0; i<arr.length; i++){
            cartIds.add(Integer.parseInt(arr[i]));
        }

        List<ShoppingCartVO> list = shoppingCartMapper.selectShopcartByCids(cartIds);
        ResultVO resultVO = new ResultVO(ResStatus.OK,"success",list);
        return resultVO;

    }


}
