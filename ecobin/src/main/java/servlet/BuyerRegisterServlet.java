package servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;
import util.DBConnection;

@WebServlet("/buyerRegister")
public class BuyerRegisterServlet extends HttpServlet {
protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException{
try{
Connection con=DBConnection.getConnection();
PreparedStatement ps=con.prepareStatement("INSERT INTO buyers(username,password) VALUES(?,?)");
ps.setString(1,req.getParameter("username"));
ps.setString(2,req.getParameter("password"));
ps.executeUpdate();
res.sendRedirect(req.getContextPath() + "/buyerLogin.jsp");
}catch(Exception e){e.printStackTrace();}
}
}