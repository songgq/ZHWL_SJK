package com.ustcsoft.jt.controller;

import com.ustcsoft.framework.vo.BaseResult;
import com.ustcsoft.framework.vo.UserVO;
import com.ustcsoft.jt.cache.CacheManagerUtil;
import com.ustcsoft.jt.constant.Constant;
import com.ustcsoft.jt.service.SysUserService;
import com.ustcsoft.jt.util.CommonUtils;
import com.ustcsoft.jt.util.MD5Util;
import com.ustcsoft.jt.vo.AppUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @des 外网app登录接口控制器
 * @author mapp
 * @date 2018/3/22
 */
@RestController
@RequestMapping(value = "/login", produces = "application/json;charset=utf-8")
//@Api(value = "login", description = "登录接口")
public class LoginController extends AbstractRestController {

    @Resource
    private SysUserService sysUserService;

    /**
     * 登录接口
     * @param username
     * @param password
     * @param isVisitor
     * @return
     */
    @ApiOperation(value = "登录接口", notes = "登录接口", httpMethod = "POST", response = Object.class)
    @RequestMapping(value = "/testLogin", method = RequestMethod.POST)
    public Map<String, Object> testLogin(@ApiParam(name = "username", value = "用户名") @RequestParam(required = false) String username
                                        ,@ApiParam(name = "password", value = "密码") @RequestParam(required = false) String password,
                                         @ApiParam(name = "isVisitor", value = "是否游客登录，不是不需要填写。是填1") @RequestParam(required = false) String isVisitor) {

        // 是否游客登录
        if ("1".equals(isVisitor)) {
            return BaseResult.successResult("登录成功");
        }

        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return BaseResult.failResult("用户名或密码不能为空");
        }

        AppUser appUser = sysUserService.loadAppUserByUsername(username);
        if (appUser == null) {
            return BaseResult.failResult("无该用户信息");
        }

        if (username.equals(appUser.getUsername()) && MD5Util.MD5(password).equals(appUser.getPassword())) {
            String uuid = CommonUtils.getUUDI();
            // 加入缓存
            CacheManagerUtil.add(Constant.USERTOKENCACH, uuid, appUser);
            Map<String, Object> result = BaseResult.successResult("登录成功");
            result.put("tokenId", uuid);
            return result;
        }else {
            return BaseResult.authFailResult("用户名或密码不正确");
        }
    }

    /**
     * 校验是否登录
     * @param tokenId
     * @return
     */
    @ApiOperation(value = "校验是否登录", notes = "校验是否登录", httpMethod = "GET", response = Object.class)
    @RequestMapping(value = "/checkLogin", method = RequestMethod.GET)
    public Map<String, Object> checkLogin(@ApiParam(name = "tokenId", value = "用户token", required = true) @RequestParam String tokenId) {

        AppUser appUser = getCurrentAppUser(tokenId);
        if (appUser == null) {
            return BaseResult.failResult("登录信息已失效");
        }
        return BaseResult.successResult("登录信息未失效");
    }

    /**
     * 退出登录接口
     * @param tokenId
     * @return
     */
    @ApiOperation(value = "退出登录接口", notes = "退出登录接口", httpMethod = "GET", response = Object.class)
    @RequestMapping(value = "/layout", method = RequestMethod.GET)
    public Map<String, Object> layout(@ApiParam(name = "tokenId", value = "用户token", required = true) @RequestParam String tokenId) {

        AppUser appUser = getCurrentAppUser(tokenId);
        if (appUser != null) {
            // 从缓存中清除token
            CacheManagerUtil.remove(Constant.USERTOKENCACH, tokenId);
        }

        return BaseResult.successResult("您已退出登录");
    }

    /**
     * 获取当前用户信息
     * @param tokenId
     * @return
     */
    @ApiOperation(value = "获取当前用户信息", notes = "获取当前用户信息", httpMethod = "GET", response = Object.class)
    @RequestMapping(value = "/getAppuser", method = RequestMethod.GET)
    public Map<String, Object> getAppuser(@ApiParam(name = "tokenId", value = "用户token", required = true) @RequestParam String tokenId) {

        AppUser appUser = getCurrentAppUser(tokenId);
        if (appUser != null) {
            Map<String, Object> result = BaseResult.successResult();
            result.put("appUser", appUser);
            return result;
        }
        return BaseResult.successResult("您未登录或已掉线");

    }

}
