<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>Claim Submission Confirmation</h1>
    <c:if test="${sessionScope.claimBean != null}">
        <p>Claim Number: ${sessionScope.claimBean.claimNumber}</p>
        <p>Policy Number: ${sessionScope.claimBean.policyNumber}</p>
        <p>Claimant Name: ${sessionScope.claimBean.claimantName}</p>
        <p>Claim Amount: ${sessionScope.claimBean.claimAmount}</p>
    </c:if>
    <p>Your claim has been submitted successfully.</p>
</body>
</html> 

