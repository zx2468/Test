package com.mmall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.mmall.common.ServerResponse;
import com.mmall.dao.ShoppingMapper;
import com.mmall.pojo.Shopping;
import com.mmall.service.IShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @date 2018/8/3 19:34
 */
@Service("iShoppingService")
public class ShoppingServiceImpl implements IShoppingService {

    @Autowired
    private ShoppingMapper shoppingMapper;

    public ServerResponse add(Integer userId, Shopping shopping){
        shopping.setId(shopping.getId());
        int rowcount = shoppingMapper.insert(shopping);
        if(rowcount > 0){
            Map result = Maps.newHashMap();
            result.put("shoppingId",shopping.getId());
            return ServerResponse.createBySuccess("新建地址成功",result);
        }
        return ServerResponse.createByErrorMessage("添加地址失败");
    }

    /**
     * 删除收货地址
     * @param userId
     * @param shoppingId
     * @return
     */
    public ServerResponse<String> del(Integer userId,Integer shoppingId){
        int rowcount = shoppingMapper.deleteByShoppingIdUserId(userId,shoppingId);
        if(rowcount > 0){
            return ServerResponse.createBySuccessMessage("删除地址成功");
        }
        return ServerResponse.createByErrorMessage("删除地址失败");
    }

    public ServerResponse update(Integer userId, Shopping shopping){
        shopping.setUserId(userId);
        int rowcount = shoppingMapper.updateByShopping(shopping);
        if(rowcount > 0){
            return ServerResponse.createBySuccess("更新地址成功");
        }
        return ServerResponse.createByErrorMessage("更新地址失败");
    }

    public ServerResponse<Shopping> search(Integer userId, Integer shoppingId){
        Shopping shopping = shoppingMapper.selectByShoppingIdUserId(userId,shoppingId);
        if(shopping == null){
            return ServerResponse.createByErrorMessage("无法查询到该地址");
        }
        return ServerResponse.createBySuccess("查询地址成功",shopping);
    }

    public ServerResponse<PageInfo> list(Integer userId,int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Shopping> shoppingList = shoppingMapper.selectByUserId(userId);
        PageInfo pageInfo = new PageInfo(shoppingList);
        return ServerResponse.createBySuccess(pageInfo);
    }
}
