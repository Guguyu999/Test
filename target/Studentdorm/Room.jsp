<%--
  Created by IntelliJ IDEA.
  User: asua
  Date: 2020/12/30
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>宿舍管理界面</title>
        <link rel="stylesheet" type="text/css" href="css/Find.css"/>

        <script>
            function validate() {
                var methond = document.getElementById("methond").value;
                var message = document.getElementById("message").value;

                //执行的操作不能为空
                if (methond==''){
                    alert("要执行的操作不能为空！");
                    return false;
                }else if(!(methond=="添加"||methond=="删除"||methond=="查询"||methond=="修改")){
                    alert("执行操错误！！操作必须是：<<添加、删除、查询、修改>>  这些其一！");
                    return false;
                }

                if(methond=="查询"||methond=="删除"||methond=="修改"){
                    //输入的内容不能为空
                    if (message==''){
                        alert("查询的寝室号不能为空！");
                        return false;
                    }
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
                        <a style="font-weight: bold;color: #000;" href="javascript:;">宿舍管理</a>
                    </li>
                    <li class="message">
                        <a href="Find.jsp" target="_blank">信息查询</a>
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
            <div style="margin-top: 0px;height: 300px border: 1px solid red" class="contain">
                <form style="margin-top: 66px;margin-left: 10px" action="/Studentdorm/RoomServlet" method="post" onsubmit="return validate()">
                    <input style="width: 200px;height: 26px;margin-left: 60px;" type="text" placeholder="请输入要执行的操作" name="methond" id="methond" /><br />
                    <div class="tips" style="height: 166px;">
                        <span style="color:black;margin-left: 86px">可以执行的操作有：</span><br />
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i>添加、删除、查询、修改</i><br /><br />
                        -------------------------------------------
                        <span style="color:black;margin-left: 56px">执行查询、删除或者修改操作时<br />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请输入要查询的寝室号</span><br /><br />
                    </div>
                    <input style="width: 200px;height: 26px;margin-left: 60px;" type="text" placeholder="请输入要查询的寝室号" name="message" id="message" /><br /><br />
                    <div class="submit" style="margin-left: 16px">
                        <input type="submit" value="确定" name="" />
                    </div>
                </form>
                <form style="margin-top: 36px;margin-left: 100px" action="/Studentdorm/RoomShowAllServlet">
                    <input type="submit" value="查看全部宿舍信息">
                </form>
            </div>
        </div>
        <!--展示区域结束-->
    </body>
</html>


