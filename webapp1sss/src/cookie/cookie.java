/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cookie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hashan
 */
@WebServlet(name = "cookie", urlPatterns = {"/cookie"})
public class cookie extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String uname = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        String secf = request.getParameter("secf");
        String hof = request.getParameter("hof");
        String cName = "login_cookie";
        String cValue = "LU4DkzJr6aloVQPw4e7";
        if (uname.equals("admin") && password.equals("admin")) {

            if (secf == null ? hof == null : secf.equals(hof)) {
                cookie ck = new cookie(cName, cValue);
                ck.setMaxAge(120);
                ck.setDomain("localhost");
                ck.setPath("/");
                ck.setSecure(false);
                ck.setHttpOnly(false);
                response.addCookie(ck);
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } else if (secf != null && hof != null) {
                if (secf.equals("sfTrue") && hof.equals("hofTrue")) {
                    cookie ck = new cookie(cName, cValue);
                    ck.setMaxAge(120);
                    ck.setDomain("localhost");
                    ck.setPath("/");
                    ck.setSecure(true);
                    ck.setHttpOnly(true);
                    response.addCookie(ck);
                    request.getRequestDispatcher("home.jsp").forward(request, response);
                }
            } else if (secf != null) {
                if (secf.equals("sfTrue") && hof == null) {
                    cookie ck = new cookie(cName, cValue);
                    ck.setMaxAge(120);
                    ck.setDomain("localhost");
                    ck.setPath("/");
                    ck.setSecure(true);
                    ck.setHttpOnly(false);
                    response.addCookie(ck);
                    request.getRequestDispatcher("home.jsp").forward(request, response);
                }
            } else if (hof != null) {
                if (hof.equals("hofTrue") && secf == null) {
                    cookie ck = new cookie(cName, cValue);
                    ck.setMaxAge(120);
                    ck.setDomain("localhost");
                    ck.setPath("/");
                    ck.setSecure(false);
                    ck.setHttpOnly(true);
                    response.addCookie(ck);
                    request.getRequestDispatcher("home.jsp").forward(request, response);
                }
            }
        } else {
            out.print("Invalid Input");
        }
    }

}
