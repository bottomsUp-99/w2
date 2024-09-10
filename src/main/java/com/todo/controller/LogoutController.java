package com.todo.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebServlet(name = "logoutController", urlPatterns = "/logout")
public class LogoutController extends HttpServlet {

    //세션을 이용한 로그아웃
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("logout........");

        HttpSession session = req.getSession();
        session.removeAttribute("loginInfo");
        session.invalidate();//세션 종료 메서드

        resp.sendRedirect("/todo/login");
    }
}
