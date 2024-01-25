<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <section class="container">
        <h3>Edit Product</h3>
        <p style="color: red;">${errorString}</p>

        <c:if test="${empty product}">
            <a href="productList">Quay lại</a>
        </c:if>

        <c:if test="${not empty product}">
            <form method="POST" action="${pageContext.request.contextPath}/productEdit">
                <table class="table table-bordered">
                    <tr>
                        <td>Code</td>
                        <td><input type="text" name="code" value="${product.code}" readOnly /></td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" name="name" value="${product.name}" /></td>
                    </tr>
                    <tr>
                        <td>Price</td>
                        <td><input type="text" name="price" value="${product.price}" /></td>
                    </tr>
                </table>
                <input type="submit" value="Ghi Lại" class="btn btn-success" />
            </form>
        </c:if>
    </section>

    <jsp:include page="_footer.jsp" />
</body>
</html>
