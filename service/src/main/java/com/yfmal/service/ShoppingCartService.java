package com.yfmal.service;

import com.yfmal.entity.ShoppingCart;
import com.yfmal.vo.ResultVO;

import java.util.List;

public interface ShoppingCartService {

    public ResultVO addShoppingCart(ShoppingCart cart);

    public ResultVO listShoppingCartsByUserId(int userId);

    public ResultVO updateCartNum(int cartId,int cartNum);

    public ResultVO listShoppingCartsByCids(String cids);

}
