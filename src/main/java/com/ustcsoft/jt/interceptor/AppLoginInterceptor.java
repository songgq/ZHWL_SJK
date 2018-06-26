package com.ustcsoft.jt.interceptor;

import com.ustcsoft.framework.vo.UserVO;
import com.ustcsoft.jt.cache.CacheManagerUtil;
import com.ustcsoft.jt.constant.Constant;
import com.ustcsoft.jt.exception.AppBusinessException;
import com.ustcsoft.jt.vo.AppUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @des 是否登录拦截器
 * @author mapp
 * @date 2018/3/21.
 */
public class AppLoginInterceptor implements HandlerInterceptor{


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

//        String tokenId = request.getParameter("tokenId");
//        if (StringUtils.isBlank(tokenId)) {
//            throw new AppBusinessException(Constant.SECURITY_ERROR, "tokenId为空");
//        }else {
//            AppUser appUser = (AppUser) CacheManagerUtil.get(Constant.USERTOKENCACH, tokenId);
//            if (appUser == null) {
//                throw new AppBusinessException(Constant.SECURITY_ERROR, "您未登录或者您已掉线");
//            }
//            System.out.println(appUser.getUsername() + "-----------------------");
//        }
//        System.out.println("===========HandlerInterceptor1 preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
