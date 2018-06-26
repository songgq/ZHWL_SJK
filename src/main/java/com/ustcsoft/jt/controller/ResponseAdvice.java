//package com.ustcsoft.jt.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.ustcsoft.jt.util.Base64Util;
//import com.ustcsoft.jt.wrapper.ResponseWrapper;
//import org.springframework.core.MethodParameter;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.http.server.ServletServerHttpResponse;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author mapp
// * @des
// * @date 2018/4/19
// */
//@ControllerAdvice
//public class ResponseAdvice implements ResponseBodyAdvice<Object> {
//
//    @Override
//    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
//        String controllerName = methodParameter.getMethod().getDeclaringClass().getSimpleName();
//        // 拦截api开头的控制器
//        if (controllerName.startsWith("API")) {
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
//                                  Class<? extends HttpMessageConverter<?>>
//                                          aClass, ServerHttpRequest serverHttpRequest,
//                                  ServerHttpResponse serverHttpResponse) {
//
////        ServletServerHttpResponse servletServerHttpResponse = (ServletServerHttpResponse) serverHttpResponse;
////        // 使用包装的ResponseWrapper
////        ResponseWrapper wrapper = new ResponseWrapper(servletServerHttpResponse.getServletResponse());
//        String result = "";
//        try {
//            result = JSON.toJSONString(o);
//            result = Base64Util.encodeData(result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//}
