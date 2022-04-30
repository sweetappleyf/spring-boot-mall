package com.yfmal.dao;

import com.yfmal.entity.ShoppingCart;
import com.yfmal.entity.ShoppingCartVO;
import genetator.GeneralDAO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartMapper extends GeneralDAO<ShoppingCart> {

    public List<ShoppingCartVO> selectShopcartByUserId(int userId);

    public int updateCartnumByCartid(@Param("cartId") int cartId,
                                     @Param("cartNum") int cartNum);


    public List<ShoppingCartVO> selectShopcartByCids(List<Integer> cids);


}