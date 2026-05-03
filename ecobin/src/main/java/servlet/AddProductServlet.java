package servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;
import util.DBConnection;

@WebServlet("/addproduct")
@MultipartConfig
public class AddProductServlet extends HttpServlet {

protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{

HttpSession s=req.getSession(false);
if(s==null || s.getAttribute("sellerId")==null){
	 res.sendRedirect(req.getContextPath() + "/sellerLogin.jsp");
return;
}

try{
String name=req.getParameter("name");
double price=Double.parseDouble(req.getParameter("price"));
String condition=req.getParameter("condition");
int years=Integer.parseInt(req.getParameter("years_used"));

Part file=req.getPart("image");
String fileName=file.getSubmittedFileName();

String path=getServletContext().getRealPath("/")+"uploads";
new File(path).mkdir();
file.write(path+File.separator+fileName);

Connection con=DBConnection.getConnection();
PreparedStatement ps=con.prepareStatement(
"INSERT INTO products(name,price,condition_type,years_used,image,seller_id) VALUES(?,?,?,?,?,?)");

ps.setString(1,name);
ps.setDouble(2,price);
ps.setString(3,condition);
ps.setInt(4,years);
ps.setString(5,fileName);
ps.setInt(6,(int)s.getAttribute("sellerId"));

ps.executeUpdate();
res.sendRedirect(req.getContextPath() + "/sellerDashboard.jsp");
}catch(Exception e){e.printStackTrace();}
}
}