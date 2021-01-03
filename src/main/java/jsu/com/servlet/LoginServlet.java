package jsu.com.servlet;

import jsu.com.bean.User;
import jsu.com.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        // 获取前台提交的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 根据用户名和密码查询申请人
        UserDAO userDAO =new UserDAO();

        User user = null;
        try {
            user = userDAO.NameAndPsd(username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 判断user == null,返回登录界面，不为空，就进入主页面
        if(user!=null){
            // 将当前登录用户的建立ID，保存到Session中
            String userId = user.getId();
            request.getSession().setAttribute("SESSION_UserID",userId);

            // 跳转到主页面，展示当前登录用户的信息
            user.setId(userId);
            //信息放入请求作用域，在主页面展示该对象信息
            request.setAttribute("user",user);
            // 请求转发到主页面
            request.getRequestDispatcher("Index.jsp").forward(request,response);
        }else {
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('用户名或密码错误！请重新登录~');");
            writer.write("window.location.href = 'Login.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
    }
}