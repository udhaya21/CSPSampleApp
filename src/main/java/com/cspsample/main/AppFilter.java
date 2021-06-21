package com.cspsample.main;

import com.cspsample.utilities.Commons;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String nonceVal = "";
        if (response instanceof HttpServletResponse) {

            nonceVal = Commons.generateNonce();
            String cspContentWithNonce = Commons.CSP_CONTENT.replace("{nonce_value}", nonceVal);
            ((HttpServletResponse) response).setHeader("Content-Security-Policy", cspContentWithNonce);

            if (request instanceof HttpServletRequest) {
                request.setAttribute(Commons.CSP_NONCE_ATTRIBUTE, nonceVal);
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
