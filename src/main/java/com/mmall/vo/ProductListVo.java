package com.mmall.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


/**
 * @author admin
 * @date 2018/8/1 9:26
 */


@Setter
@Getter
public class ProductListVo {

    private Integer id;
    private Integer categoryId;
    private String name;
    private String subtitle;
    private String mainImage;
    private BigDecimal price;
    private Integer status;
    private String imageHost;


}
