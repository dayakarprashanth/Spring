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
					<th>Action</th>
				</tr>
				
				<!-- Loop over to print number of customers -->
				
				<c:forEach var="tempCustomer" items="${customers}">
				
				<!-- Construct an "update" link with Customer ID -->
				
				<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="customerId" value="${tempCustomer.id}" />
		
				</c:url>
				<!-- Construct an "delete" link with Customer ID -->
				<c:url var="deleteLink" value="/customer/delete"> 
					<c:param name="customerId" value="${tempCustomer.id}" />
				
				</c:url>
				
				<tr>
					<td> ${tempCustomer.firstName} </td>
					<td> ${tempCustomer.lastName} </td>
					<td> ${tempCustomer.email} </td>
					<td> 
						<!-- Display the Update Link -->
						<a href="${updateLink}">Update</a> 
						|
						<!-- Using java script code to prompt the alert message -->
						<a href="${deleteLink}"
						onclick= "if(!(confirm('Are you sure you want to delete the Customer?')))return false">Delete</a>
					</td>			
				</tr>
				</c:forEach>
			
			</table>
		    
		</div>
		
	</div>

</body>


</html>












