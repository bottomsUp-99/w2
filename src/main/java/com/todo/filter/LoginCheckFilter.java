package com.todo.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebFilter(urlPatterns = {"/todo/*"})
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //Filter 인터페이스의 doFilter 추상 메서드는 필터링이 필요한 로직을 구현하는 메서드이다.
        //필터를 적용하기 위해서는 @WebFilter 어노테이션 처리 필수
        //@WebFilter(urlPatterns = {"/todo/*"}) 지정한 /todo/경로를 지정해서 해당경로의 요청(request)에 대해서 doFilter를 실행한다.
        //LoginCheckFilter 는 /todo/* 지정되어 브라우저 /todo/... 시작하는 모든 경로에 대해서 필터링을 시도하겠다.

        log.info("LoginCheckFilter이다");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        if (session.getAttribute("loginInfo") == null) {
            resp.sendRedirect("/login");
            return;
        }
        filterChain.doFilter(req, resp); //다음 필터나 목적지(servlet, jsp)로 갈 수 있도록 Filterchain의 doFilter()를 실행한다.
    }
}
