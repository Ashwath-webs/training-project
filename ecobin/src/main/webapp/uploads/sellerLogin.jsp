<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<form action="<%=request.getContextPath()%>/sellerLogin" method="post">
<input name="username" required>
<input type="password" name="password" required>
<button>Login</button>
</form>
<a href="sellerRegister.jsp">Register</a>