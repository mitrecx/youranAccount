<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="entity.*,java.util.List" %>
<html>
	<head>
		<style>
			table{
				font-style:italic;
				font-size:14px;
			}
			.row1{
				background-color:#fff888;
			}
			.row2{
				background-color:#f0f0f0;
			}
		</style>
	</head>

	<body>
	<%@include file="header.jsp" %>
	<h3>账目信息</h3>
		<table border="1" width="60%" cellpadding="0" cellspacing="0">
			<tr>
				<td>ID</td>
				<td>交易时间</td>
				<td>交易类型</td>
				<td>交易商品</td>
				<td>交易方</td>
				<td>交易方联系方式</td>
				<td>用途</td>
				<td>用途详情</td>
				<td>操作人员</td>
				<td>交易金额</td>
				<td>交易商品量</td>
			</tr>
			<%
				List<AccInfo> a=(List<AccInfo>)request.getAttribute("accList");
				for(int i=0;i<a.size();i++){
					AccInfo e=a.get(i);
			%>
					<tr class="row<%= (i%2+1) %>">
						<td><%=e.getTrade_id() %></td>
						<td><%=e.getTrade_time() %></td>
						<td><%=e.getTrade_type() %></td>
						<td><%=e.getTrade_goods() %></td>
						<td><%=e.getTrader() %></td>
						<td><%=e.getContact_info() %></td>
						<td><%=e.getPurpose() %></td>
						<td><%=e.getPurpose_details() %></td>
						<td><%=e.getManager() %></td>
						<td><%=e.getAmount() %></td>
						<td><%=e.getQuantity() %></td>
					</tr>
			<%
				}
			%>
		</table>
		<a href="emp.html">添加员工</a> <br/>
		<input type="button" value="添加员工按钮" onclick="location='addEmp.jsp'"/>
	</body>
</html>