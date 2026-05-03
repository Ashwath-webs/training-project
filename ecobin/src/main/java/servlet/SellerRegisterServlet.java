package servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;
import util.DBConnection;

@WebServlet("/sellerRegister")
public class SellerRegisterServlet extends HttpServlet {
protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException{
try{
Connection con=DBConnection.getConnection();
PreparedStatement ps=con.prepareStatement("INSERT INTO sellers(username,password) VALUES(?,?)");
ps.setString(1,req.getParameter("username"));
ps.setString(2,req.getParameter("password"));
ps.executeUpdate();
res.sendRedirect(req.getContextPath() + "/sellerLogin.jsp");
}catch(Exception e){e.printStackTrace();}
}
}