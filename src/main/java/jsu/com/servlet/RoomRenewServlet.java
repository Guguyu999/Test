package jsu.com.servlet;

import jsu.com.bean.Room;
import jsu.com.dao.RoomDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/RoomRenewServlet")
public class RoomRenewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String method = request.getParameter("method");

        // 添加建立信息
        if("add".equals(method)){
            // 获取页面参数
            String roomid = request.getParameter("roomid");
            String houseid = request.getParameter("houseid");
            String cleanlevel = request.getParameter("cleanlevel");
            String repairs = request.getParameter("repairs");

            // 封装对象
            Room room = new Room(null,roomid,houseid,cleanlevel,repairs);

            RoomDAO roomDAO = new RoomDAO();
            // 判断是否有相同的寝室
            Integer count = roomDAO.selectUserCount(roomid);
            if(count>0){
                // 数据库中已经有相同的的寝室
                // 通过response对象给客户端一个错误提示
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('添加的寝室信息已经被存在！请重新添加~');");
                writer.write("window.location.href = 'RoomAdd.jsp'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }else {
                // flag是否添加成功
                boolean flag = roomDAO.saveRoom(room);

                if(flag){
                    PrintWriter writer = response.getWriter();
                    writer.write("<script>");
                    writer.write("alert('添加成功！');");
                    writer.write("window.location.href = 'Room.jsp'");
                    writer.write("</script>");
                    writer.flush();
                    writer.close();
                    // 添加成功就跳转到宿舍管理页面   重定向
                    response.sendRedirect("/Studentdorm/Room.jsp");
                }else {
                    // 添加失败就返回当前页面   请求转发
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/RoomAdd.jsp");
                    dispatcher.forward(request,response);
                }
            }
        }
        //修改信息
        if("update".equals(method)){
            // 获取页面参数
            String name = request.getParameter("name");
            String message = request.getParameter("message");

            if(name.equals("寝室号")){
                name="roomid";
            }
            if(name.equals("楼房号")){
                name="houseid";
            }
            if(name.equals("卫生等级")){
                name="cleanlevel";
            }
            if(name.equals("设备报修")){
                name="repairs";
            }
            RoomDAO roomDAO =new RoomDAO();
            // 从session中取出寝室ID
            String id = (String)request.getSession().getAttribute("SESSION_RoomID");

            // 更新用户信息数据
            boolean flag = roomDAO.updateRoom(name,message,id);
            if(flag){
                // 数据库中已经了用户的密码
                // 通过response对象给客户端一个提示
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('信息修改成功！');");
                writer.write("window.location.href = 'Room.jsp'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }else {
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('信息修改失败！');");
                writer.write("window.location.href = 'RoomUpdate.jsp'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost( request,  response);
    }
}
