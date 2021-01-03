package jsu.com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/DemoServlet")
public class DemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String realname = req.getParameter("realname");
//        姓名的正则表达式（只能是汉字,并且长度是1-10之间）
        String realnameRegex = "^[\u4e00-\u9fa5]{0,11}$";
        PrintWriter pw = resp.getWriter();

        if(realname !="" && realname.matches(realnameRegex)){
            pw.print("{\"flag\":true,\"msg\":\"姓名合法\"}");
        }else{
            pw.print("{\"flag\":false,\"msg\":\"姓名不合法\"}");
        }
            pw.flush();
            pw.close();
    }
}
