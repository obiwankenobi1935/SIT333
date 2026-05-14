package web.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.RegistrationService;

/**
 * HTTP end-point to handle registration request.
 */
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        System.out.println("[RegistrationServlet] GET");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        System.out.println("[RegistrationServlet] POST");

        String fName    = req.getParameter("fname");
        String lName    = req.getParameter("lname");
        String username = req.getParameter("username");
        String password = req.getParameter("passwd");
        String email    = req.getParameter("email");
        String phone    = req.getParameter("phone");
        String gender   = req.getParameter("gender");
        String dob      = req.getParameter("dob");

        String regStatus = "fail";

        if (RegistrationService.register(fName, lName, username, password, email, phone, gender, dob)) {
            regStatus = "success";
        }

        String htmlResponse = "<html>";
        htmlResponse += "<head><title>" + regStatus + "</title></head>";
        htmlResponse += "<h2>Registration status: " + regStatus + "</h2>";
        htmlResponse += "</html>";

        PrintWriter writer = resp.getWriter();
        writer.println(htmlResponse);
    }
}