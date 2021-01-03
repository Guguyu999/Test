<%--
  Created by IntelliJ IDEA.
  User: asua
  Date: 2021/1/1
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>测试Ajax请求</title>
        <script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
    </head>
    <body>
    <form action="/Studentdorm/TestServlet" method="post">
        <p>
            用户名：<input id="username" name="username" value="" type="text">
            <span id="info" style="font-family: 幼圆;font-size: 15px;color: red">

            </span>
            <br />
            <span style="font-family: 幼圆;font-size: 10px;color: blue">
                Tips：<i>用户名只能是字母开头，后面只能包含字母或数字</i>
            </span>
            <br />
            姓名：<input id="realname" name="realname" value="" type="text">
            <span id="tips" style="font-family: 幼圆;font-size: 15px;color: red">

            </span>
            <br />
            <span style="font-family: 幼圆;font-size: 10px;color: blue">
                Tips：<i>姓名只能是汉字</i>
            </span>
            <br />
            密码：<input type="password" id="password" name="password" value=""><br />
            <input type="button" value="提交">
        </p>
    </form>
    <script>
        $(function () {
            //验证用户名
            $('#realname').click(function () {
                var username = $('#username').val();
                var url = '/Studentdorm/TestServlet';
                $.ajax({
                    async:true,
                    contentType:"application/x-www-form-urlencoded",
                    data:"username="+username,
                    dataType:"text",
                    type:"GET",
                    url:url,
                    error:function (xhr,statusText,e) {
                        console.log(statusText);
                    },
                    success:function (data) {
                        var json = JSON.parse(data);
                        $('#info').text(json.msg);
                    }
                });
            });

            //验证姓名
            $('#password').click(function () {
                var realname = $('#realname').val();
                var url = '/Studentdorm/DemoServlet';
                $.ajax({
                    async:true,
                    contentType:"application/x-www-form-urlencoded",
                    data:"realname="+realname,
                    dataType:"text",
                    type:"GET",
                    url:url,
                    error:function (xhr,statusText,e) {
                        console.log(statusText);
                    },
                    success:function (data) {
                        var json = JSON.parse(data);
                        $('#tips').text(json.msg);
                    }
                });
            });
        })
    </script>
    </body>
</html>
