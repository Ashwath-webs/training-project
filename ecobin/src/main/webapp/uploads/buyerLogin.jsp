<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<form action="<%=request.getContextPath()%>/buyerLogin" method="post">
<input name="username" required>
<input type="password" name="password" required>
<button>Login</button>
</form>
<a href="buyerRegister.jsp">Register</a>