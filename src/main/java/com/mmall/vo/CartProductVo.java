package com.mmall.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author admin
 * @date 2018/8/2 15:38
 */
@Getter
@Setter
public class CartProductVo {

    //结合了产品和购物车的一个抽象对象

    private Integer id;//购物车id
    private Integer userId;
    private Integer productId;
    private Integer quantity;//购物车中此商品的数量
    private String productName;
    private String productSubtitle;
    private String productMainImage;
    private BigDecimal productPrice;
    private Integer productStatus;
    private BigDecimal productTotalPrice;//购物车商品总价
    private Integer productStock;//库存
    private Integer productChecked;//此商品是否勾选

    private String limitQuantity;//限制数量的一个返回结果

}
