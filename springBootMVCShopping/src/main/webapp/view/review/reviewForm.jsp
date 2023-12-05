<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 리뷰 작성 <br />
 <form action="reviewWrite.review" method="post">
 <input type="hidden" name="purchaseNum" value="${purchaseNum }">
 <input type="hidden" name="goodsNum" value="${goodsNum }">
 후기 내용 : <textarea rows="5" cols="60" name="reviewContent" > </textarea><br />
 <input type="submit" value="작성완료">
</form>
</body>
</html>