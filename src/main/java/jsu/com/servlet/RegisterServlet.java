package jsu.com.servlet;

import jsu.com.bean.User;
import jsu.com.dao.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        // 获取前台提交的注册的信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String realname = request.getParameter("realname");
        String sex = request.getParameter("sex");
        String  Age = request.getParameter("Age");

        Integer age = Integer.valueOf(Age);
        // 对数据进行封装, 封装成一个对象
        User user = new User(null, username, password, realname, sex, age);

        UserDAO userDAO =new UserDAO();

        // 判断是否有相同的用户名
        Integer count = userDAO.selectUserCount(username);
        if(count>0){
            // 数据库中已经有相同的用户名的用户
            // 通过response对象给客户端一个错误提示
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('申请注册的用户名已经被占用！请重新注册~');");
            writer.write("window.location.href = 'Register.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }else {
            // flag是否注册成功
            boolean flag = userDAO.saveUser(user);

            if(flag){
                // 注册成功就跳转到登录页面   重定向
                response.sendRedirect("/Studentdorm/Login.jsp");
            }else {
                // 注册失败就返回注册页面   请求转发
                RequestDispatcher dispatcher = request.getRequestDispatcher("/Register.jsp");
                dispatcher.forward(request,response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost( request,  response);
    }
}
