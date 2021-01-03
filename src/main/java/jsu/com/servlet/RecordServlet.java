package jsu.com.servlet;

import jsu.com.bean.Record;
import jsu.com.dao.RecordDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/RecordServlet")
public class RecordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        // 获取前台提交的的信息
        String name = request.getParameter("name");
        String starttime = request.getParameter("starttime");
        String endtime = request.getParameter("endtime");
        String tel = request.getParameter("tel");
        String  intoitems = request.getParameter("intoitems");
        String outitems = request.getParameter("outitems");

        // 对数据进行封装, 封装成一个对象
        Record record = new Record(null,name,starttime,endtime,tel,intoitems,outitems);

        RecordDAO recordDAO = new RecordDAO();

        // 判断是否有相同的记录
        boolean f = false;
        try {
            f = recordDAO.searchMessage(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(f){
            // 数据库中已经有相同的登记信息
            // 通过response对象给客户端一个错误提示
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('保存的登记信息已有相同的信息！请重新登记~');");
            writer.write("window.location.href = 'Record.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }else {
            // flag是否保存成功
            boolean flag = recordDAO.saveRecord(record);

            if(flag){
                // 保存成功跳转到当前页面 给出提示信息
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('登记信息保存成功！');");
                writer.write("window.location.href = 'Record.jsp'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }else {
                // 注册失败给出提示信息，也返回当前页面
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('登记信息保存成功！');");
                writer.write("window.location.href = 'Record.jsp'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        doPost( request,  response);
    }
}
