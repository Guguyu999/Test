package jsu.com.servlet;

import jsu.com.dao.UserDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/IndexServlet")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        // 获取修改的密码的信息
        String password = request.getParameter("password");

        UserDAO userDAO =new UserDAO();
        // 从session中取出简历ID
        String id = (String)request.getSession().getAttribute("SESSION_UserID");

        // 更新用户信息数据
        boolean flag = userDAO.updatePsd(password,id);
        if(flag){
            // 通过response对象给客户端一个提示
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('密码修改成功！请重新登录~');");
            writer.write("window.location.href = 'Login.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }else {
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('密码与原密码相同，修改失败！');");
            writer.write("window.location.href = 'Index.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {

        doPost( request,  response);
    }
}
