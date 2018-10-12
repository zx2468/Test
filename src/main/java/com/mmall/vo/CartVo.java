package com.mmall.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author admin
 * @date 2018/8/2 15:48
 */
@Setter
@Getter
public class CartVo {
   private List<CartProductVo> cartProductVoList;
   private BigDecimal cartTotalPrice;
   private Boolean allChecked;//是否都已经勾选
   private String imageHost;
}
