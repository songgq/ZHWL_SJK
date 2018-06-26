package com.ustcsoft.jt.filter;

import com.ustcsoft.jt.util.DESUtil;
import com.ustcsoft.jt.wrapper.ResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author mapp
 * @des 拦截器  对入参，出参进行加密，解密
 * @date 2018/4/19
 */
public class ApiFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 使用我们自定义的响应包装器来包装原始的ServletResponse
        ResponseWrapper wrapper = new ResponseWrapper((HttpServletResponse)servletResponse);
        // 这句话非常重要，注意看到第二个参数是我们的包装器而不是response
        filterChain.doFilter(servletRequest, wrapper);
        String result = wrapper.getContent();
        try {
//            result = DESUtil.encrypt(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 输出最终的结果
        servletResponse.setContentLength(-1);
        servletResponse.setCharacterEncoding("UTF-8");
        PrintWriter out = servletResponse.getWriter();
        out.write(result);
        out.flush();
        out.close();
    }

    @Override
    public void destroy() {

    }
}
