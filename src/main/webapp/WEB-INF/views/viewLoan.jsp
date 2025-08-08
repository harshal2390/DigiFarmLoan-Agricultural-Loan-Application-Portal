<%@ page import="java.util.*"%>
<%@ page import="model.LoanAppications"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>DigiFarmLoan – Loan Applications</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<style>
/* Include the same styles as in your officer/farmer JSP for consistency */
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: 'Segoe UI', sans-serif;
	background-color: #f4f6f8;
	color: #333;
	display: flex;
	min-height: 100vh;
}

.sidebar {
	width: 220px;
	background-color: #198754;
	color: white;
	flex-shrink: 0;
	padding-top: 30px;
	position: fixed;
	top: 0;
	bottom: 0;
	left: 0;
}

.sidebar h3 {
	text-align: center;
	margin-bottom: 20px;
	font-size: 1.3rem;
}

.sidebar a {
	display: block;
	color: white;
	padding: 14px 20px;
	text-decoration: none;
	font-size: 1rem;
	transition: background 0.3s ease;
}

.sidebar a:hover {
	background-color: #157347;
}

.main-content {
	margin-left: 220px;
	width: calc(100% - 220px);
	padding: 20px;
}

header {
	background-color: #198754;
	color: #fff;
	padding: 20px;
	text-align: center;
	font-size: 1.8rem;
	letter-spacing: 1px;
	font-weight: bold;
}

.container {
	background: #fff;
	padding: 30px 40px;
	border-radius: 12px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
	margin-top: 30px;
}

h2 {
	margin-bottom: 25px;
	font-size: 1.6rem;
	color: #222;
}

table {
	width: 100%;
	border-collapse: collapse;
	border-radius: 8px;
	overflow: hidden;
}

thead {
	background-color: #20c997;
	color: white;
}

th, td {
	padding: 14px 16px;
	text-align: left;
}

tbody tr {
	border-bottom: 1px solid #e0e0e0;
}

tbody tr:nth-child(even) {
	background-color: #f9f9f9;
}

.no-data {
	text-align: center;
	padding: 20px;
	color: #777;
}

.footer {
	margin-top: 40px;
	text-align: center;
	font-size: 0.9rem;
	color: #999;
}

@media ( max-width : 768px) {
	.sidebar {
		width: 100%;
		position: relative;
	}
	.main-content {
		margin-left: 0;
		width: 100%;
	}
}
</style>
</head>
<body>

	<div class="sidebar">
		<h3>Admin Panel</h3>
		<a href="view_farmers">View Farmers</a> <a href="view_officers">View
			Officers</a> <a href="viewLoan">View Loan Applications</a> <a
			href="logout.jsp">Logout</a>
	</div>

	<div class="main-content">
		<header>DigiFarmLoan – Loan Applications</header>

		<div class="container">
			<h2>All Loan Applications</h2>

			<%
				List<LoanAppications> allLoans = (List<LoanAppications>) request.getAttribute("allLoans");
				if (allLoans != null && !allLoans.isEmpty()) {
			%>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Loan Contact ID</th>
						<th>Farmer Contact ID</th>
						<th>Loan Amount</th>
						<th>Purpose</th>
						<th>Application Date</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (LoanAppications loan : allLoans) {
					%>
					<tr>
						<td><%=loan.getContact()%></td>
						<td><%=loan.getFarmerContactId()%></td>
						<td><%=loan.getLoanAmount()%></td>
						<td><%=loan.getPurpose()%></td>
						<td><%=loan.getApplicationDate()%></td>
						<td><%=loan.getStatus()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>

			<%
				} else {
			%>
			<div class="no-data">No loan applications found.</div>
			<%
				}
			%>
		</div>

		<div class="footer">&copy; 2025 DigiFarmLoan. All rights
			reserved.</div>
	</div>

</body>
</html>
