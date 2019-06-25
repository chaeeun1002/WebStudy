<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th width="100">상품코드</th>
		<th width="170">상품이름</th>
		<th width="150">상품가격</th>
		<th width="100">상품원산지</th>
	</tr>
	<c:forEach var="item" begin="0" end="4">
		<tr>
			<td>${PLIST.codeList[item] }</td>
			<td><a href="ProductReadServlet?CODE=${PLIST.codeList[item] }">${PLIST.nameList[item] }</a></td>
			<td>${PLIST.priceList[item] }</td>
			<td>${PLIST.originList[item] }</td>
		</tr>
	</c:forEach>
<%-- 	<c:forEach var="item" items="${LIST }"> --%>
<!-- 		<tr> -->
<%-- 			<td width="100" align="center">${item.code }</td> --%>
<%-- 			<td width="100" align="center"><a href="ProductReadServlet?CODE=${item.code }">${item.name }</a></td> --%>
<%-- 			<td width="100" align="center">${item.price }</td> --%>
<%-- 			<td width="100" align="center">${item.origin }</td> --%>
<!-- 		</tr> -->
<%-- 	</c:forEach> --%>
</table>
<br/>
<c:forEach var="p" begin="1" end="${PAGE }">
<a href="">${p }</a>
</c:forEach>
<br/>
</body>
</html>