<%@ page import="jsu.com.bean.Student" %><%--
  Created by IntelliJ IDEA.
  User: asua
  Date: 2020/12/30
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>信息修改界面</title>
        <link rel="stylesheet" type="text/css" href="css/Update.css"/>

<%--        <%--%>
<%--            Student student = (Student) request.getAttribute("student");--%>
<%--        %>--%>

        <script>
            function validate() {
                var sno = document.getElementById("sno").value;
                var  name = document.getElementById("name").value;
                var classgrade = document.getElementById("classgrade").value;
                var  roomid = document.getElementById("roomid").value;
                var  houseid = document.getElementById("houseid").value;

                //要修改的信息都为空
                if (sno==''){
                    alert("学号不能为空！");
                    return false;
                }
                if (name==''){
                    alert("姓名不能为空！");
                    return false;
                }
                if (classgrade==''){
                    alert("班级不能为空！");
                    return false;
                }if (roomid==''){
                    alert("寝室号不能为空！");
                    return false;
                }if (houseid==''){
                    alert("楼房号不能为空！");
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
                    <li class="message">
                        <a href="Find.jsp" target="_blank">信息查询</a>
                    </li>
                    <li class="message" id="update">
                        <a href="javascript:;">信息修改</a>
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

        <!--登记区域开始-->
        <div class="show_border">
            <div class="left-container">
                <lable style="color: red;margin-left: 66px;">查询到的学生信息</lable>
                <table cellpadding="10" cellspacing="0" class="table">
                    <tr align="center">
                        <td>学号:</td>
                        <td width="160px">
<%--                            <%=student.getSno()%>--%>
                            ${student.sno}
                        </td>
                    </tr>
                    <tr align="center">
                        <td>姓名:</td>
                        <td>
<%--                            <%=student.getName()%>--%>
                            ${student.name}
                        </td>
                    </tr>
                    <tr align="center">
                        <td>班级:</td>
                        <td>
<%--                            <%=student.getClassgrade()%>--%>
                            ${student.classgrade}
                        </td>
                    </tr>
                    <tr align="center">
                        <td>寝室号:</td>
                        <td>
<%--                            <%=student.getRoomid()%>--%>
                            ${student.roomid}
                        </td>
                    </tr>
                    <tr align="center">
                        <td>楼房号:</td>
                        <td>
<%--                            <%=student.getHouseid()%>--%>
                            ${student.houseid}
                        </td>
                    </tr>
                </table>
            </div>

            <div class="contain">
                <lable style="font-size: 15px;color: red;margin-left: 66px;">要修改的学生信息</lable>
                <form action="/Studentdorm/UpdateServlet" method="post" onsubmit="return validate()">
                    学&nbsp;&nbsp;号：<input type="text" name="sno" id="sno" placeholder="请输入学号" /><br />
                    姓&nbsp;&nbsp;名：<input type="text" name="name" id="name" placeholder="请输入姓名" /><br />
                    班&nbsp;&nbsp;级：<input type="text" name="classgrade" id="classgrade" placeholder="请输入班级" /><br />
                    寝室号：<input type="text" name="roomid" id="roomid" placeholder="请输入寝室号" /><br />
                    楼房号：<input type="text" name="houseid" id="houseid" placeholder="请输入楼房号" />
                    <div class="submit">
                        <input type="submit" value="修改"/>
                    </div>
                </form>
            </div>
        </div>
        <!--展示区域结束-->
    </body>
</html>