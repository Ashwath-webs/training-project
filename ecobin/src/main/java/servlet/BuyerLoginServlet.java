package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;
import util.DBConnection;

@WebServlet("/buyerLogin")
public class BuyerLoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        try {
            Connection con = DBConnection.getConnection();

            if (con == null) {
                res.getWriter().println("Database connection failed");
                return;
            }

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM buyers WHERE username=? AND password=?"
            );

            ps.setString(1, req.getParameter("username"));
            ps.setString(2, req.getParameter("password"));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                HttpSession session = req.getSession();
                session.setAttribute("buyerId", rs.getInt("id"));

             
                res.sendRedirect(req.getContextPath() + "/index.jsp");

            } else {
                res.getWriter().println("Invalid Username or Password");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}