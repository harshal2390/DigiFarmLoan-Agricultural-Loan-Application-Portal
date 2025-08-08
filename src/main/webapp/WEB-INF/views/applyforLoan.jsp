<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Apply for Loan</title>

<!-- Bootstrap 5 CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<style>
body {
	background: #f0f2f5;
}

.form-container {
	max-width: 600px;
	margin: 50px auto;
	background: #ffffff;
	padding: 30px;
	border-radius: 16px;
	box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
}

.form-title {
	font-weight: 600;
	text-align: center;
	margin-bottom: 25px;
}

.btn-custom {
	width: 100%;
	padding: 10px;
}
</style>
</head>
<body>

	<div class="form-container">
		<h3 class="form-title">Apply for Loan</h3>
		<form action="applyLoanfarmer" method="post">
		
			<div class="mb-3">
				<label for="contact" class="form-label">enter id for loan</label>
				<input type="number" class="form-control" id="contact" name="laonid" required />
			</div>

			<div class="mb-3">
				<label for="farmerContactId" class="form-label">Farmer Contact ID</label>
				<input type="number" class="form-control" id="farmerContactId" name="farmerContactId" required />
			</div>

			<div class="mb-3">
				<label for="loanAmount" class="form-label">Loan Amount</label>
				<input type="number" class="form-control" id="loanAmount" name="loanAmount" required />
			</div>

			<div class="mb-3">
				<label for="purpose" class="form-label">Purpose</label>
				<input type="text" class="form-control" id="purpose" name="purpose" required />
			</div>

			<div class="mb-3">
				<label for="applicationDate" class="form-label">Application Date</label>
				<input type="date" class="form-control" id="applicationDate" name="applicationDate" required />
			</div>

			<div class="mb-3">
				<label for="status" class="form-label">Status</label>
				<input type="text" class="form-control" id="status" name="status" value="Pending" readonly />
			</div>

			<button type="submit" class="btn btn-primary btn-custom">Submit Loan Application</button>
		</form>
	</div>

	<!-- Bootstrap JS Bundle -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
