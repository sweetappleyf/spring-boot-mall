package com.yfmal.service;

import com.yfmal.vo.ResultVO;

public interface ProductCommontsService {

    /**
     *根据商品ID分页查询评论信息
     * @param productId 商品ID
     * @param pageNum 起始索引
     * @param limit  查询条数
     * @return
     */
    public ResultVO listCommontsByProductId(String productId,int pageNum,int limit);

    /**
     * 根据商品ID统计当前商品的评价信息
     * @param productId
     * @return
     */
    public ResultVO getCommentsCountByProductId(String productId);

}
