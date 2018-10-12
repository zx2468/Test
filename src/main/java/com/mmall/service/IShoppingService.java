package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Shopping;

/**
 * @author admin
 * @date 2018/8/3 19:33
 */
public interface IShoppingService {

    ServerResponse add(Integer userId, Shopping shopping);

    ServerResponse<String> del(Integer userId,Integer shoppingId);

    ServerResponse update(Integer userId, Shopping shopping);

    ServerResponse<Shopping> search(Integer userId, Integer shoppingId);

    ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize);
}
