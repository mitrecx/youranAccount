<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<html>
	<head>
	</head>
	
	<body style="font-size: 30px;">
		<%! 
			int i=100; 
			int sum(int a,int b){
				return a+b;
			}
		
		%>
		<%= i+1 %><br/>
		<%= sum(1,1) %>
	</body>
</html>