package jsu.com.servlet;

import jsu.com.bean.Room;
import jsu.com.dao.RoomDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(urlPatterns = "/RoomShowAllServlet")
public class RoomShowAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("text/html;charset=UTF-8");
        RoomDAO roomDao = new RoomDAO();
        try {
            List<Room> rooms = roomDao.selectRoom();
            request.setAttribute("Room", rooms);
            request.getRequestDispatcher("RoomShowAll.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        protected void doGet(HttpServletRequest request, HttpServletResponse response){

        doPost( request,  response);
    }
}
