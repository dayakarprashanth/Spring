<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!Doctype html>

<html>

<Head>
<title>List of Customers</title>

</Head>

<body>

	<div id="wrapper">
	
		<div is="header">
			<h2> CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
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

</body>


</html>












