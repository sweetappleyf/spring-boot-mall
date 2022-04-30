package com.yfmal.dao;

import com.yfmal.entity.Category;
import com.yfmal.entity.CategoryVO;
import genetator.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryMapper extends GeneralDAO<Category> {
    //连接查询
    public List<CategoryVO> selectAllCategories();
    //2.⼦查询：根据parentId查询⼦分类
    public List<CategoryVO> selectAllCategories2(int parentId);

    //3查询一级类别
    public List<CategoryVO> selectFirstLevelCategories();


}