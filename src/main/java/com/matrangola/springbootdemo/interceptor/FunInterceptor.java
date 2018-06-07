package com.matrangola.springbootdemo.interceptor;

import com.matrangola.springbootdemo.controller.rest.Counter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FunInterceptor implements HandlerInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(FunInterceptor.class);

    @Autowired
    Counter counter;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        counter.increment();
        LOG.debug("preHandle request {} {}", counter.getCount(), request.getPathInfo());
        try {
            if (true) throw new Exception("bad");
        }
        catch (Exception e) {
            LOG.error("WTF", e);
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        counter.increment();
        LOG.debug("postHandle request {} {}", counter.getCount(), request.getPathInfo());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        counter.increment();
        LOG.debug("afterCompletion request {} {}", counter.getCount(), request.getPathInfo());

    }
}
