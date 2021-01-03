package jsu.com.servlet;

import jsu.com.bean.Room;
import jsu.com.dao.RoomDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/RoomServlet")
public class RoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        // 获取前台提交的操作形式
        String message = request.getParameter("message");
        String methond = request.getParameter("methond");

        //不同操作，不同执行
        if(methond.equals("添加")){
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('进入添加宿舍信息界面！');");
            writer.write("window.location.href = 'RoomAdd.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
        if(methond.equals("删除")){
            RoomDAO roomDAO =new RoomDAO();
            // 更新用户信息数据
            boolean flag = false;
            try {
                flag = roomDAO.deleteRoom(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(flag){
                // 通过response对象给客户端一个提示
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('信息删除成功！');");
                writer.write("window.location.href = 'Room.jsp'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }else {
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert(' 信息删除失败！');");
                writer.write("window.location.href = 'Room.jsp'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        }
        if(methond.equals("查询")||methond.equals("修改")){
            // 根据寝室号和查询条件查询寝室信息
            RoomDAO roomDAO =new RoomDAO();

            Room room = null;
            try {
                room = roomDAO.selRoomMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 判断room == null,返回当前界面，不为空，就进入宿舍信息展示界面
            if(room!=null){
                if(methond.equals("查询")){
                    //信息放入请求作用域，在宿舍信息展示页面展示该对象信息
                    request.setAttribute("room",room);
                    // 请求转发到展示页面
                    request.getRequestDispatcher("RoomShow.jsp").forward(request,response);
                }
                if(methond.equals("修改")){
                    // 将当前查询到的宿舍信息的建立ID，保存到Session中
                    String roomId = room.getId();
                    request.getSession().setAttribute("SESSION_RoomID",roomId);

                    // 跳转到宿舍信息修改页面，展示当前查询到的寝室的信息
                    room.setId(roomId);
                    //信息放入请求作用域，在宿舍信息修改页面展示该对象信息
                    request.setAttribute("room",room);
                    // 请求转发到宿舍修改信息页面
                    request.getRequestDispatcher("RoomUpdate.jsp").forward(request,response);
                }

            }else {
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('未查询到相关宿舍信息！请重新输入寝室号~');");
                writer.write("window.location.href = 'Room.jsp'");
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
