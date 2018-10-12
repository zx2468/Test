package com.mmall.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author admin
 * @date 2018/8/6 16:33
 */
@Getter
@Setter
public class OrderVo {

    private Long orderNo;

    private BigDecimal payment;

    private Integer paymentType;
    private String PaymentTypeDesc;

    private Integer postage;

    private Integer status;
    private String statusDesc;
    private String paymentTime;

    private String sendTime;

    private String endTime;

    private String closeTime;

    private String createTime;

    private String updateTime;

    //订单明细 orderItem
    private List<OrderItemVo> orderItemVoList;

    private String imageHost;
    private Integer shoppingId;
    private String receiverName;

    private ShoppingVo shoppingVo;
}
