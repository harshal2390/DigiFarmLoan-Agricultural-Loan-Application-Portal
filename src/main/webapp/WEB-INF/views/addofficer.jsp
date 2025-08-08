<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Add Officer</title>

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
		<h3 class="form-title">Add New Officer</h3>
		<form action="addofficer" method="post">
			<div class="mb-3">
				<label for="contact" class="form-label">Contact Number</label> <input
					type="number" class="form-control" id="contact" name="contact"
					required />
			</div>

			<div class="mb-3">
				<label for="name" class="form-label">Officer Name</label> <input
					type="text" class="form-control" id="name" name="name" required />
			</div>

			<div class="mb-3">
				<label for="bankName" class="form-label">Bank Name</label> <input
					type="text" class="form-control" id="bankName" name="bankName"
					required />
			</div>

			<div class="mb-3">
				<label for="email" class="form-label">Email Address</label> <input
					type="text" class="form-control" id="email" name="email" required />
			</div>

			<div class="mb-3">
				<label for="password" class="form-label">Create Password</label> <input
					type="text" class="form-control" id="password" name="password"
					required />
			</div>

			<button type="submit" class="btn btn-primary btn-custom">Add
				Officer</button>
		</form>
	</div>

	<!-- Bootstrap JS Bundle (optional if you have any interactive components) -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
