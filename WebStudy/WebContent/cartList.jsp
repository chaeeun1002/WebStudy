<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th width="100">상품코드</th>
		<th width="100">상품이름</th>
		<th width="100">상품가격</th>
		<th width="100">상품갯수</th>
		<th width="100">결제금액</th>
		<th width="100">수정/삭제</th>
	</tr>
	<c:forEach var="cart" items="${CARTLIST }">
	<form action="ModifyCartServlet" method="post">
		<input type="hidden" name="CODE" value="${cart.code }"/>
		<tr height="70">
			<td align="center">${cart.code }</td>
			<td align="center">${cart.name }</td>
			<td align="center">
				<fmt:formatNumber groupingUsed="true">${cart.price }</fmt:formatNumber>원
			</td>
			<td align="center"><input type="text" name="NUM" size="10" value="${cart.num }"></td>
			<td align="center">
				<fmt:formatNumber groupingUsed="true">${cart.price * cart.num }</fmt:formatNumber>원
			</td>
			<td align="center">
				<input type="submit" value="수정" name="BTN"/>
				<input type="submit" value="삭제" name="BTN"/>
			</td>
		</tr>
	</form>
	</c:forEach>
	<form action="" method="post">
		<table>
			<tr>
				<td>총 결제금액 : </td>
				<td>
					<fmt:formatNumber groupingUsed="true">${TOTAL }</fmt:formatNumber>원
				</td>
				<td><input type="submit" value="결제하기"/></td>
			</tr>
		</table>
	</form>
</table>
</script>
</body>
</html>