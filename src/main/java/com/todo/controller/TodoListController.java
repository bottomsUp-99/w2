package com.todo.controller;

import com.todo.dto.TodoDTO;
import com.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Log4j2
@WebServlet(name = "todoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        List<TodoDTO> dtoList = TodoService.INSTANCE.getList();
//        req.setAttribute("dtolist",dtoList);
        log.info("todo...list야...잘 왔수꽝");
//        req.getRequestDispatcher("/todo/list.jsp").forward(req,resp);
        try{
            List<TodoDTO> dtoList = todoService.listAll();
            req.setAttribute("dtoList", dtoList);
            req.getRequestDispatcher("/todo/list.jsp").forward(req,resp);
        } catch (Exception e){
            log.error(e.getMessage());
            throw new ServletException("List Error");
        }
    }


}
