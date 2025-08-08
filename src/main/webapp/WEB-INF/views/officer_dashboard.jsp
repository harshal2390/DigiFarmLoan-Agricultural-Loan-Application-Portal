<%@ page import="java.util.*" %>
<%@ page import="model.LoanAppications" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Loan Applications</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Officer dashboard</h1>
<div class="container mt-5">
    <h2>Loan Applications</h2>
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
            <tr>
                <th>Contact</th>
                <th>Farmer Contact ID</th>
                <th>Loan Amount</th>
                <th>Purpose</th>
                <th>Application Date</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="loan" items="${loanList}">
                <tr>
                    <td>${loan.contact}</td>
                    <td>${loan.farmerContactId}</td>
                    <td>${loan.loanAmount}</td>
                    <td>${loan.purpose}</td>
                    <td>${loan.applicationDate}</td>
                    <td>${loan.status}</td>
                    <td>
                        <c:choose>
                            <c:when test="${loan.status == 'Pending'}">
                                <form action="approveLoan" method="post" style="display:inline;">
                                    <input type="hidden" name="contact" value="${loan.contact}" />
                                    <button type="submit" class="btn btn-success btn-sm">Approve</button>
                                </form>
                                <form action="rejectLoan" method="post" style="display:inline;">
                                    <input type="hidden" name="contact" value="${loan.contact}" />
                                    <button type="submit" class="btn btn-danger btn-sm">Reject</button>
                                </form>
                            </c:when>
                            <c:otherwise>
                                <!-- Do nothing, buttons hidden -->
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
