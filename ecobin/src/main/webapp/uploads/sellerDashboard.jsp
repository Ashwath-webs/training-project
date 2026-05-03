<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<%
if(session.getAttribute("sellerId")==null){
response.sendRedirect("sellerLogin.jsp");
}
%>

<h2>Seller Dashboard</h2>
<a href="addProduct.jsp">Add Product</a>
<a href="logout.jsp">Logout</a>