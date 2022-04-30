package com.yfmal;

import com.yfmal.dao.CategoryMapper;
import com.yfmal.dao.ProductCommentsMapper;
import com.yfmal.dao.ProductMapper;
import com.yfmal.dao.ShoppingCartMapper;
import com.yfmal.entity.CategoryVO;
import com.yfmal.entity.ProductCommentsVO;
import com.yfmal.entity.ProductVO;
import com.yfmal.entity.ShoppingCartVO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
class ApiApplicationTests {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductCommentsMapper productCommentsMapper;

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Test
    void contextLoads() {
        List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories();
        for (CategoryVO c1 : categoryVOS){
            System.out.println(c1);
            for (CategoryVO c2 : c1.getCategories()){
                System.out.println("\t"+c2);
                for (CategoryVO c3 : c2.getCategories()){
                    System.out.println("\t\t"+c3);

                }
            }
        }
    }

    @Test
    public void testRecommand(){
        List<ProductVO> productVOS = productMapper.selectRecommendProducts();
        for (ProductVO p:productVOS){
            System.out.println(p);
        }
    }

    @Test
    public void testSelectFirstLevelCategory() {
        List<CategoryVO> categoryVOS = categoryMapper.selectFirstLevelCategories();
        for (CategoryVO c : categoryVOS) {
            System.out.println(c);
        }
    }


    @Test
    public void testShopCart(){
        List<ShoppingCartVO> shoppingCartVOS = shoppingCartMapper.selectShopcartByUserId(6);
        System.out.println(shoppingCartVOS);
    }

}
