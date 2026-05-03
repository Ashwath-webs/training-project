<%@ page import="java.sql.*, util.DBConnection" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">

<div class="navbar">
    <h3>EcoBin</h3>
    <a href="buyerLogin.jsp">Buyer</a>
    <a href="sellerLogin.jsp">Seller</a>
</div>

<div class="main-container">
<h2>Products</h2>

<%
try {
    Connection con = DBConnection.getConnection();

    if (con != null) {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM products");

        while (rs.next()) {
%>

<div class="card">
    <img src="uploads/<%=rs.getString("image")%>" width="100" height="100">

    <h5><%=rs.getString("name")%></h5>

    <p>Condition: <%=rs.getString("condition_type")%></p>

    <p>Years Used: <%=rs.getInt("years_used")%></p>

    <p class="price"><%=rs.getDouble("price")%></p>
</div>

<%
        }
    } else {
        out.println("Database connection failed");
    }
} catch (Exception e) {
    out.println("Error: " + e.getMessage());
}
%>

</div>