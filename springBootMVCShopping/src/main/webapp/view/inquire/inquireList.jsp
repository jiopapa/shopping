<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

$(function(){
	$("#inquire1").click(function(){
		window.open("inquireWrite.inq?num=${goodsNum}","문의하기",
				"width=700, height=650, top=100, left=100");
	});
});
function inquireUpdate(inquireNum){
	window.open("inquireUpdate.inq?inquireNum="+inquireNum,"문의수정",
				"width=700, height=650, top=100, left=100");
}
function inquireDelete(inquireNum){
	$.ajax({
		type:"post",
		url:"inquireDelete.inq",
		data:{"inquireNum":inquireNum},
		success:function(){
			inquire();
		},
		error : function(){
			alert('에러가 발생했습니다');
			return;
		}
	});
}
function answerOpen(inquireNum){
	if($("#inqu" + inquireNum).css('display') == 'none'){
		$("#inqu" + inquireNum).css('display','');
		$("#inqu" + inquireNum).text('답변접기')
	}else{
		$("#inqu" + inquireNum).css('display','none');
		$("#inqu" + inquireNum).text('답변열기')
	}
	
}
</script>
</head>
<body>
<table width="600" align="center" border="1">
	<tr><td colspan ="3" align="right">
	<button type="button" id="inquire1">문의하기</button>
	</td></tr>

	<tr><th width="15%"> 답변상태 </th> <th>작성자</th> <th>질문일자</th></tr>
	
	<c:forEach items="${list }" var="dto">
	<tr><th><c:if test="${empty dto.inquireAnswer }">검토중</c:if> 
	<c:if test="${!empty dto.inquireAnswer }">답변완료</c:if></th> <th>${dto.memberNum }</th> 
	<th>${dto.inquireDate }
	<c:if test="${memberNum == dto.memberNum }"><br/>
	<button type="button" onclick="inquireUpdate('${dto.inquireNum}')">수정하기</button> | 
	<button type="button" onclick="inquireDelete('${dto.inquireNum}')">삭제하기</button>
	</c:if>
	</th> </tr>
	<tr><td colspan="3">${dto.inquireKind } : ${dto.inquireSubject }
	<button type="button" id="inqu_${dto.inquireNum }" onclick="answerOpen('${dto.inquireNum }')">답변 열기</button></td></tr>
	<tr><td colspan="3">${fn:replace(dto.inquireContent, newLine, "<br />") }</td></tr>
	<c:if test="${!empty dto.inquireAnswer }">
	<tr style="dispaly:none;" id="inqu${dto.inquireNum }"><td>답변</td><td colspan="2">${dto.inquireAnswerDate }<br />
						${fn:replace(dto.inquireAnswer, newLine, "<br />") }</td></tr>
	</c:if>
	</c:forEach>
</table>

</body>
</html>