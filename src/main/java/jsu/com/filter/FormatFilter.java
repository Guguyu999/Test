package jsu.com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {
        "/RegisterServlet",
        "/LoginServlet",
        "/RecordServlet",
        "/FindServlet",
        "/UpdateServlet",
        "/RoomServlet",
        "/RoomRenewServlet",
        "/TestServlet",
        "/DemoServlet",
        "/RoomShowAllServlet",
        "/CheckUsernameServlet",
        "/CheckNameServlet"
})
public class FormatFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        chain.doFilter(req,resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
