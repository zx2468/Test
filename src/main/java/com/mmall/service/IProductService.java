package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.vo.ProductDetailVo;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author admin
 * @date 2018/7/31 15:22
 */
public interface IProductService {

    /**
     * 管理员的更新和添加爱产品
     * @param product
     * @return
     */
    ServerResponse saveOrUpdateProduct(Product product);

    ServerResponse<String> setSaleStatus(Integer productId,Integer status);

    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);

    ServerResponse<PageInfo> searchProduct(String productName,Integer productId,int pageNum,int pageSize);

    /**
     * 客户端的查找产品，如果产品存在返回详情，不存在返回下架
     * @param productId
     * @return
     */
    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductByKeywordCategory( String keyword, Integer categoryId, int pageNum, int pageSize, String orderBy);
}
