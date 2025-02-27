<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html>

<head>
	<title>
		Add Customers
	</title>
	
	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css" />

	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2> CRM - Customer Relationship Manager </h2>
			
		</div>
	</div>
	
	<div id="container">
		<h2> Adding Customer </h2>
	
	
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
	
			<!-- Need to associate this data with Customer ID -->
			<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td><label>First Name:</label> </td>
						<td><form:input path="firstName"/></td>
					</tr>
					<tr>
						<td><label>Last Name:</label> </td>
						<td><form:input path="lastName"/></td>
					</tr>
					<tr>
						<td><label>Email:</label> </td>
						<td><form:input path="email"/></td>
					</tr>
					<tr>
						<td><label></label> </td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			
			</table>
		</form:form>
		
		<div style="clear; both;"> </div>
		<p>
			<a href="${pageContext.request.contextPath}/caustomer/list"> Back to the List</a>
		</p>
		
	</div>
	
</body>




</html>