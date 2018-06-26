//package com.ustcsoft.jt.controller;
//
//import com.ustcsoft.jt.util.Base64Util;
//import org.springframework.core.MethodParameter;
//import org.springframework.http.HttpInputMessage;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;
//
//import java.io.IOException;
//import java.lang.reflect.Type;
//
///**
// * @author mapp
// * @des
// * @date 2018/4/19
// */
//@ControllerAdvice
//public class RequestAdvice implements RequestBodyAdvice {
//
//    @Override
//    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
//        String controllerName = methodParameter.getMethod().getDeclaringClass().getSimpleName();
//        // 拦截api开头的控制器
//        if (controllerName.startsWith("API")) {
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Object handleEmptyBody(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
//        return o;
//    }
//
//    @Override
//    public HttpInputMessage beforeBodyRead(HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) throws IOException {
//        return httpInputMessage;
//    }
//
//    @Override
//    public Object afterBodyRead(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
//        String vo = "";
//        vo = Base64Util.decodeData(vo.toString());
//        return vo;
//    }
//}
