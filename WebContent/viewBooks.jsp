<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Domain.Book"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Books</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"/>
</head>
<body>
	<div class="container">
		<h1>View Books</h1>
		<table class="table table-borded table-striped">
			<tr><th>ISBN</th><th>Title</th><th>Author</th><th>Price</th><th>Add to Cart</th>
			<% for (Book b : (List<Book>)request.getAttribute("books")) {%>
			<form action="cart" method="post">
				<tr><td><%=b.getIsbn()%></td>
					<td><%=b.getTitle()%></td>
					<td><%=b.getAuthor()%></td>
					<td><%=b.getPrice()%></td>
					<td colspan="2" align="center">
						<button type="submit" name="isbn" value=<%=b.getIsbn()%> class="btn btn-default">
							Add to Cart
						</button>
					</td>
				</tr>
			</form>
			<%}%>
		</table>
	</div>
</body>
</html>