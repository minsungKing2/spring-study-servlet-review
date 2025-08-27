package hello.servlet.web.servletmvc;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//회원 등록 폼 - 컨트롤러
@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // /WEB-INF - 이 경로안에 JSP 가 있으면 외부에서 직접 JSP 를 호출할 수 없다. 컨트롤러를 통해서 JSP 를 호출해야 함.
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
        //dispatcher.forward(): 다른 서블릿이나 JSP 로 이동할 수 있는 기능이다. 서버 내부에서 다시 호출이 발생한다.
        //서버 내부에서 일어나는 호출이기 때문에 클라이언트는 전혀 인지하지 못한다.
    }
}
