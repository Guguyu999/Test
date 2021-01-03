package jsu.com.servlet;

import jsu.com.bean.Student;
import jsu.com.dao.StudentDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        // 获取要修改的的信息
        String sno = request.getParameter("sno");
        String name = request.getParameter("name");
        String classgrade = request.getParameter("classgrade");
        String roomid = request.getParameter("roomid");
        String houseid = request.getParameter("houseid");

        Student student = new Student(sno,name,classgrade,roomid,houseid);
        StudentDAO studentDAO =new StudentDAO();
        // 从session中取出学生ID
        String id = (String)request.getSession().getAttribute("SESSION_StudentID");

        // 更新学生信息数据
        boolean flag = StudentDAO.updateStudent(student,id);
        if(flag){
            // 通过response对象给客户端一个提示
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('信息修改成功！');");
            writer.write("window.location.href = 'Find.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }else {
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('信息修改失败！');");
            writer.write("window.location.href = 'Find.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        doPost( request,  response);
    }
}
