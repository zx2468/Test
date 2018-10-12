package com.mmall.dao;

import com.mmall.pojo.Shopping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author admin
 * @date 2018/8/2 10:41
 */
public interface ShoppingMapper {
        int deleteByPrimaryKey(Integer id);

        int insert(Shopping record);

        int insertSelective(Shopping record);

        Shopping selectByPrimaryKey(Integer id);

        int updateByPrimaryKeySelective(Shopping record);

        int updateByPrimaryKey(Shopping record);

        int deleteByShoppingIdUserId(@Param("userId")Integer userId, @Param("shippingId") Integer shippingId);

        int updateByShopping(Shopping record);

        Shopping selectByShoppingIdUserId(@Param("userId")Integer userId,@Param("shippingId") Integer shippingId);

        List<Shopping> selectByUserId(@Param("userId")Integer userId);

}
