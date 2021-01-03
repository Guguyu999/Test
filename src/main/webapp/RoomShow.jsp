<%--
  Created by IntelliJ IDEA.
  User: asua
  Date: 2020/12/31
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>宿舍信息查询展示界面</title>
        <link rel="stylesheet" type="text/css" href="css/Update.css"/>
    </head>
    <body class="body">
    <!--导航区域开始-->
    <div class="dao-area">
        <div class="user">
            <li class="message">
                <a href="Room.jsp" target="_parent">返回</a>
            </li>
        </div>
    </div>
    <!--导航区域结束-->

        <!--显示区域开始-->
        <div class="show_border">
            <div class="left-container" style="margin-top: 100px;margin-left:266px;width: 300px">
                <table cellpadding="10" cellspacing="0" class="table">
                    <tr align="center">
                        <td>寝室号:</td>
                        <td width="160px">
                            ${room.roomid}
                        </td>
                    </tr>
                    <tr align="center">
                        <td>楼房号:</td>
                        <td>
                            ${room.houseid}
                        </td>
                    </tr>
                    <tr align="center">
                        <td>卫生评比:</td>
                        <td>
                            ${room.cleanlevel}
                        </td>
                    </tr>
                    <tr align="center">
                        <td>设备报修:</td>
                        <td>
                            ${room.repairs}
                        </td>
                    </tr>
                </table>
<%--                <form style="margin-top: 30px;margin-left: 100px" action="/Studentdorm/RoomShowAllServlet">--%>
<%--                    <input type="submit" value="查看全部">--%>
<%--                </form>--%>
            </div>
        </div>
        <!--展示区域结束-->
    </body>
</html>
