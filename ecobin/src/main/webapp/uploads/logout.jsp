<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<%
session.invalidate();
response.sendRedirect("sellerLogin.jsp");
%>