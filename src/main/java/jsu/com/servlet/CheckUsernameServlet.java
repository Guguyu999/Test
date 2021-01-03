package jsu.com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/CheckUsernameServlet")
public class CheckUsernameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");

        //用户名的正则表达式（字母开头，后面只能包含字母或数字,并且长度是4-10之间）
        String usernameRegex = "^[a-zA-Z][a-zA-Z0-9]{3,11}+$";
        PrintWriter pw = resp.getWriter();

        //判断一下，如果匹配成功返回true，失败返回false
        if(username != "" && username.matches(usernameRegex)){
            pw.print("{\"flag\":true,\"msg\":\"用户名合法\"}");
        }else{
            pw.print("{\"flag\":false,\"msg\":\"用户名不合法\"}");
        }
        pw.flush();
        pw.close();
    }
}
