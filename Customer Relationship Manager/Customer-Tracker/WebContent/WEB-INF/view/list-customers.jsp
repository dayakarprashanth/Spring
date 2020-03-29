<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!Doctype html>

<html>

<Head>
	<title>List of Customers</title>
	<!-- reference to ur style sheet -->
	
	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css" />
	
</Head>

<body>

	<div id="wrapper">
	
		<div is="header">
			<h2> CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
		<!-- add a new button : Add Customer -->
		
		<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button"
				/>
		
		<!-- add our html table here -->
		
			<table>
				<tr>
					<th>First Name</th>
					<th>LastName</th>
					<th>Email</th>
				</tr>
				
				<!-- Loop over to print number of customers -->
				
				<c:forEach var="tempCustomer" items="${customers}">
				<tr>
					<td> ${tempCustomer.firstName} </td>
					<td> ${tempCustomer.lastName} </td>
					<td> ${tempCustomer.email} </td>
				</tr>
				</c:forEach>
			
			</table>
		    
		</div>
		
	</div>

</body>


</html>












