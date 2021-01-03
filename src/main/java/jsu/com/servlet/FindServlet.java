package jsu.com.servlet;

import jsu.com.bean.Student;
import jsu.com.dao.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/FindServlet")
public class FindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        // 获取前台提交的查询信息和查询条件
        String message = request.getParameter("message");
        String methond = request.getParameter("methond");

        //不同条件不同查询
        if(methond.equals("学号")){
            methond = "sno";
        }
        if(methond.equals("姓名")){
            methond = "name";
        }
        if(methond.equals("班级")){
            methond = "classgrade";
        }
        if(methond.equals("寝室")){
            methond = "roomid";
        }
        if(methond.equals("楼房")){
            methond = "houseid";
        }

        // 根据信息和查询条件查询学生信息
        StudentDAO studentDAO =new StudentDAO();

        Student student = null;
        try {
            student = studentDAO.selStuMessage(message,methond);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 判断student == null,返回当前界面，不为空，就进入信息修改界面
        if(student!=null){
            // 将当前查询到的学生信息的建立ID，保存到Session中
            String studentId = student.getId();
            request.getSession().setAttribute("SESSION_StudentID",studentId);

            // 跳转到修改信息页面，展示当前查询宿舍的信息
            student.setId(studentId);
            //信息放入请求作用域，在修改页面展示该对象信息
            request.setAttribute("student",student);
            // 请求转发到修改页面
            request.getRequestDispatcher("Update.jsp").forward(request,response);
        }else {
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('未查询到相关学生信息！请重新输入查询~');");
            writer.write("window.location.href = 'Find.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost( request,  response);
    }
}
