<%--
  Created by IntelliJ IDEA.
  User: leejuhwan
  Date: 2024. 9. 10.
  Time: AM 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login.jsp</title>
</head>
<body>
    <c:if test="${param.result == 'error'}">
        <h1>로그인 에러 발생</h1>
    </c:if>
    <form action="/login" method="post">
        <h1>Login Page</h1>
        <label>id<input type="text" name="mid"></label>
        <label>pwd<input type="password" name="mpw"></label>
        <button type="submit">LOGIN</button>
    </form>
</body>
</html>
