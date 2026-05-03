package servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;
import util.DBConnection;

@WebServlet("/sellerLogin")
public class SellerLoginServlet extends HttpServlet {
protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException{
try{
Connection con=DBConnection.getConnection();
PreparedStatement ps=con.prepareStatement("SELECT * FROM sellers WHERE username=? AND password=?");
ps.setString(1,req.getParameter("username"));
ps.setString(2,req.getParameter("password"));
ResultSet rs=ps.executeQuery();

if(rs.next()){
HttpSession s=req.getSession();
s.setAttribute("sellerId",rs.getInt("id"));
res.sendRedirect(req.getContextPath() + "/sellerDashboard.jsp");
}else{
res.getWriter().println("Invalid");
}
}catch(Exception e){e.printStackTrace();}
}
}