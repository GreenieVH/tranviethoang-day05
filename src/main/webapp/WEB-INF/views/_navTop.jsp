<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<style>
*{
	margin:0;
	padding:0;
}
nav{
	background-color: #35785;
}
nav ul{
	display: flex;
	justify-content: flex-start;
	align-items: center;
	list-style: none;
}
nav ul li a{
	color: #fff;
	display: block;
	padding: 1rem;
	text-decoration: none;
}
nav ul li:first-child a{
	padding-left: 0 !important;
	}
nav ul li a:hover{
	color :yelLow;
}
</style>

<nav>
<ul class="container">
<li>
<a href="${pageContext.request.contextPath}/home">
	Home</a></li>
<li>
<a href="${pageContext.request.contextPath}/productList">
Product List</a></li>
<li> <a href="${pageContext.request.contextPath}/userList">
User List</a>
</ul >
</nav>