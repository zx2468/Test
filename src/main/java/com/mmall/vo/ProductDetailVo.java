package com.mmall.vo;

import java.math.BigDecimal;


/**
 * @author admin
 * @date 2018/7/31 19:22
 */

@lombok.Getter
@lombok.Setter
public class ProductDetailVo {

    private Integer  id;
    private Integer categoryId;
    private String name;
    private String subtitle; //副标题
    private String mainImage; //主文本
    private String subImages; //副文本
    private String detail;
    private BigDecimal price;
    private Integer stock; //库存
    private Integer status;
    private String createTime;
    private String updateTime;

    private String imageHost; //图片服务器的URL的前缀
    private Integer parentCategoryId; //父分类


}
