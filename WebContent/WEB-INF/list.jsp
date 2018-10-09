<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
	<head>
	</head>
	<table>
		<tr>
			<td>交易时间</td>
			<td>登记人</td>
		</tr>
		<c:forEach items="${AccInfos}" var="accinfo">
			<tr>
				<td>${accinfo.trade_type}</td>
				<td>${accinfo.manager}</td>
			</tr>
		</c:forEach>
	</table>
	</body>
</html>