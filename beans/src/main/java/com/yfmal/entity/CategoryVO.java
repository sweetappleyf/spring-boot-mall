package com.yfmal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 首页类别商品推荐
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryVO {


    private Integer categoryId;
    private String categoryName;
    private Integer categoryLevel;
    private Integer parentId;
    private String categoryIcon;
    private String categorySlogan;
    private String categoryPic;
    private String categoryBgColor;
    //实现⾸⻚的类别显示
    private List<CategoryVO> categories;
    //实现⾸⻚分类商品推荐
    private List<ProductVO> products;



}