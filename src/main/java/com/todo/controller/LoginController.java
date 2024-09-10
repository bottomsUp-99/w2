package com.todo.controller;

import com.todo.dto.MemberDTO;
import com.todo.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebServlet(name = "loginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    //get은 로그인 화면을 보여주고 post 방식으로 실제 로그인 처리하도록 구성하도록 한다.
    //1. WebServlet 해당 컨트롤러 등록 이름 /login
    //2. doGet login.jsp 파일로 포워딩
    //3. login.jsp 파일 만들어주세요 --> text 2개 id(mid), pwd(mpw)/ 버튼은 submit

    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("todo login으로 왔습니다");
        req.getRequestDispatcher("/todo/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw"); //파리미터 수집

//        String str = mid + pwd;
//
        try {
            MemberDTO memberDTO = memberService.login(mid, mpw);
            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", memberDTO); //HttpSession을 이용해서 setAttribute()를 사용자 공간에 loginInfo라는 이름으로 문자열을 보관
            resp.sendRedirect("/todo/list"); //정상적으로 로그인된 경우에는 HttpSession을 이용해서 loginInfo이름으로 객체를 저장한다.

        } catch (Exception e) {
            resp.sendRedirect("/login?result=error");
            //예외가 발생한다면
        }
//
//        try {
//            memberService.login(mid, pwd);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }
}
