<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1" width="600" align="center">
	
	<tr><th>번호</th><th>문의제목</th><th>제품번호</th></tr>
	<c:forEach items="${dtos }" var="dto" varStatus="status" >
	<tr><td>${status.count }</td>
	<td><a href="inquireAnswer.inq?inquireNum=${dto.inquireNum}"> ${dto.inquireKind} : ${dto.inquireSubject }</a></td>
	<td>${dto.goodsNum }</td></tr>
	</c:forEach>


</table>

</body>
</html>