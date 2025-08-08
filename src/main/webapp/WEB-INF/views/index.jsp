<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Loan Management – Login/Register</title>

  <!-- Bootstrap & Icons -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet" />
  <link href="https://fonts.googleapis.com/css2?family=Fredoka:wght@500&display=swap" rel="stylesheet" />

  <style>
    body {
      margin: 0;
      padding: 0;
      height: 100vh;
      font-family: 'Fredoka', sans-serif;
      background: linear-gradient(135deg, #667eea, #764ba2);
      display: flex;
      align-items: center;
      justify-content: center;
    }

    .overlay {
      width: 90%;
      max-width: 1100px;
      display: flex;
      box-shadow: 0 0 40px rgba(0, 0, 0, 0.3);
      border-radius: 16px;
      overflow: hidden;
      background-color: rgba(255, 255, 255, 0.1);
      backdrop-filter: blur(20px);
      -webkit-backdrop-filter: blur(20px);
    }

    .left-panel {
      background-color: rgba(0, 0, 0, 0.6);
      color: white;
      width: 35%;
      padding: 40px 20px;
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;
    }

    .left-panel h2 {
      font-size: 2rem;
      margin-bottom: 0;
    }

    .left-panel small {
      margin-bottom: 30px;
      font-size: 14px;
    }

    .left-panel .role-btn {
      margin: 8px 0;
      width: 100%;
      font-weight: 600;
    }

    .right-panel {
      width: 65%;
      background-color: #fff;
      padding: 40px;
      display: flex;
      align-items: center;
      justify-content: center;
    }

    .form-box {
      width: 100%;
      max-width: 400px;
    }

    .form-box h5 {
      text-align: center;
      margin-bottom: 25px;
      font-weight: bold;
      color: #2e7d32;
    }

    .form-box input {
      border-radius: 8px;
    }

    .form-box .btn-info {
      background-color: #2e7d32;
      border: none;
    }

    .form-box .btn-info:hover {
      background-color: #1b5e20;
    }

    .form-toggle {
      text-align: center;
      font-size: 14px;
    }

    .form-toggle a {
      color: #2e7d32;
      text-decoration: none;
      font-weight: bold;
    }

    .form-toggle a:hover {
      text-decoration: underline;
    }
  </style>
</head>

<body>

  <div class="overlay">
    <!-- LEFT PANEL -->
    <div class="left-panel">
      <div class="logo text-center">
        <h2>Loan Portal</h2>
        <small>Loan Management System</small>
      </div>

      <h5 class="mb-3">Choose Role</h5>
      <button class="btn btn-outline-light role-btn" onclick="showForm('loginAdmin')">
        <i class="bi bi-shield-lock me-2"></i>Admin
      </button>
      <button class="btn btn-outline-light role-btn" onclick="showForm('loginOfficer')">
        <i class="bi bi-briefcase me-2"></i>Bank Officer
      </button>
      <button class="btn btn-outline-light role-btn" onclick="showForm('loginFarmer')">
        <i class="bi bi-person me-2"></i>Farmer
      </button>
    </div>

    <!-- RIGHT PANEL -->
    <div class="right-panel">
      <div class="form-box">

        <!-- Admin Login -->
        <form id="loginAdmin" class="form-role" method="post" action="AdminLogin">
          <h5>Admin Login</h5>
          <input type="hidden" name="role" value="Admin" />
          <div class="mb-3">
            <input type="email" class="form-control" placeholder="Email" name="email" required />
          </div>
          <div class="mb-3">
            <input type="password" class="form-control" placeholder="Password" name="password" required />
          </div>
          <div class="d-grid mb-3">
            <button class="btn btn-info" type="submit">Log In</button>
          </div>
        </form>

        <!-- Bank Officer Login -->
        <form id="loginOfficer" class="form-role" style="display:none;" method="post" action="OfficerLogin">
          <h5>Bank Officer Login</h5>
          <input type="hidden" name="role" value="Officer" />
          <div class="mb-3">
            <input type="email" class="form-control" placeholder="Email" name="email" required />
          </div>
          <div class="mb-3">
            <input type="password" class="form-control" placeholder="Password" name="password" required />
          </div>
          <div class="d-grid mb-3">
            <button class="btn btn-info" type="submit">Log In</button>
          </div>
        </form>

        <!-- Farmer Login -->
        <form id="loginFarmer" class="form-role" style="display:none;" method="post" action="FarmerLogin">
          <h5>Farmer Login</h5>
          <input type="hidden" name="role" value="Farmer" />
          <div class="mb-3">
            <input type="email" class="form-control" placeholder="Email" name="email" required />
          </div>
          <div class="mb-3">
            <input type="password" class="form-control" placeholder="Password" name="password" required />
          </div>
          <div class="d-grid mb-3">
            <button class="btn btn-info" type="submit">Log In</button>
          </div>
          <p class="form-toggle">Don’t have an account? <a href="#" onclick="showForm('registerFarmer')">Register here</a></p>
        </form>

        <!-- Farmer Register -->
        <form id="registerFarmer" class="form-role" style="display:none;" method="post" action="FarmerRegister">
          <h5>Farmer Registration</h5>
          <input type="hidden" name="role" value="Farmer" />
          <div class="mb-3">
            <input type="text" class="form-control" placeholder="Name" name="name" required />
          </div>
          <div class="mb-3">
            <input type="text" class="form-control" placeholder="Contact" name="contact" required />
          </div>
          <div class="mb-3">
            <input type="text" class="form-control" placeholder="Land Size (in acres)" name="landSize" required />
          </div>
          <div class="mb-3">
            <input type="email" class="form-control" placeholder="Email" name="email" required />
          </div>
          <div class="mb-3">
            <input type="password" class="form-control" placeholder="Password" name="password" required />
          </div>
          <div class="d-grid mb-3">
            <button class="btn btn-info" type="submit">Register</button>
          </div>
          <p class="form-toggle">Already registered? <a href="#" onclick="showForm('loginFarmer')">Login here</a></p>
        </form>

      </div>
    </div>
  </div>

  <!-- FORM SWITCH SCRIPT -->
  <script>
    function showForm(formId) {
      var forms = document.querySelectorAll('.form-role');
      forms.forEach(f => f.style.display = 'none');
      document.getElementById(formId).style.display = 'block';
    }

    window.addEventListener('DOMContentLoaded', function () {
      showForm('loginAdmin'); // default form
    });
  </script>

</body>

</html>
