package com.yfmal.dao;

import com.yfmal.entity.ProductImg;
import genetator.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductImgMapper extends GeneralDAO<ProductImg> {

    public List<ProductImg> selectProductImgByProductId(int productId);

}