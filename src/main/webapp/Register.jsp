<%--
  Created by IntelliJ IDEA.
  User: asua
  Date: 2020/12/29
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>注册</title>
        <link rel="stylesheet" type="text/css" href="css/Register.css"/>
        <script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>

        <script>
            function validate() {
                var username = document.getElementById("username").value;
                var  password = document.getElementById("password").value;
                var  realname = document.getElementById("realname").value;
                var  age = document.getElementById("age").value;
                var info = document.getElementById("info").innerText;
                var  tips = document.getElementById("tips").innerText;
                console.log(typeof tips);
                if (info!="用户名合法"){
                    alert("用户名不合法！请重新命名~");
                    return false;
                }
                if (tips!="姓名合法"){
                    alert("姓名不合法！请重新命名~");
                    return false;
                }

                //用户名、真实姓名、年龄都不能为空
                if (username==''){
                    alert("用户名不能为空！");
                    return false;
                }
                if (realname==''){
                    alert("姓名不能为空！");
                    return false;
                }
                if (age==''){
                    alert("年龄不能为空！");
                    return false;
                }

                //验证密码
                if(password == ''){
                    alert("密码不能为空！");
                    return false;
                }else if(password.length<6||password.length>12){
                    alert("密码要在6~12位之间！");
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body class="body">
        <div class="register_border">
            <div class="contain">
                <form action="/Studentdorm/RegisterServlet" method="post" onsubmit="return validate()">
                    用户名：<input type="text" name="username" id="username" placeholder="请输入用户名" />
                    <span id="info" style="font-family: 幼圆;font-size: 12px;color: red">

                    </span>
                    <br />
                    <span style="font-family: 幼圆;font-size: 10px;color: blueviolet">
                        Tips：<i>用户名只能是字母开头，后面只能包含字母或数字</i>
                    </span>
                    <br />
                    密&nbsp;&nbsp;码：<input type="password" name="password" id="password" placeholder="请输入密码" /><br />
                    姓&nbsp;&nbsp;名：<input type="text" name="realname" id="realname" placeholder="请输入姓名" />
                    <span id="tips" style="font-family: 幼圆;font-size: 12px;color: red">

                    </span>
                    <br />
                    <span style="font-family: 幼圆;font-size: 10px;color: blueviolet">
                        Tips：<i>姓名只能是汉字</i>
                    </span>
                    <br />
                    性&nbsp;&nbsp;别：
                    <input type="radio" name="sex" value="男" checked="checked" />男
                    <input type="radio" name="sex" value="女" />女<br />
                    年&nbsp;&nbsp;龄：<input type="text" name="Age" id="age" placeholder="请输入年龄" /><br />
                    <div class="submit">
                        <input type="submit" value="注册" name=""/>
                    </div>
                </form>
                <script>
                    $(function () {
                        //验证用户名
                        $('#password').click(function () {
                            var username = $('#username').val();
                            var url = '/Studentdorm/CheckUsernameServlet';
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
                        $('#age').click(function () {
                            var realname = $('#realname').val();
                            var url = '/Studentdorm/CheckNameServlet';
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
            </div>
        </div>
    </body>
</html>
