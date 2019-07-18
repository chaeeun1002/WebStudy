<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th width="100" height="70">��ǰ�ڵ�</th>
		<th width="120">��ǰ��</th>
		<th width="120">��ǰ����</th>
		<th width="100">������</th>
		<th></th>
	</tr>
	<c:forEach var="item" begin="0" end="${ITEMLIST.listSize - 1 }">
		<tr>
			<td align="center" height="50">${ITEMLIST.codeList[item] }</td>
			<td align="center"><a href="ItemReadServlet?CODE=${ITEMLIST.codeList[item] }">${ITEMLIST.nameList[item] }</a></td>
			<td align="center">${ITEMLIST.priceList[item] }</td>
			<td align="center">${ITEMLIST.originList[item] }</td>
			<td align="center"><a href="#" onClick="window.open('AddCartServlet?CODE=${ITEMLIST.codeList[item] }','addCard','width=450, height=200'),focus()">��ٱ��� ���</a></td>
		</tr>
	</c:forEach>
</table>
<br/><br/>
<c:if test="${!ITEMLIST.firstPage }">
<a href="ItemListServlet?FIRST_PAGE=${ITEMLIST.codeList[0] }">���� ������</a>
</c:if>
<c:forEach var="p" begin="1" end="${PAGE }">
<a href="ItemListServlet?PAGE=${p }">${p }</a>
</c:forEach>
<c:if test="${!ITEMLIST.lastPage }">
<a href="ItemListServlet?LAST_PAGE=${ITEMLIST.codeList[ITEMLIST.listSize - 1] }">���� ������</a>
</c:if>
</body>
</html>