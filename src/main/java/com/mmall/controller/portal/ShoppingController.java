package com.mmall.controller.portal;

import com.github.pagehelper.PageInfo;
import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Shopping;
import com.mmall.pojo.User;
import com.mmall.service.IShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;

/**
 * 删改查都要防止横向越权，所以自己设置dao的SQL查询语句
 * @author admin
 * @date 2018/8/3 19:33
 */

@Controller
@RequestMapping("/shopping/")
public class ShoppingController {

    @Autowired
    private IShoppingService iShoppingService;

    /**
     * 新增收货地址
     * @param session
     * @param shopping
     * @return
     */
    @RequestMapping("add.do")
    @ResponseBody
    public ServerResponse add(HttpSession session, Shopping shopping){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorMessage("用户未登录，请登录");
        }
        return iShoppingService.add(user.getId(),shopping);
    }

    /**
     * 删除收货地址
     * @param session
     * @param shoppingId
     * @return
     */
    @RequestMapping("del.do")
    @ResponseBody
    public ServerResponse del(HttpSession session, Integer shoppingId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("用户未登录，请登录");
        }
        return iShoppingService.del(user.getId(), shoppingId);
    }

    /**
     * 更新收货地址
     * @param session
     * @param shopping
     * @return
     */
    @RequestMapping("update.do")
    @ResponseBody
    public ServerResponse update(HttpSession session, Shopping shopping) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("用户未登录，请登录");
        }
        return iShoppingService.update(user.getId(), shopping);
    }

    @RequestMapping("search.do")
    @ResponseBody
    public ServerResponse search(HttpSession session, Integer shoppingId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("用户未登录，请登录");
        }
        return iShoppingService.search(user.getId(), shoppingId);
    }


    /**
     * 收货地址列表
     * @param pageNum
     * @param pageSize
     * @param session
     * @return
     */
    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<PageInfo> list(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize",defaultValue = "10")int pageSize,
                                        HttpSession session ){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        return iShoppingService.list(user.getId(),pageNum,pageSize);
    }
}
