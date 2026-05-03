<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<form action="<%=request.getContextPath()%>/addProduct" method="post" enctype="multipart/form-data">
<input name="name" placeholder="Product Name" required>
<input name="price" placeholder="Price" required>
<input name="years_used" placeholder="Years Used">
<select name="condition">
<option>Working</option>
<option>Scrap</option>
</select>
<input type="file" name="image">
<button>Add</button>
</form>