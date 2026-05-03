<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<form action="<%=request.getContextPath()%>/sellerRegister" method="post">
<input name="username" required>
<input type="password" name="password" required>
<button>Register</button>
</form>
<a href="sellerLogin.jsp">Login</a>