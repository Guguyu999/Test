<%--
  Created by IntelliJ IDEA.
  User: asua
  Date: 2020/12/29
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>登录</title>
        <link rel="stylesheet" type="text/css" href="css/Login.css"/>
    </head>
    <body class="body">
        <div class="login_border">
            <div class="contain">
                <form action="/Studentdorm/LoginServlet" method="post">
                    用户名：<input type="text"name="username" placeholder="请输入用户名"  /><br />
                    密&nbsp;&nbsp;码：<input type="password" name="password" placeholder="请输入密码" /><br />
                    <div class="submit">
                        <input type="submit" value="登录" name="" />
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
