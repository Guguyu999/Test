<%--
  Created by IntelliJ IDEA.
  User: asua
  Date: 2020/12/30
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>出入登记界面</title>
        <link rel="stylesheet" type="text/css" href="css/Record.css"/>

        <script>
            function validate() {
                var name = document.getElementById("name").value;
                var  starttime = document.getElementById("starttime").value;
                var  endtime = document.getElementById("endtime").value;
                var  tel = document.getElementById("tel").value;

                //姓名、访问时间、结束时间都不能为空
                if (name==''){
                    alert("姓名不能为空！");
                    return false;
                }
                if (starttime==''){
                    alert("访问时间不能为空！");
                    return false;
                }
                if (endtime==''){
                    alert("结束访问时间不能为空！");
                    return false;
                }

                //验证电话号码
                if(tel == ''){
                    alert("电话号码不能为空！");
                    return false;
                }else if(tel.length!=11){
                    alert("电话号码是11位！");
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
                    <li class="message">
                        <a href="Update.html" target="_blank">信息修改</a>
                    </li>
                    <li class="message" id="record">
                        <a href="javascript:;">出入登记</a>
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
            <div class="contain">
                <form action="/Studentdorm/RecordServlet" method="post" onsubmit="return validate()">
                    &nbsp;&nbsp;&nbsp;姓&nbsp;&nbsp;名：&nbsp;&nbsp;&nbsp;<input type="text" name="name" id="name" placeholder="请输入姓名" /><br />
                    &nbsp;来&nbsp;访&nbsp;时&nbsp;间：<input type="text" name="starttime" id="starttime" placeholder="请输入来访时间" /><br />
                    结束访问时间：<input type="text" name="endtime" id="endtime" placeholder="请输入结束访问时间" /><br />
                    &nbsp;电&nbsp;话&nbsp;号&nbsp;码：<input type="text" name="tel" id="tel" placeholder="请输入电话号码" /><br />
                    &nbsp;进&nbsp;楼&nbsp;物&nbsp;品：<input type="text" name="intoitems" placeholder="请输入进楼物品" /><br />
                    &nbsp;出&nbsp;楼&nbsp;物&nbsp;品：<input type="text" name="outitems" placeholder="请输入出楼物品" /><br />
                    <div class="submit">
                        <input type="submit" value="保存" name=""/>
                    </div>
                </form>
            </div>
        </div>
        <!--展示区域结束-->
    </body>
</html>

