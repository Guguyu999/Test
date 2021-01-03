<%--
  Created by IntelliJ IDEA.
  User: asua
  Date: 2020/12/30
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>信息查询界面</title>
        <link rel="stylesheet" type="text/css" href="css/Find.css"/>

        <script>
            function validate() {
                var message = document.getElementById("message").value;
                var  methond = document.getElementById("methond").value;

                //要搜索的信息不能为空
                if (message==''){
                    alert("查询的信息不能为空！");
                    return false;
                }

                //验证查询条件
                if(methond == ''){
                    alert("查询条件不能为空！");
                    return false;
                }else if(!(methond=="学号"||methond=="姓名"||methond=="班级"||methond=="寝室"||methond=="楼房")){
                    alert("查询条件错误！！条件必须是：<<学号、姓名、班级、寝室、楼房>>  这些其一！");
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body class="body">
        <!--导航区域开始-->
        <div class="dao-area">
            <div class="container">
                <ul class="menu">
                    <li class="message">
                        <a href="Room.jsp" target="_blank">宿舍管理</a>
                    </li>
                    <li class="message"  id="find">
                        <a href="javascript:;">信息查询</a>
                    </li>
                    <li class="message">
                        <a href="Update.html" target="_blank">信息修改</a>
                    </li>
                    <li class="message">
                        <a href="Record.jsp" target="_blank">出入登记</a>
                    </li>
                </ul>
            </div>
            <div class="user">
                <li class="message">
                    <a href="Index.html" target="_blank">个人中心</a>
                </li>
            </div>
        </div>
        <!--导航区域结束-->

        <!--展示区域开始-->
        <div class="show_border">
            <div class="contain">
                <form action="/Studentdorm/FindServlet" method="post" onsubmit="return validate()">
                    <input style="width: 200px;height: 26px;margin-left: 60px;" type="text" placeholder="请输入要查询的信息" name="message" id="message" /><br /><br />
                    <input style="width: 200px;height: 26px;margin-left: 60px;" type="text" placeholder="请输入查询条件" name="methond" id="methond" />
                    <div class="tips">
                        <span style="color:black;margin-left: 56px">按什么查询的查询条件有：</span><br />
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学号、姓名、班级、寝室、楼房<br /><br />
                        Tips：<i>输入要查询的信息，然后输入查询条件！</i>
                    </div>
                    <div class="submit">
                        <input type="submit" value="开始查询" name="" />
                    </div>
                </form>
            </div>
        </div>
        <!--展示区域结束-->
    </body>
</html>

