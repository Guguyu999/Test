<%--
  Created by IntelliJ IDEA.
  User: asua
  Date: 2020/12/31
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>宿舍信息添加界面</title>
        <link rel="stylesheet" type="text/css" href="css/Record.css"/>

        <script>
            function validate() {
                var roomid = document.getElementById("roomid").value;
                var  houseid = document.getElementById("houseid").value;
                var  cleanlevel = document.getElementById("cleanlevel").value;
                var  repairs = document.getElementById("repairs").value;

                //所有信息都不能为空
                if (roomid==''){
                    alert("寝室号不能为空！");
                    return false;
                }
                if (houseid==''){
                    alert("楼房号不能为空！");
                    return false;
                }
                if (cleanlevel==''){
                    alert("卫生等级不能为空！");
                    return false;
                }
                if (repairs==''){
                    alert("设备报修不能为空！");
                    return false;
                }
                return true;
            }
        </script>
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

        <!--展示区域开始-->
        <div class="show_border">
            <div class="contain" style=" width:266px;height: 266px;margin-top:100px">
                <form action="/Studentdorm/RoomRenewServlet?method=add" method="post" onsubmit="return validate()">
                    寝&nbsp;室&nbsp;号：<input type="text" name="roomid" id="roomid" placeholder="请输入寝室号" /><br />
                    楼&nbsp;房&nbsp;号：<input type="text" name="houseid" id="houseid" placeholder="请输入楼房号" /><br />
                    卫生评比：<input type="text" name="cleanlevel" id="cleanlevel" placeholder="请输入卫生等级" /><br />
                    设备报修：<input type="text" name="repairs" id="repairs" placeholder="请输入报修状态" /><br />
                    <div class="submit" style="margin-left: 116px">
                        <input type="submit" value="添加" name=""/>
                    </div>
                </form>
            </div>
        </div>
        <!--展示区域结束-->
    </body>
</html>
